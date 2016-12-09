package ss.project.server;

import ss.project.shared.IThread;
import ss.project.shared.ui.ServerTUI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by simon on 09.12.16.
 */
public class Controller implements IThread {
    private IThread network;
    private IThread ui;

    private Thread tNetwork;
    private Thread tUI;
    private Thread tController;
    private ExecutorService tEngines;

    private boolean isRunning = true;

    public static void main(String[] args) throws InterruptedException {
        Controller controller = new Controller();
        controller.setup();
        Thread.sleep(10 * 1000);
        controller.shutdown();
    }

    public void setup() {
        network = new Network();
        ui = new ServerTUI();
        tNetwork = new Thread(network);
        tUI = new Thread(ui);
        tController = new Thread(this);
        tNetwork.setDaemon(true);
        tNetwork.setName("Network");
        tNetwork.start();
        tUI.start();
        tEngines = Executors.newCachedThreadPool();
        tController.start();
    }

    @Override
    public void run() {
        while (isRunning) {

        }
    }

    @Override
    public void shutdown() {
        if (tNetwork.isAlive()) {
            network.shutdown();
        }
        if (tUI.isAlive()) {
            ui.shutdown();
        }
        isRunning = false;
    }
}
