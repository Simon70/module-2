package ss.project.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MulticastSocketServer implements Runnable {

    public static void main(String[] args) throws UnknownHostException {
        new MulticastSocketServer().run();
    }

    @Override
    public void run() {
        try {
            DatagramSocket serverSocket = new DatagramSocket(6868, InetAddress.getByName("130.89.233.5"));
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            System.out.println("SERVER RECEIVED: " + new String(receivePacket.getData()));
            //byte[] sendData = "Message from Server!".getBytes();
            //DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
            //serverSocket.send(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
