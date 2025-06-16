import java.net.*;
import java.util.*;
public class NetworkInterfaceExample3 {
    public static void main(String[] args) throws SocketException{
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        int count=0;
        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();
            System.out.println(ni);
            count++;
        }
        System.out.println(count);
    }
}