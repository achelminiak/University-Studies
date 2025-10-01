package gry_wojenne.main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BattleGameTest {
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
    public void testBattleGame() throws IOException {
        Soldier soldier1 = new Soldier(Rank.PRIVATE, 2); // Higher strength soldier for General 1
        Soldier soldier2 = new Soldier(Rank.PRIVATE, 1); // Lower strength soldier for General 1
        Soldier soldier3 = new Soldier(Rank.PRIVATE, 1); // Lower strength soldier for General 2
        general1.recruitSoldier(soldier1);
        general1.recruitSoldier(soldier2);
        general2.recruitSoldier(soldier3);

        BattleGame battleGame = new BattleGame(general1, general2, secretary);
        battleGame.simulateBattle();

        assertTrue(general1.getGoldCoins() > 100); // General 1 should win and gain gold
        assertTrue(general1.getArmy().size() > 1); // General 1 should still have more soldiers
        assertTrue(general2.getGoldCoins() < 100); // General 2 should lose gold
        assertTrue(general2.getArmy().size() < 1); // General 2 should lose all soldiers
    }
}
