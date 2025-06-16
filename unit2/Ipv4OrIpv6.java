import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.SortedMap;

public class Ipv4OrIpv6 {
    public static int getVersion(InetAddress ia){
        byte[] address=ia.getAddress();
//        for (byte addr:address) {
//            System.out.println(addr);
//        }
        if (address.length==4)
            return 4;
        else if (address.length==16)
            return 6;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter domain");
        String domain=sc.nextLine();
        try{
            InetAddress add=InetAddress.getByName(domain);
            int IpVersion=Ipv4OrIpv6.getVersion(add);
            if (IpVersion==-1){
                System.out.println("Couldnt find ip");
            }
            else{
                System.out.println("The IP version of "+domain+" is: IPV"+IpVersion);
            }
        }catch(UnknownHostException ex){
            System.out.println("Error occured: "+ex.getMessage());
        }
    }
}
