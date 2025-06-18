import java.io.*;
import java.net.*;

public class LoggerClient {
    public static void main(String[] args) {
        final String SERVER = "localhost";
        final int PORT = 5000;

        try (
                Socket socket = new Socket(SERVER, PORT);
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        ) {
            System.out.println("Connected to Logger Server. Type messages to log (type 'exit' to quit):");

            String line;
            while ((line = console.readLine()) != null) {
                if (line.equalsIgnoreCase("exit")) break;
                out.write(line);
                out.newLine();
                out.flush();
            }

        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
