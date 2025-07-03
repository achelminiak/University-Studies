package test;

import main.MyDate;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyDateTest {
    @Test
    public void testValidDate() {
        MyDate date = new MyDate(28, 04, 2002);
        assertEquals(28, date.getDay());
        assertEquals(04, date.getMonth());
        assertEquals(2002, date.getYear());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDay() {
        MyDate date = new MyDate(32, 05, 2000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMonth() {
        MyDate date = new MyDate(01, 45, 2023);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidYear() {
        MyDate date = new MyDate(28, 06, 1222);
    }

    @Test
    public void testDisplayDate() {
        MyDate date = new MyDate(14, 02, 2024);
        assertEquals("14/02/2024", date.displayDate());
    }
}
