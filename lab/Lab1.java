import java.io.IOException;
import java.net.*;
public class Lab1 {
    public static void main(String[] args) {
        try {
            //fetches only one IP address
            InetAddress addr = InetAddress.getByName("www.javapoint.com");
            System.out.println(addr);
        }
        catch(UnknownHostException ex){
            System.out.println("Couldn't find address");
        }
    }
}
