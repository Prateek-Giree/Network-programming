// EchoServer.java
import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        System.out.println("Server is running...");
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        String msg;
        while (!(msg = din.readUTF()).equalsIgnoreCase("stop")) {
            System.out.println("Received: " + msg);
            dout.writeUTF(msg);  // Echo the same message back
            dout.flush();
        }

        din.close();
        dout.close();
        s.close();
        ss.close();
    }
}
