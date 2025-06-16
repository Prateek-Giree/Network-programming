import java.util.Scanner;
import java.io.*;
import java.net.*;

public class ExtractContent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a url:");
        String urlString = sc.nextLine();
        InputStream in = null;
        try {
            // Open the URL for reading
            URL u = new URL(urlString);
            in = u.openStream();
            // Buffer the input to increase performance
            in = new BufferedInputStream(in);
            // Chain the InputStream to a Reader
            Reader r = new InputStreamReader(in);
            int c;
            StringBuilder content = new StringBuilder();
            while ((c = r.read()) != -1) {
                content.append((char) c);
            }
            String str = content.toString();
            // Find the first occurrence of <title> and </title>
            int indexOfTitle = str.indexOf("<title>");
            int lastIndexOfTitle = str.indexOf("</title>");

            if (indexOfTitle != -1 && lastIndexOfTitle != -1) {
                // Extract the content between the <title> and </title> tags
                String title = str.substring(indexOfTitle , lastIndexOfTitle); // 7 is the length of "<title>"
                System.out.println("Title: " + title);
            } else {
                System.out.println("No <title> tag found.");
            }

        } catch (MalformedURLException ex) {
            System.err.println(urlString + " is not a parseable URL");
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
