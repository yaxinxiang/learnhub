package lmytest.p19;


import org.junit.Test;

import static org.junit.Assert.*;

public class TestMain {
    @Test
    public void CalcFunTest(){
        CalcRootClass cal = new CalcRootClass();
        assertEquals("", cal.CalcFun(0, 1,1)); // a == 0
        assertEquals("二个复根,实部和虚部分别为\nx1=-0.0,x2=1.0\n", cal.CalcFun(1, 0, 1)); // mid < 0
        assertEquals("一个二重实根\nx1=-1.0,x2=-1.0\n", cal.CalcFun(1, 2, 1)); //mid == 0
        assertEquals("二个实根\nx1=-0.12701665379258298,x2=-7.872983346207417\n", cal.CalcFun(1, 8, 1));
    }
}
