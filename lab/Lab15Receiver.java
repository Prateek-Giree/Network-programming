import java.io.*;
import java.net.*;


public class Lab15Receiver{
    public static void main(String[] args) {
        InetAddress group = null;
        int port = 0;
        try {
            group = InetAddress.getByName("224.2.2.1");
            port = 3333;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException | UnknownHostException ex) {
            System.err.println( "Usage: java MulticastSniffer multicast_address port");
            System.exit(1);
        }
        MulticastSocket ms = null;
        try{
            ms = new MulticastSocket(port);
            ms.joinGroup(group);
            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                ms.receive(dp);
                String s = new String(dp.getData(), "US-ASCII");
                System.out.println(s);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            if (ms != null) {
                try {
                    ms.leaveGroup(group);
                    ms.close();
                } catch (IOException ex) {}
            }
        }
    }
}