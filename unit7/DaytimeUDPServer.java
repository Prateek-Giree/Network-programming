import java.net.*;
import java.util.Date;
import java.util.logging.*;
import java.io.*;

public class DaytimeUDPServer {
    private final static int PORT = 3333;
    private final static Logger audit = Logger.getLogger("requests");
    private final static Logger errors = Logger.getLogger("errors");
    public static void main(String[] args) throws SocketException {
        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            while (true) {
                try {
                    DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
                    socket.receive(request);
                    String daytime = new Date().toString();
                    byte[] data = daytime.getBytes("US-ASCII");
                    DatagramPacket response = new DatagramPacket(data, data.length,
                            request.getAddress(), request.getPort());
                    socket.send(response);
                    audit.info(daytime + " " + request.getAddress());
                } catch (IOException | RuntimeException ex) {errors.log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        } catch (IOException ex) {
            errors.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}