package networkprogramming.filetrans;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPUploadServer {
    public static void main(String[] args) throws Exception{
        String parentPath = System.getProperty("user.dir");
        String child = "\\src\\networkprogramming\\filetrans\\copiedFile.txt";
        String path = parentPath + child;
        File file = new File(path);
        BufferedOutputStream fileBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));

        byte[] buffer = new byte[1024];
        int len = -1;

        ServerSocket serverSocket = new ServerSocket(9000);
        Socket acceptSocket = serverSocket.accept();

        InputStream serverInputStream = acceptSocket.getInputStream();
        BufferedInputStream serverBufferedInputStream = new BufferedInputStream(serverInputStream);
        System.out.println("开始接受文件...");
        while((len = serverBufferedInputStream.read(buffer)) != -1){
            fileBufferedOutputStream.write(buffer, 0, len);
            fileBufferedOutputStream.flush();
        }
        System.out.println("文件接受完成...");
        serverBufferedInputStream.close();
        fileBufferedOutputStream.close();
        acceptSocket.close();
        serverSocket.close();
    }
}
