import java.io.IOException;
import java.net.*;
public class Lab3 {
    public static void main(String[] args) {
        try {
            //fetches only one IP address
            InetAddress addr = InetAddress.getByName("www.facebook.com");
            System.out.println(addr);

            //fetches all the ip addresses
            InetAddress[] addr1 = InetAddress.getAllByName("www.facebook.com");
            for (InetAddress address : addr1) {
                System.out.println(address);
            }

            InetAddress ia = InetAddress.getByName("57.144.146.1");
            //fetches ip from dns only
            System.out.println(ia.getCanonicalHostName());
            //fetches ip from local cache, if not found then fetches from dns
            System.out.println(ia.getHostName());

            //print address of local machine
            InetAddress localAddr = InetAddress.getLocalHost();
            System.out.println("This pc's name and address " + localAddr); //print name as well as ip address
            System.out.println("This pc's address in dotted quad " + localAddr.getHostAddress()); //print only ip address


            //testing the characteristics of ip address(checking type whether uni-cast or multicast)
            InetAddress address = InetAddress.getByName("www.facebook.com");
            if (address.isAnyLocalAddress()) {
                System.out.println(address + " is a wildcard address.");
            }
            if (address.isLoopbackAddress()) {
                System.out.println(address + " is loopback address.");
            }
            if (address.isLinkLocalAddress()) {
                System.out.println(address + " is a link-local address.");
            } else if (address.isSiteLocalAddress()) {
                System.out.println(address + " is a site-local address.");
            } else {
                System.out.println(address + " is a global address.");
            }
            if (address.isMulticastAddress()) {
                if (address.isMCGlobal()) {
                    System.out.println(address + " is a global multicast address.");
                } else if (address.isMCOrgLocal()) {
                    System.out.println(address
                            + " is an organization wide multicast address.");
                } else if (address.isMCSiteLocal()) {
                    System.out.println(address + " is a site wide multicast address.");
                } else if (address.isMCLinkLocal()) {
                    System.out.println(address + " is a subnet wide multicast address.");
                } else if (address.isMCNodeLocal()) {
                    System.out.println(address
                            + " is an interface-local multicast address.");
                } else {
                    System.out.println(address + " is an unknown multicast address type.");
                }
            } else {
                System.out.println(address + " is a uni-cast address.");
            }
        }
        catch(UnknownHostException ex){
            System.out.println("Couldn't find address");
        }
    }
}
