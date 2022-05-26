package lmytest.p4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMain {

    @Before
    public void setUp() throws Exception {
    }

    @Test(timeout = 4000)
    public void test0() throws Throwable {
        String string0 = StringNormalize.normalize("#d0::&Ghk\"hS~L");
        assertEquals("d0ghkhsl", string0);
    }

    @Test(timeout = 4000)
    public void test1() throws Throwable {
        String string0 = StringNormalize.normalize("%P/1Rx}BT~H$R;A+Hg");
        assertEquals("p1rxbthrahg", string0);
    }

    @Test(timeout = 4000)
    public void test2() throws Throwable {
        String string0 = StringNormalize.normalize("");
        assertEquals("", string0);
    }

    @Test(timeout = 4000, expected = NullPointerException.class)
    public void test4() throws Throwable {
        // Undeclared exception!
        StringNormalize.normalize((String) null);
        fail("Expecting exception: NullPointerException");
    }

    @Test(timeout = 4000)
    public void test7() throws Throwable {
        String string0 = StringNormalize.normalize("> h[1QY#+'9vWzL1M|h");
        assertEquals("h1qy9vwzl1mh", string0);
    }

    @Test(timeout = 4000)
    public void test8() throws Throwable {
        StringNormalize utils0 = new StringNormalize();
    }
}
