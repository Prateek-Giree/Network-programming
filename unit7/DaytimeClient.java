import java.net.*;
import java.io.*;

public class DaytimeClient {
    public final static int PORT = 13;
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", PORT)) {
            // Set up input stream to read the date from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read the date and time sent by the server
            String response = in.readLine();

            // Print the server's response
            System.out.println("Current date and time from server: " + response);
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
