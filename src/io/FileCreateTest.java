package io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileCreateTest {
    @Test
    public void createFile01(){
        String path = "src\\io\\file1.txt"; //根路径是项目路径
        File file  = new File(path);
        try{
            if(file.createNewFile()){//文件创建方法
                System.out.println("create success!");
            }else{
                System.out.println("file already exist!");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void CreateFile02(){
        File parentFile = new File(System.getProperty("user.dir"));//父目录文件(项目根目录)
        String filename = "src\\io\\file2.txt"; //相对路径
        File file = new File(parentFile, filename);
        try{
            if(file.createNewFile()){//文件创建方法
                System.out.println("create success!");
            }else{
                System.out.println("file already exist!");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void CreateFile03(){
        String parentPath = System.getProperty("user.dir");//父级目录（项目根目录）
        String child = "src\\io\\file3.txt";
        File file = new File(parentPath, child);
        try{
            if(file.createNewFile()){
                System.out.println("create success!");
            }else{
                System.out.println("file already exist!");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
