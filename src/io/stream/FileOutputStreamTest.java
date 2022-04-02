package io.stream;

import org.junit.Test;

import java.io.*;

public class FileOutputStreamTest {
    InputStream fileInputStream = null;
    OutputStream fileOutputStream = null;

    /**
     * 从inputFile逐个读取单个字符并将其写入outputFile.txt
     */
    @Test
    public void copyFileTest01() {
        File inputFile = new File("src\\io\\stream\\inputFile.txt");
        File outputFile = new File("src\\io\\stream\\outputFile.txt");
        if (!inputFile.exists()) {
            System.out.println("source file not exist!");
            return;
        }
        if (!outputFile.exists()) {
            try {
                if (!outputFile.createNewFile()) {
                    System.out.println("dist file created failed!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int readData = 0;
        try {
            fileInputStream = new FileInputStream(inputFile);
            fileOutputStream = new FileOutputStream(outputFile);
            while ((readData = fileInputStream.read()) != -1) {
                fileOutputStream.write(readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("file copy success!");
        }
    }

    /**
     * 每次以buff数组为单位读取数据并写入copyBaidu.webp
     */
    @Test
    public void copyFileTest02() {
        File inputFile = new File("src\\io\\stream\\baidu.webp");
        File outputFile = new File("src\\io\\stream\\copyBaidu.webp");

        byte[] buff = new byte[1024];
        if (!inputFile.exists()) {
            System.out.println("source file not exist!");
            return;
        }
        if (!outputFile.exists()) {
            try {
                if (!outputFile.createNewFile()) {
                    System.out.println("dist file created failed!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int readLen = 0;
        try {
            fileInputStream = new FileInputStream(inputFile);
            fileOutputStream = new FileOutputStream(outputFile);
            while ((readLen = fileInputStream.read(buff)) != -1) {
                fileOutputStream.write(buff, 0, readLen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("file copy success!");
        }
    }
}
