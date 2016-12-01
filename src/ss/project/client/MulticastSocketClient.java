package ss.project.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastSocketClient implements Runnable {

    @Override
    public void run() {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            byte[] sendData = "Message from Client!".getBytes();
            byte[] receiveData = new byte[1024];
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("255.255.255.255"), 1234);
            clientSocket.send(sendPacket);
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            System.out.println("FROM SERVER:" + new String(receivePacket.getData()));
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}