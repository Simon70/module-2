package ss.project.server;


import ss.project.shared.IStartStop;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * Created by simon on 07.12.16.
 */
public class NetworkSync implements IStartStop {

    private boolean isRunning;
    private ServerSocket serverSocket;
    private List<Socket> sockets;

    public NetworkSync() {
        isRunning = true;
    }

    private synchronized void addSocket(Socket socket) {
        sockets.add(socket);
    }

    private synchronized void rmSocket(Socket socket) {
        sockets.remove(socket);
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(1234);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        isRunning = false;
    }

    private class ServerSocketListener implements Runnable {

        @Override
        public void run() {
            while (isRunning) {

            }

        }
    }

    private class ClientEventListener implements Runnable {

        @Override
        public void run() {
            while (isRunning) {

            }
        }
    }
}
