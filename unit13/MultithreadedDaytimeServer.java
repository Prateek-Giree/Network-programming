import java.net.*;
import java.io.*;
import java.util.Date;

public class MultithreadedDaytimeServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(13)) {
            while (true) {
                new Thread(() -> {
                    try (Socket socket = server.accept();
                         Writer out = new OutputStreamWriter(socket.getOutputStream())) {
                        out.write(new Date().toString() + "\r\n");
                        out.flush();
                    } catch (IOException ignored) {}
                }).start();
            }
        } catch (IOException e) {
            System.err.println("Couldn't start server: " + e);
        }
    }
}
