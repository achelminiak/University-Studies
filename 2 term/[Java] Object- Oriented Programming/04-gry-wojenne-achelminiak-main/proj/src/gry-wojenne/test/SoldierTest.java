package gry_wojenne.main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SoldierTest {
    private Soldier soldier;

    @BeforeEach
    public void setUp() {
        soldier = new Soldier(Rank.PRIVATE, 1);
    }

    @Test
    public void testInitialExperience() {
        assertEquals(1, soldier.getExperience());
    }

    @Test
    public void testGainExperience() {
        soldier.gainExperience();
        assertEquals(2, soldier.getExperience());
    }

    @Test
    public void testExperienceResetOnPromotion() {
        soldier.setExperience(4);
        soldier.gainExperience();
        assertEquals(1, soldier.getExperience());
    }

    @Test
    public void testPromotion() {
        soldier.setExperience(4);
        soldier.gainExperience();
        assertEquals(Rank.CORPORAL, soldier.getRank());
    }

    @Test
    public void testStrengthCalculation() {
        assertEquals(1, soldier.getStrength());
        soldier.setExperience(5);
        assertEquals(2, soldier.getStrength());
    }

    @Test
    public void testIsAlive() {
        assertTrue(soldier.isAlive());
    }

    @Test
    public void testDecreaseExperience() {
        soldier.decreaseExperience();
        assertEquals(0, soldier.getExperience());
    }
}
