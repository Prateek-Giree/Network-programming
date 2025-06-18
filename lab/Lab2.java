import java.io.IOException;
import java.net.*;
public class Lab2 {
    public static void main(String[] args) {
        try {
            //fetches only one IP address
            InetAddress me = InetAddress.getLocalHost();
           String dottedquad=me.getHostAddress();
            System.out.println("My address is "+dottedquad);
        }
        catch(UnknownHostException ex){
            System.out.println("Couldn't find address");
        }
    }
}
