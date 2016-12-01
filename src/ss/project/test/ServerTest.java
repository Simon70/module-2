package ss.project.test;

import ss.project.server.MulticastSocketServer;

/**
 * Created by simon on 01.12.16.
 */
public class ServerTest {

    private static MulticastSocketServer server;
    private static Thread serverThread;


    public static void main(String[] args) {
        server = new MulticastSocketServer();
        serverThread = new Thread(server);
        serverThread.setDaemon(false);
        serverThread.start();
    }
}
