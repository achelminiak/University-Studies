package gry_wojenne.main;

import java.io.IOException;
import java.util.Random;

public class BattleGame {

    public static void main(String[] args) {
        // Inicjalizacja generałów
        General general1 = new General("General A", 100);
        General general2 = new General("General B", 100);

        // Inicjalizacja sekretarza
        Secretary secretary = new Secretary("battle_logs.txt");

        // Dodanie żołnierzy do armii generałów
        recruitInitialSoldiers(general1);
        recruitInitialSoldiers(general2);

        // Przebieg gry (symulacja działań generałów)
        conductActions(general1, general2, secretary);

        // Zapisanie stanu generałów
        saveGeneralsState(general1, general2);

        // Wczytanie stanu generałów
        loadGeneralsState(general1, general2);
    }

    // Metoda do rekrutowania początkowych żołnierzy
    private static void recruitInitialSoldiers(General general) {
        general.recruitSoldier(new Soldier(Rank.PRIVATE, 1));
        general.recruitSoldier(new Soldier(Rank.CORPORAL, 1));
        general.recruitSoldier(new Soldier(Rank.CAPTAIN, 1));
        general.recruitSoldier(new Soldier(Rank.MAJOR, 1));
    }

    // Metoda do przeprowadzenia akcji pomiędzy generałami
    private static void conductActions(General general1, General general2, Secretary secretary) {
        // Symulacja manewrów
        general1.conductDrills(3, secretary);
        general2.conductDrills(2, secretary);

        // Symulacja ataku
        general1.attack(general2, secretary);
    }

    // Metoda do zapisywania stanu generałów
    private static void saveGeneralsState(General general1, General general2) {
        try {
            general1.saveState("general1_state.ser");
            general2.saveState("general2_state.ser");
            System.out.println("Stan generałów został zapisany.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metoda do wczytywania stanu generałów
    private static void loadGeneralsState(General general1, General general2) {
        try {
            General loadedGeneral1 = General.loadState("general1_state.ser");
            General loadedGeneral2 = General.loadState("general2_state.ser");
            System.out.println("Załadowano stan generałów:");
            System.out.println("Generał 1: " + loadedGeneral1);
            System.out.println("Generał 2: " + loadedGeneral2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
