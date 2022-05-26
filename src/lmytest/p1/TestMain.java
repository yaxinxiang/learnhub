package lmytest.p1;
//从import开始全选
import static org.junit.Assert.*;
import org.junit.Test;

public class TestMain {
    @Test
    public void testDelta1() {
        Delta delta=new Delta();
        assertEquals(true,delta.delta(1, 2, 1));
    }

    @Test
    public void testDelta2() {
        Delta delta=new Delta();
        assertEquals(false,delta.delta(1, 0, 1));
    }

}
