package gry_wojenne.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class General implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Soldier> army;
    private int goldCoins;
    private String name;

    public General(String name, int initialGoldCoins) {
        this.army = new ArrayList<>();
        this.goldCoins = initialGoldCoins;
        this.name = name;
    }

    public void recruitSoldier(Soldier soldier) {
        army.add(soldier);
    }

    // Przeprowadzanie manewrow
    public void conductDrills(int numberOfSoldiers, Secretary secretary) {
        if (numberOfSoldiers > army.size()) {
            numberOfSoldiers = army.size();
        }

        Random random = new Random();
        for (int i = 0; i < numberOfSoldiers; i++) {
            Soldier soldier = army.get(random.nextInt(army.size()));
            int cost = soldier.getRank().getValue();
            if (goldCoins >= cost) {
                soldier.gainExperience();
                goldCoins -= cost;
                secretary.logDrill(this.name, soldier, cost);
            }
        }
    }

    // Atak na przeciwnika
    public void attack(General opponent, Secretary secretary) {
        int myStrength = getArmyStrength();
        int opponentStrength = opponent.getArmyStrength();

        if (myStrength > opponentStrength) {
            this.winBattle(opponent, secretary);
        } else if (opponentStrength > myStrength) {
            opponent.winBattle(this, secretary);
        } else {
            this.executeRandomSoldier(secretary);
            opponent.executeRandomSoldier(secretary);
        }
    }

    // Wygrana bitwa
    private void winBattle(General opponent, Secretary secretary) {
        int goldWon = opponent.goldCoins / 10;
        opponent.goldCoins -= goldWon;
        this.goldCoins += goldWon;

        for (Soldier soldier : army) {
            if (soldier.isAlive()) {
                soldier.gainExperience();
                secretary.logBattleResult(this.name, soldier, true);
            }
        }

        for (Soldier soldier : opponent.army) {
            if (soldier.isAlive()) {
                soldier.decreaseExperience();
                secretary.logBattleResult(opponent.name, soldier, false);
            }
        }
    }

    private void executeRandomSoldier(Secretary secretary) {
        Random random = new Random();
        Soldier soldier = army.get(random.nextInt(army.size()));
        if (soldier.isAlive()) {
            soldier.decreaseExperience();
            secretary.logExecution(this.name, soldier);
        }
    }
    public void buySoldier(Soldier.Rank rank, Secretary secretary) {
        int cost = 10 * rank.getValue();
        if (goldCoins >= cost) {
            Soldier soldier = new Soldier(rank);
            recruitSoldier(soldier);
            goldCoins -= cost;
            secretary.logPurchase(this.name, soldier, cost);
        }
    }

    // Suma sily armii
    public int getArmyStrength() {
        return army.stream().filter(Soldier::isAlive).mapToInt(Soldier::getStrength).sum();
    }

    // Zapisywanie stanu generala
    public void saveState(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        }
    }

    // Wczytywanie stanu generala
    public static General loadState(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (General) ois.readObject();
        }
    }
    @Override
    public String toString() {
        return "General{" +
                "name='" + name + '\'' +
                ", army=" + army +
                ", goldCoins=" + goldCoins +
                '}';
    }
}