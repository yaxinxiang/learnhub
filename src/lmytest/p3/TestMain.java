package lmytest.p3;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestMain {
    private NextDate nextDate;
    @Before
    public void setUp() throws Exception {
        nextDate = new NextDate();
    }

    @Test
    public void testleapYear1() {
        nextDate.leapYear(400);
        assertEquals(true, nextDate.getResult());
    }

    @Test
    public void testleapYear2() {
        nextDate.leapYear(4);
        assertEquals(true, nextDate.getResult());
    }

    @Test
    public void testleapYear3() {
        nextDate.leapYear(100);
        assertEquals(false, nextDate.getResult());
    }

}
