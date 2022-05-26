package networkprogramming.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        /**
         * 1. 创建客户端Socket，设置目的ip地址，和端口
         * 2. 从socket中拿到OutputStream/InputStream
         * 3. 使用BufferedWriter/BufferedReader操作从socket中拿到的OutputStream/InputStream
         */
        Scanner sc = new Scanner(System.in);
        Socket clientSocket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = clientSocket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));

        InputStream inputStream = clientSocket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while(true){
            String s = sc.nextLine();
            bufferedWriter.write(s);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            if(s.equals("exit")){
                break;
            }
            System.out.println(bufferedReader.readLine());
        }
        bufferedReader.close();
        bufferedWriter.close();
        clientSocket.close();
        sc.close();
    }
}
