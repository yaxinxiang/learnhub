package networkprogramming.filetrans;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPUploadClient {
    public static void main(String[] args) throws Exception {
        String parentPath = System.getProperty("user.dir");
        String child = "\\src\\networkprogramming\\filetrans\\testfile.txt";
        String path = parentPath + child;
        byte[] buffer = new byte[1024];
        int len = -1;
        BufferedInputStream fileBufferedInputStream = new BufferedInputStream(new FileInputStream(path));

        Socket socket = new Socket(InetAddress.getLocalHost(), 9000);
        OutputStream socketOutputStream = socket.getOutputStream();
        BufferedOutputStream socketBufferedOutputStream = new BufferedOutputStream(socketOutputStream);

        System.out.println("开始发送文件...");
        while((len = fileBufferedInputStream.read(buffer)) != -1){
            socketBufferedOutputStream.write(buffer, 0, len);
        }
        System.out.println("文件发送完毕...");
        socketBufferedOutputStream.close();
        fileBufferedInputStream.close();
        socket.close();
    }
}
