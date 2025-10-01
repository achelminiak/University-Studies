package gry-wojenne.main

import java.io.Serializable;

public class Soldier implements Serializable {
    private static final long serialVersionUID = 1L;

    public enum Rank {
        SZEREGOWY(1),
        KAPRAL(2),
        KAPITAN(3),
        MAJOR(4);

        private final int value;

        Rank(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Rank rank;
    private int experience;

    public Soldier(Rank rank) {
        this.rank = rank;
        this.experience = 0;
    }

    public void gainExperience() {
        experience++;
        if (experience % (rank.getValue() * 5) == 0) {
            promote();
        }
    }

    private void promote() {
        switch (rank) {
            case SZEREGOWY:
                rank = Rank.KAPRAL;
                break;
            case KAPRAL:
                rank = Rank.KAPITAN;
                break;
            case KAPITAN:
                rank = Rank.MAJOR;
                break;
            case MAJOR:
                break;
        }
        experience = 1;
    }

    public boolean isAlive() {
        return experience > 0;
    }

    public int getStrength() {
        return rank.getValue() * experience;
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "rank=" + rank +
                ", experience=" + experience +
                '}';
    }
}
