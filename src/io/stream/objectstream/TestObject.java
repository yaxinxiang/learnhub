package io.stream.objectstream;

import java.io.Serializable;

public class TestObject implements Serializable {
    int testInt;
    String testString;
    Double testDouble;
    int serialVersionUID = 101;

    public TestObject(int testInt, String testString, Double testDouble) {
        this.testInt = testInt;
        this.testString = testString;
        this.testDouble = testDouble;
    }

    @Override
    public String toString() {
        return "TestObject{" +
                "testInt=" + testInt +
                ", testString='" + testString + '\'' +
                ", testDouble=" + testDouble +
                '}';
    }
}
