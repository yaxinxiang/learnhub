package io;

import org.junit.Test;

import java.io.File;

public class DirectoryTest {

    @Test
    public void f1(){
        //判断文件file1.txt是否存在,存在就删除
        File file = new File("src\\io\\file1.txt");
        if(file.exists()){
            if(file.delete()){
                System.out.println("delete success!");
            }else{
                System.out.println("delete failed!");
            }
        }else {
            System.out.println("file not exist!");
        }
    }

    @Test
    public void f2(){
        //判断文件目录是否存在,存在就删除
        File file = new File("src\\io\\iotest");
        if(file.exists()){
            if(file.delete()){
                System.out.println("delete directory success!");
            }else{
                System.out.println("delete directory failed!");
            }
        }else {
            System.out.println("the " + file.getName() + " directory not exist!");
        }
    }

    @Test
    public void f3(){
        //判断相对目录src\\io\\testdir是否存在，存在提示存在，否则创建
        File file = new File("src\\io\\testdir");
        if(file.exists()){
            System.out.println(file.getName() + " is already exist!");
        }else{
            if(file.mkdirs()){
                System.out.println(file.getName() + " create success!");
            }else{
                System.out.println(file.getName() + " create failed!");
            }
        }
    }

    @Test
    public void test(){
        System.out.println(this.getClass().getResource("/").getPath());
    }
}
