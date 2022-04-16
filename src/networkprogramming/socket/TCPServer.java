package networkprogramming.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("TCP服务， 端口9999 开启...");
        Socket acceptSocket = serverSocket.accept();
        InputStream inputStream = acceptSocket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

        OutputStream outputStream = acceptSocket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        while(true){
            String s = bufferedReader.readLine();
            System.out.println(s);
            if(s.equals("exit")){
                break;
            }
            bufferedWriter.write("server back: " + s);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        bufferedWriter.close();
        bufferedReader.close();
        acceptSocket.close();
    }
}
