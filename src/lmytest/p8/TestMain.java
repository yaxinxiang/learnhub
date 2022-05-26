package lmytest.p8;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestMain {
    private SayYourName sayYourName;
    @Before
    public void setUp(){
        sayYourName = new SayYourName();
    }
    @Test
    public void testGetAndSay(){
        assertEquals("Hi,Teacher", sayYourName.getAndSay("LiMeiYi"));
        assertEquals("Hi,Welcome!", sayYourName.getAndSay("SLiMeiYiB"));
    }
}
