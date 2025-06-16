// checks whether two domain names resolve to the same IP address.
import java.net.*;
public class IbiblioAliases {
    public static void main(String args[]) {
        String host1="prateekgiree.netlify.app";
        String host2="pratikgiri1.com.np";
        try {
            InetAddress netlifyDns = InetAddress.getByName(host1);
            InetAddress MercantileDns = InetAddress.getByName(host2);
            if (netlifyDns.equals(MercantileDns)) {
                System.out.println
                        (host1+" is the same as "+host2);
            } else {
                System.out.println
                        (host1+" is not the same as "+host2);
            }
        } catch (UnknownHostException ex) {
            System.out.println("Host lookup failed.");
        }
    }
}
