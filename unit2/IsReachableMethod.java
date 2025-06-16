
//Checking whether a host is reachable in given timeframe or not
import java.io.IOException;
import java.net.*;

public class IsReachableMethod {

    public static void main(String[] args) {
        String host = "facebook.com";
        int timeout = 300;
        try {
            InetAddress inetAddress = InetAddress.getByName(host);
            boolean isReachable = inetAddress.isReachable(timeout);
            if(isReachable)
                System.out.println(host + " is reachable in 300ms");
            else
                System.out.println("is not reachable");
        }
        catch (IOException e) {
            System.err.println("IO exception: " + e.getMessage());
        }
    }
}