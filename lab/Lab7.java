//Downloading the content of a webpage
import java.io.*;
import java.net.*;
public class Lab7{
    public static void main(String[] args) {

        try {
            // Open the URL for reading
            URL u = new URL("https://www.google.com");
            URLConnection uc = u.openConnection();
            InputStream raw = uc.getInputStream();
            InputStream buf = new BufferedInputStream(raw);
            Reader r = new InputStreamReader(buf);
            int c;
            while ((c = r.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (MalformedURLException ex) {
            System.err.println("Cannot parse");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        }
    }
