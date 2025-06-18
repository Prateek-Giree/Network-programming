// EchoClient.java
import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 13);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String msg;
        while (!(msg = br.readLine()).equalsIgnoreCase("stop")) {
            dout.writeUTF(msg);
            dout.flush();

            String response = din.readUTF();
            System.out.println("Server echoed: " + response);
        }

        din.close();
        dout.close();
        s.close();
    }
}
