package io.stream.objectstream;

import org.junit.Test;

import java.io.*;

public class ObjectStreamTest {

    @Test
    public void writeObject() throws IOException {
        File outputFile = new File("src\\io\\stream\\objectstream\\obj.txt");
        if(!outputFile.exists()){
            if(!outputFile.createNewFile()){
                System.out.println("create file failed!");
            }
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile));
        oos.writeObject(new TestObject(1, "testObj", 999.999));
        oos.close();
        System.out.println("write obj in obj.txt over");
    }

    @Test
    public void readTest() throws IOException, ClassNotFoundException {
        File inputFile = new File("src\\io\\stream\\objectstream\\obj.txt");
        if(!inputFile.exists()){
            System.out.println("inputFile is not exist!");
        }
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile));
        Object obj = ois.readObject();
        if(obj instanceof TestObject){
            System.out.println((TestObject)obj);
        }
    }
}
