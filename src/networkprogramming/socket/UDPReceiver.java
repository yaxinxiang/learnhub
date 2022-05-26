package networkprogramming.socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver {
    public static void main(String[] args) throws  Exception{
        DatagramSocket datagramSocket = new DatagramSocket(9999);

        byte[] buffer = new byte[64 * 1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
        while(true){
            datagramSocket.receive(datagramPacket);
            System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
        }
    }
}
