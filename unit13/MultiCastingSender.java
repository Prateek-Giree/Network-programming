import java.io.*;
import java.net.*;
class MulticastingSender {
    public static void main(String[] args) {
        InetAddress ia = null;
        int port = 0;
        byte ttl = (byte) 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            ia = InetAddress.getByName("224.2.2.1");
            port = 3333;
            ttl = 64;
        } catch (NumberFormatException | IndexOutOfBoundsException | UnknownHostException ex) {
            System.err.println(ex);
            System.err.println("Usage: java MulticastSender multicast_address port ttl");
            System.exit(1);
        }

        try (MulticastSocket ms = new MulticastSocket()) {
            ms.setTimeToLive(ttl);
            ms.joinGroup(ia);
            for (int i = 1; i < 10; i++) {
                byte[] data = br.readLine().getBytes();
                DatagramPacket dp = new DatagramPacket(data, data.length, ia, port);
                ms.send(dp);
            }
            ms.leaveGroup(ia);
        } catch (SocketException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}