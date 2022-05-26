package lmytest.p10;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestMain {
    Triangle triangle = new Triangle(2, 3, 4);
    Triangle tri1 = new Triangle(-1, -1, 101);
    Triangle tri2 = new Triangle(1, 2, 3);
    Triangle tri3 = new Triangle(2, 3, 4);
    Triangle tri4 = new Triangle(2, 2, 2);
    Triangle tri5 = new Triangle(2, 2, 3);

    @Test
    public void isTriangleTest(){
        //10分
        assertFalse(tri1.isTriangle(tri1));
        assertFalse(tri2.isTriangle(tri2));
        assertTrue(tri3.isTriangle(tri3));
    }

    @Test
    public void isTypeTest(){
        //8分
        assertEquals("", tri1.isType(tri1));
        assertEquals("不等边三角形", tri3.isType(tri3));
        assertEquals("等边三角形", tri4.isType(tri4));
        assertEquals("等腰三角形", tri5.isType(tri5));
    }

    @Test
    public void mainTest(){
        //2分
        Triangle.main(new String[]{"-1", "2", "4"});
        Triangle.main(new String[]{"3", "2", "4"});
    }

}
