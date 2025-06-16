import java.io.*;
import java.net.*;

public class UDPMessageClient {
    private final static int port=13;
    private final static String HOSTNAME="localhost";

    public static void main(String[] args) {
        try (DatagramSocket socket= new DatagramSocket(0)) {
            InetAddress host = InetAddress.getByName(HOSTNAME);
            while (true) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String line = br.readLine();
                byte[] data = line.getBytes("US-ASCII");
                DatagramPacket request = new DatagramPacket(data, data.length, host, port);
                socket.send(request);
                DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
                socket.receive(response);
                String result = new String(response.getData(), 0, response.getLength(), "US-ASCII");
                System.out.println("Server says: " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
