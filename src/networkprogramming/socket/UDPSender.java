package networkprogramming.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UDPSender {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        DatagramSocket datagramSocket = new DatagramSocket(9998);
        while(true){
            String input = sc.nextLine();
            byte[] buf = input.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.123.229"), 9999);
            datagramSocket.send(datagramPacket);
        }
    }
}
