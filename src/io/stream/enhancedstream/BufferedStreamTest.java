package io.stream.enhancedstream;

import org.junit.Test;

import java.io.*;

/**
 * 以Stream结尾的类处理以字节为单位
 * BufferedInputStream/BufferedOutputStream 适用于处理文本文件和二进制文件（图片、视频）
 */
public class BufferedStreamTest {
    BufferedInputStream bufferedInputStream = null;
    BufferedOutputStream bufferedOutputStream = null;

    public void copyFile(String sourcePathname, String toPathname){
        try{
            File inputFile = new File(sourcePathname);
            File outputFile = new File(toPathname);
            if(!inputFile.exists()){
                System.out.println("source file is not exist!");
                return;
            }
            if(!outputFile.exists()){
                if(!outputFile.createNewFile()){
                    //如果文件里有中文读单个字节打印会出现乱码现象
                    System.out.println("dist file created failed!");
                    return;
                }
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(inputFile));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFile));
            byte[] buff = new byte[1024];
            int dataLen = 0;
            while((dataLen = bufferedInputStream.read(buff)) != -1){
                bufferedOutputStream.write(buff, 0, dataLen);
            }
            System.out.println("file copied successfully!");
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(bufferedInputStream != null){
                    bufferedInputStream.close();
                }
                if(bufferedOutputStream != null){
                    bufferedOutputStream.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Test
    public void copyTxt(){
        String source = "src\\io\\stream\\enhancedstream\\inputStreamFile.txt";
        String to = "src\\io\\stream\\enhancedstream\\outputStreamFile.txt";
        copyFile(source, to);
    }

    @Test
    public void copyImage(){
        String source = "src\\io\\stream\\baidu.webp";
        String to = "src\\io\\stream\\enhancedstream\\outputStreamCopy." + source.split("\\.")[1];
        copyFile(source, to);
    }
}
