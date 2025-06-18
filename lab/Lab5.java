//Downloading the content of a webpage
import java.io.*;
import java.net.*;
public class Lab5 {
    public static void main(String[] args) {
        InputStream in = null;
        try {
            // Open the URL for reading
            URL u = new URL("https://www.pratikgiri1.com.np");
            in = u.openStream();
            // buffer the input to increase performance
            in = new BufferedInputStream(in);
            // chain the InputStream to a Reader
            Reader r = new InputStreamReader(in);
            int c;
            while ((c = r.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (MalformedURLException ex) {
            System.err.println("Cannot parse");
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}
