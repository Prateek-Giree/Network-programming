import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.*;

public class Lab14Server {
    private final static int port=13;
    private final static Logger audit=Logger.getLogger("requests");
    private final static Logger errors= Logger.getLogger("errors");

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(port)) {
            while (true) {
                try {
                    DatagramPacket request=new DatagramPacket(new byte[1024], 1024);
                    socket.receive(request);
                    String datareq = new String(request.getData(), 0, request.getLength(),"US-ASCII");
                    System.out.println("Client Says: " + datareq);

                    //getting user's data from keyboard
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    String myline =br.readLine();
                    byte[] data = myline.getBytes("US-ASCII"); //converting user data into byte array

                    DatagramPacket response=new DatagramPacket(data,data.length,request.getAddress(), request.getPort());
                    socket.send(response);
                    audit.info(new Date().toString() + " " + request.getAddress());
                } catch (IOException | RuntimeException e) {
                    errors.log(Level.SEVERE,e.getMessage(),e);
                }
            }
        } catch (IOException e) {
            errors.log(Level.SEVERE,e.getMessage(),e);
        }
    }
}
