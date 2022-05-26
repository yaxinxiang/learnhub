package lmytest.p9;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMain {
    @Test(expected = Exception.class)
    public void test() throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.add(1, 2));
        assertEquals(-1, calculator.minus(1, 2));
        assertEquals(2, calculator.multiply(1, 2));
        assertEquals(2, calculator.divide(2,  1));
        calculator.divide(2,  0);
    }
}
