package ss.week7.cmdline;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Peer for a simple client-server application.
 * 
 * @author Theo Ruys
 * @version 2005.02.21
 */
public class Peer implements Runnable {

	public static final String	EXIT	= "exit";

	protected String			name;
	protected Socket			sock;
	protected BufferedReader	in;
	//protected BufferedWriter	out;
	protected PrintWriter		out;

	/*
	 * @ requires (nameArg != null) && (sockArg != null);
	 */
	/**
	 * Constructor. creates a peer object based in the given parameters.
	 * 
	 * @param nameArg
	 *            name of the Peer-proces
	 * @param sockArg
	 *            Socket of the Peer-proces
	 */
	public Peer(String nameArg, Socket sockArg) throws IOException {
		name = nameArg;
		sock = sockArg;
		in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		out = new PrintWriter(sock.getOutputStream(), true); // new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
	}

	/**
	 * Reads strings of the stream of the socket-connection and writes the
	 * characters to the default output.
	 */
	public void run() {
		System.out.println(" stuasdf");
		String userInput;
		try {
			while ((userInput = in.readLine()) != null) {
				System.out.println(userInput);
			}
			System.out.println(userInput + " asdf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		System.out.println("end");
	}

	/**
	 * Reads a string from the console and sends this string over the
	 * socket-connection to the Peer process. On Peer.EXIT the method ends.
	 */
	public void handleTerminalInput() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String scannerLine = scanner.nextLine();
			if (scannerLine.equals(EXIT)) {
				break;
			}

			//			try {
			//				out.write(scannerLine);
			//			} catch (IOException e) {
			//				// TODO Auto-generated catch block
			//				e.printStackTrace();
			//			}
			out.println(scannerLine);
		}
		scanner.close();
		System.out.println("seeya");
	}

	/**
	 * Closes the connection, the sockets will be terminated.
	 */
	public void shutDown() {
		try {
			sock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** returns name of the peer object. */
	public String getName() {
		return name;
	}

	/** read a line from the default input. */
	static public String readString(String text) {
		System.out.print(text);
		String answer = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			answer = in.readLine();
		} catch (IOException e) {
		}

		return (answer == null) ? "" : answer;
	}
}
