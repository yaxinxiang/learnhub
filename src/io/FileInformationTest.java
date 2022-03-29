package io;

import org.junit.Test;

import java.io.File;

public class FileInformationTest {

    @Test
    public void info(){
        File file = new File("src\\io\\file1.txt");
        System.out.println("文件名：" + file.getName());
        System.out.println("绝对路径："+ file.getAbsolutePath());
        System.out.println("父级目录：" + file.getParent());
        System.out.println("文件大小（字节）：" + file.length());
        System.out.println("是否为文件：" + file.isFile());
        System.out.println("是否为路径：" + file.isDirectory());
    }
}
