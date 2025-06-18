import java.net.*;
import java.io.*;

public class Lab10Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 13);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("Server date and time: " + in.readLine());
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
