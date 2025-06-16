import java.io.*;
import java.net.*;
public class AllHeader{
    public static void main(String[] args) {
        String urlstring = "https://pratikgiri1.com.np/";
//        String urlstring= " http://www.oreilly.com";
            try {
                URL u = new URL(urlstring);
                URLConnection uc = u.openConnection();
                for (int j = 1; ; j++) {
                    String header = uc.getHeaderField(j);
                    if (header == null) break;
                    System.out.println(uc.getHeaderFieldKey(j) + ": " + header);
                }
            } catch (MalformedURLException ex) {
                System.err.println(urlstring + " is not a URL I understand.");
            } catch (IOException ex) {
                System.err.println(ex);
            }
            System.out.println();
        }
    }
