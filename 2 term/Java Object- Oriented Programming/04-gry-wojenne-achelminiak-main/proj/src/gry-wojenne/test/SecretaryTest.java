package gry_wojenne.main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecretaryTest {
    private Secretary secretary;
    private StringWriter stringWriter;
    private BufferedWriter bufferedWriter;

    @BeforeEach
    public void setUp() throws IOException {
        stringWriter = new StringWriter();
        bufferedWriter = new BufferedWriter(stringWriter);
        secretary = new Secretary(bufferedWriter);
    }

    @Test
    public void testLogDrill() throws IOException {
        Soldier soldier = new Soldier(Rank.PRIVATE, 1);
        secretary.logDrill("General A", soldier, 10);
        bufferedWriter.flush();
        assertEquals("General A przeprowadzil manewry z Soldier(rank=PRIVATE, experience=1) o sile 1 za 10 monet.", stringWriter.toString().trim());
    }

    @Test
    public void testLogBattleResultWon() throws IOException {
        Soldier soldier = new Soldier(Rank.PRIVATE, 1);
        secretary.logBattleResult("General A", soldier, true);
        bufferedWriter.flush();
        assertEquals("General A wygral bitwe, Soldier(rank=PRIVATE, experience=1) o sile 1 zdobyl doswiadczenie.", stringWriter.toString().trim());
    }

    @Test
    public void testLogBattleResultLost() throws IOException {
        Soldier soldier = new Soldier(Rank.PRIVATE, 1);
        secretary.logBattleResult("General A", soldier, false);
        bufferedWriter.flush();
        assertEquals("General A przegral bitwe, Soldier(rank=PRIVATE, experience=1) o sile 1 stracil doswiadczenie.", stringWriter.toString().trim());
    }

    @Test
    public void testLogExecution() throws IOException {
        Soldier soldier = new Soldier(Rank.PRIVATE, 1);
        secretary.logExecution("General A", soldier);
        bufferedWriter.flush();
        assertEquals("General A stracil Soldier(rank=PRIVATE, experience=1) o sile 1.", stringWriter.toString().trim());
    }

    @Test
    public void testLogPurchase() throws IOException {
        Soldier soldier = new Soldier(Rank.PRIVATE, 1);
        secretary.logPurchase("General A", soldier, 10);
        bufferedWriter.flush();
        assertEquals("General A kupil Soldier(rank=PRIVATE, experience=1) o sile 1 za 10 monet.", stringWriter.toString().trim());
    }
}
