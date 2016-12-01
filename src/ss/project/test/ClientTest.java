package ss.project.test;

import ss.project.client.MulticastSocketClient;

/**
 * Created by simon on 01.12.16.
 */
public class ClientTest {
    private static MulticastSocketClient client;
    private static Thread clientThread;


    public static void main(String[] args) {
        client = new MulticastSocketClient();
        clientThread = new Thread(client);
        clientThread.setDaemon(false);
        clientThread.start();
    }
}
