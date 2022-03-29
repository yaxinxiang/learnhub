package io.stream;

import org.junit.Test;

import java.io.*;

public class FileReaderAndWriterTest {
    Reader fileReader = null;
    Writer fileWriter = null;

    /**
     * 使用FileReader 与 FileWriter 读取写入文件达到复制文件的目的
     * 其中本方法由于是以字符为单位故中文不会乱码
     */
    @Test
    public void reader01() {
        File inputFile = new File("src\\io\\stream\\inputFile02.txt");
        File outputFile = new File("src\\io\\stream\\outputFile02.txt");
        if (!inputFile.exists()) {
            System.out.println("source file is not exist!");
            return;
        }
        try {
            if (!outputFile.exists()) {
                if (!outputFile.createNewFile()) {
                    System.out.println("create new file failed!");
                }
            }
            fileReader = new FileReader(inputFile);
            fileWriter = new FileWriter(outputFile);
            int readData = 0;
            while ((readData = fileReader.read()) != -1) {
                fileWriter.write(readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("file copy success!");
        }
    }

    /**
     * 使用FileReader 与 FileWriter 读取写入文件达到复制文件的目的
     * 加入buff数组加快读取效率
     * 其中本方法由于是以字符为单位故中文不会乱码
     */
    @Test
    public void reader02() {
        File inputFile = new File("src\\io\\stream\\inputFile02.txt");
        File outputFile = new File("src\\io\\stream\\outputFile02.txt");
        if (!inputFile.exists()) {
            System.out.println("source file is not exist!");
            return;
        }
        try {
            if (!outputFile.exists()) {
                if (!outputFile.createNewFile()) {
                    System.out.println("create new file failed!");
                }
            }
            fileReader = new FileReader(inputFile);
            fileWriter = new FileWriter(outputFile);
            char[] chars = new char[8];
            int readLen = 0;
            while ((readLen = fileReader.read(chars)) != -1) {
                fileWriter.write(chars, 0, readLen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("file copy success!");
        }
    }
}
