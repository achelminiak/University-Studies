package gry_wojenne.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class Secretary implements Serializable {
    private static final long serialVersionUID = 1L;
    private String reportFilename;

    public Secretary(String reportFilename) {
        this.reportFilename = reportFilename;
    }

    public void logDrill(String generalName, Soldier soldier, int cost) {
        int soldierStrength = soldier.getStrength();
        writeToFile(generalName + " przeprowadzil manewry z " + soldier + " o sile " + soldierStrength + " za " + cost + " monet.");
    }

    public void logBattleResult(String generalName, Soldier soldier, boolean won) {
        int soldierStrength = soldier.getStrength();
        if (won) {
            writeToFile(generalName + " wygral bitwe, " + soldier + " o sile " + soldierStrength + " zdobyl doswiadczenie.");
        } else {
            writeToFile(generalName + " przegral bitwe, " + soldier + " o sile " + soldierStrength + " stracil doswiadczenie.");
        }
    }

    public void logExecution(String generalName, Soldier soldier) {
        int soldierStrength = soldier.getStrength();
        writeToFile(generalName + " stracil " + soldier + " o sile " + soldierStrength + ".");
    }

    public void logPurchase(String generalName, Soldier soldier, int cost) {
        writeToFile(generalName + " kupil " + soldier + " o sile " + soldier.getStrength() + " za " + cost + " monet.");
    }

    // Metoda do zapisywania logów do pliku
    private void writeToFile(String log) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportFilename, true))) {
            writer.write(log);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
