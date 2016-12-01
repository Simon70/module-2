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
            String msg = "test";
            DatagramSocket serverSocket = new DatagramSocket();
            serverSocket.setBroadcast(true);
            DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, InetAddress.getByName("255.255.255.255"), 1234);
            serverSocket.send(msgPacket);
            serverSocket.close();
        } catch (

                IOException ex) {
            ex.printStackTrace();
        }
    }
}