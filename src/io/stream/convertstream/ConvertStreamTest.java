package io.stream.convertstream;

import org.junit.Test;

import java.io.*;

/**
 * 使用OutputStreamWriter和InputStreamReader将字节流以指定的编码方式转换成字符流
 * 对文件进行读的时候使用BufferedReader快速读
 */
public class ConvertStreamTest {

    @Test
    public void convertWriteGBK() throws IOException {
        File outputFile = new File("src\\io\\stream\\convertstream\\convert.txt");
        if(!outputFile.exists() && !outputFile.createNewFile()){
            System.out.println("create outputFile failed!");
        }
        OutputStreamWriter opsw = new OutputStreamWriter(new FileOutputStream(outputFile), "gbk");
        opsw.write("this is a GBK file!\n这是一个gbk编码文件！");
        opsw.close();
        System.out.println("写入完成~");
    }

    @Test
    public void convertReadGBk() throws IOException {
        File inputFile = new File("src\\io\\stream\\convertstream\\convert.txt");
        if(!inputFile.exists()){
            System.out.println("the inputFile is not exist!");
        }
        InputStreamReader ipsr = new InputStreamReader(new FileInputStream(inputFile), "gbk");
        BufferedReader bufferedReader = new BufferedReader(ipsr);
        String s;
        while((s = bufferedReader.readLine()) != null){
            System.out.println(s);
        }
        bufferedReader.close();
    }
}
