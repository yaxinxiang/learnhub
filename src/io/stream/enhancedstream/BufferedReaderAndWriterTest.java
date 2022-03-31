package io.stream.enhancedstream;

import org.junit.Test;

import java.io.*;

/**
 * Reader or Writer 结尾的类处理以字符为单位，适用于处理文本等类型
 */
public class BufferedReaderAndWriterTest {
    BufferedReader bufferedReader = null;
    BufferedWriter bufferedWriter = null;

    @Test
    public void copyFile(){
        try{
            File inputFile = new File("src\\io\\stream\\enhancedstream\\testFile.txt");
            File outputFile = new File("src\\io\\stream\\enhancedstream\\outputFile.txt");
            if(!inputFile.exists()){
                System.out.println("source file is not exist!");
                return;
            }
            if(!outputFile.exists()){
                if(!outputFile.createNewFile()){
                    System.out.println("dist file created failed!");
                    return;
                }
            }
            bufferedReader = new BufferedReader(new FileReader(inputFile));
            bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
            String buff = null;
            while((buff = bufferedReader.readLine()) != null){
                bufferedWriter.write(buff);
                bufferedWriter.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(bufferedReader != null){
                    bufferedReader.close();
                }
                if(bufferedWriter != null){
                    bufferedWriter.close();
                }
                System.out.println("file copy success!");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
