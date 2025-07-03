package gry_wojenne.main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeneralTest {
    private General general1;
    private General general2;
    private Secretary secretary;
    private StringWriter stringWriter;
    private BufferedWriter bufferedWriter;

    @BeforeEach
    public void setUp() throws IOException {
        general1 = new General("General A", 100);
        general2 = new General("General B", 100);
        secretary = new Secretary(bufferedWriter);
        stringWriter = new StringWriter();
        bufferedWriter = new BufferedWriter(stringWriter);
    }

    @Test
    public void testConductDrills() throws IOException {
        Soldier soldier = new Soldier(Rank.PRIVATE, 1);
        general1.recruitSoldier(soldier);
        general1.conductDrills(1, secretary);
        assertEquals(0, general1.getGoldCoins());
        assertEquals(2, soldier.getExperience());
        assertEquals("General A przeprowadzil manewry z Soldier(rank=PRIVATE, experience=2) o sile 2 za 1 monet.", stringWriter.toString().trim());
    }

    @Test
    public void testAttackWin() throws IOException {
        Soldier soldier1 = new Soldier(Rank.PRIVATE, 2);
        Soldier soldier2 = new Soldier(Rank.PRIVATE, 1);
        general1.recruitSoldier(soldier1);
        general2.recruitSoldier(soldier2);
        general1.attack(general2, secretary);
        assertTrue(general1.getGoldCoins() > 100);
        assertEquals(2, soldier1.getExperience());
        assertEquals(0, soldier2.getExperience());
    }

    @Test
    public void testAttackLose() throws IOException {
        Soldier soldier1 = new Soldier(Rank.PRIVATE, 1);
        Soldier soldier2 = new Soldier(Rank.PRIVATE, 2);
        general1.recruitSoldier(soldier1);
        general2.recruitSoldier(soldier2);
        general1.attack(general2, secretary);
        assertTrue(general2.getGoldCoins() > 100);
        assertEquals(0, soldier1.getExperience());
        assertEquals(2, soldier2.getExperience());
    }

    @Test
    public void testAttackDraw() throws IOException {
        Soldier soldier1 = new Soldier(Rank.PRIVATE, 1);
        Soldier soldier2 = new Soldier(Rank.PRIVATE, 1);
        general1.recruitSoldier(soldier1);
        general2.recruitSoldier(soldier2);
        general1.attack(general2, secretary);
        assertEquals(1, soldier1.getExperience());
        assertEquals(1, soldier2.getExperience());
    }

    @Test
    public void testBuySoldier() throws IOException {
        general1.buySoldier(Rank.CORPORAL, secretary);
        assertEquals(90, general1.getGoldCoins());
        assertEquals(1, general1.getArmy().size());
        assertEquals("General A kupil Soldier(rank=CORPORAL, experience=1) o sile 2 za 20 monet.", stringWriter.toString().trim());
    }

    @Test
    public void testSaveAndLoadState() throws IOException, ClassNotFoundException {
        Soldier soldier = new Soldier(Rank.PRIVATE, 1);
        general1.recruitSoldier(soldier);
        general1.saveState("general1_state.ser");
        General loadedGeneral1 = General.loadState("general1_state.ser");
        assertEquals("General A", loadedGeneral1.getName());
        assertEquals(100, loadedGeneral1.getGoldCoins());
        assertEquals(1, loadedGeneral1.getArmy().size());
    }
}
