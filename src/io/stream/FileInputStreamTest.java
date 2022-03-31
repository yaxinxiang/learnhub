package io.stream;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamTest {

    /**
     * 单个字节读取，效率低
     * 单个字节读取在打印出来后可能会失真，因为中文字符不是由单个字节组成的
     */
    @Test
    public void read01() {
        File file = new File("src\\io\\stream\\inputFile.txt");
        int readData = 0;
        InputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream(file);
            while((readData = fileInputStream.read()) != -1){
                System.out.print((char) readData);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取多个字节
     * 使用buff[]数组，每以buff.length个字节为单位读取，每次读取返回读取的字节数
     */
    @Test
    public void read02(){
        File file = new File("src\\io\\stream\\inputFile.txt");
        int readLen = 0;
        byte[] buff = new byte[8];
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream(file);
            while((readLen = fileInputStream.read(buff)) != -1){
                System.out.print(new String(buff, 0, readLen));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
