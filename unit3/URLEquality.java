import java.net.*;
public class URLEquality {
    public static void main (String[] args) {
        try {
            URL fabebook = new URL ("https://www.facebook.com");
            URL fb = new URL("https://www.fb.com");
            if (fabebook.equals(fb)) {
                System.out.println(fabebook + " is the same as " + fb);
            } else {
                System.out.println(fabebook + " is not the same as " + fb);
            }
        } catch (MalformedURLException ex) {
            System.err.println(ex);
        }
    }
} 