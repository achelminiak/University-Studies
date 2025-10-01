import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClockTest {
    private Clock clock;

    @Before
    public void setUp() {
        clock = new Clock();
    }

    @Test
    public void testDefaultConstructor() {
        Assert.assertEquals(12, clock.getHours());
        Assert.assertEquals(0, clock.getMinutes());
        Assert.assertEquals(0, clock.getSeconds());
    }

    @Test
    public void testParameterizedConstructor() {
        Clock clock2 = new Clock(10, 30, 45);
        Assert.assertEquals(10, clock2.getHours());
        Assert.assertEquals(30, clock2.getMinutes());
        Assert.assertEquals(45, clock2.getSeconds());
    }

    @Test
    public void testSecondsConstructor() {
        Clock clock3 = new Clock(3661); // 1 godzina, 1 minuta i 1 sekunda
        Assert.assertEquals(1, clock3.getHours());
        Assert.assertEquals(1, clock3.getMinutes());
        Assert.assertEquals(1, clock3.getSeconds());
    }

    @Test
    public void testTick() {
        clock.tick();
        Assert.assertEquals("[12:00:01]", clock.toString());
    }

    @Test
    public void testTickDown() {
        clock.tickDown();
        Assert.assertEquals("[11:59:59]", clock.toString());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("[12:00:00]", clock.toString());
    }
}
