package ss.project.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;

public class MulticastSocketClient implements Runnable {

	@Override
	public void run() {
		try {
			MulticastSocket clientSocket = new MulticastSocket(1234);
			clientSocket.setBroadcast(true);
			boolean doRun = true;
			while (doRun) {
				byte[] buf = new byte[256];
				// Receive the information and print it.
				DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
				clientSocket.receive(msgPacket);

				String msg = new String(buf, 0, buf.length);
				System.out.println("REC: " + msg);
				if (msg.equals("end")) {
					doRun = false;
					clientSocket.close();
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}