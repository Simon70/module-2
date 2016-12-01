package ss.project.server;

import ss.project.shared.Network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class MulticastSocketServer implements Runnable {

    public static void main(String[] args) {
        try {
            System.out.println(Network.getMulticastInterfaces().size());
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String msg = "test";
            DatagramSocket serverSocket = new DatagramSocket(1234);
            serverSocket.setBroadcast(true);
            DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length);
            serverSocket.send(msgPacket);
            serverSocket.close();
        } catch (

                IOException ex) {
            ex.printStackTrace();
        }
    }
}