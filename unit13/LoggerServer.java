import java.io.*;
import java.net.*;

public class LoggerServer {
    public static void main(String[] args) {
        final int PORT = 5000;
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Logger Server started on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedWriter logWriter = new BufferedWriter(new FileWriter("server_log.txt", true));

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    logWriter.write(message);
                    logWriter.newLine();
                    logWriter.flush();
                }

                in.close();
                logWriter.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
