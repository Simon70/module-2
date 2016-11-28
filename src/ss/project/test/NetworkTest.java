package ss.project.test;

import org.junit.Before;
import org.junit.Test;
import ss.project.client.MulticastSocketClient;
import ss.project.server.MulticastSocketServer;

/**
 * Created by simon on 25.11.16.
 */

public class NetworkTest {
    private MulticastSocketServer server;
    private MulticastSocketClient client;

    private Thread serverThread;
    private Thread clientThread;

    @Before
    public void setup() {
        server = new MulticastSocketServer();
        client = new MulticastSocketClient();
        serverThread = new Thread(server);
        clientThread = new Thread(client);
    }

    @Test
    public void test() {
        clientThread.start();
        serverThread.start();
        while (serverThread.isAlive() || clientThread.isAlive()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}