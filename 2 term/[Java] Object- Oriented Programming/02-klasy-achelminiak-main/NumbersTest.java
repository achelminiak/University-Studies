import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumbersTest {
    private Numbers numbers;

    @Before
    public void setUp() {
        numbers = new Numbers(10, 20, 30);
    }

    @Test
    public void testSum() {
        Assert.assertEquals(60, numbers.sum());
    }

    @Test
    public void testAverage() {
        Assert.assertEquals(20.0, numbers.average(), 0.001);
    }

    @Test
    public void testMin() {
        Assert.assertEquals(10, numbers.min());
    }

    @Test
    public void testMax() {
        Assert.assertEquals(30, numbers.max());
    }

    @Test
    public void testGeometric() {
        Assert.assertEquals(15.848, numbers.geometric(), 0.001);
    }
}
