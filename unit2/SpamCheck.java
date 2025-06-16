import java.net.*;
import java.util.Scanner;

public class SpamCheck {
    public static final String BLACKHOLE = "sbl.spamhaus.org";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter IP addresses (space-separated) to check: ");
        String input = sc.nextLine();

        // Split the input by space to get individual IP addresses
        String[] ipAddresses = input.split(" ");

        for (String ipAddress : ipAddresses) {
            ipAddress = ipAddress.trim();
            if (isSpammer(ipAddress)) {
                System.out.println(ipAddress + " is a known spammer.");
            } else {
                System.out.println(ipAddress + " appears legitimate.");
            }
        }

        sc.close();
    }

    private static boolean isSpammer(String ipAddress) {
        try {
            InetAddress address = InetAddress.getByName(ipAddress);
            byte[] quad = address.getAddress();
            String query = BLACKHOLE;
            for (byte octet : quad) {
                int unsignedByte = octet < 0 ? octet + 256 : octet;
                query = unsignedByte + "." + query;
            }
            InetAddress.getByName(query);
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }
}
