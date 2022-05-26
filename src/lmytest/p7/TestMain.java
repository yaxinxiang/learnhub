package lmytest.p7;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestMain {
    @Test
    public void testSay(){
        assertEquals("Hello World!", new HelloWorld().say());
    }
}
