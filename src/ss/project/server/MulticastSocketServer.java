package ss.project.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.UnknownHostException;

public class MulticastSocketServer implements Runnable {

    public static void main(String[] args) throws UnknownHostException {
        new MulticastSocketServer().run();
    }


    @Override
    public void run() {
        try {
            DatagramSocket serverSocket = new DatagramSocket(1234);
            byte[] receiveData = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                System.out.println("RECEIVED: " + new String(receivePacket.getData()));
                byte[] sendData = "Message from Server!".getBytes();
                DatagramPacket sendPacket =
                        new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
                serverSocket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}