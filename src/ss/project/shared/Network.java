package ss.project.shared;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Created by simon on 27.11.16.
 */
public class Network {
    public static ArrayList<NetworkInterface> getMulticastInterfaces() throws SocketException {
        ArrayList<NetworkInterface> compatibleInterfaces = new ArrayList<>();
        Enumeration<NetworkInterface> availableIntefaces = NetworkInterface.getNetworkInterfaces();

        while (availableIntefaces.hasMoreElements()) {
            NetworkInterface networkInterface = availableIntefaces.nextElement();
            if (!networkInterface.isLoopback() &&
                    !networkInterface.isVirtual() &&
                    networkInterface.isUp() &&
                    networkInterface.supportsMulticast())
                compatibleInterfaces.add(networkInterface);
        }
        return compatibleInterfaces;
    }
}

