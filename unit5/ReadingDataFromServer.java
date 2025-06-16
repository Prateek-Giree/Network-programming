import java.io.*;
import java.net.*;
public class ReadingDataFromServer {
    public static void main (String[] args) {

        String urlstring="https://pratikgiri1.com.np/";
        try {
                // Open the URLConnection for reading
                URL u = new URL(urlstring);
                URLConnection uc = u.openConnection();
                try (InputStream raw = uc.getInputStream()) {
                    InputStream buffer = new BufferedInputStream(raw);
                    // chain the InputStream to a Reader
                    Reader reader = new InputStreamReader(buffer);
                    int c;
                    while ((c = reader.read()) != -1) {
                        System.out.print((char) c);
                    }
                }
            } catch (MalformedURLException ex) {
                System.err.println(urlstring + " is not a parseable URL");
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
