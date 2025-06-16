import java.net.URLEncoder;
import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;

public class UrlEncodingDecodingExample {
    public static void main(String[] args) {
        try {
            // Original string
            String originalString = "Hello Encode! How are you?";
            String encodedString1 = "Hello+Decode%21+How+are+you%3F";

            // URL Encoding
            String encodedString = URLEncoder.encode(originalString, "UTF-8");
            System.out.println("Encoded URL: " + encodedString);

            // URL Decoding
            String decodedString = URLDecoder.decode(encodedString1, "UTF-8");
            System.out.println("Decoded URL: " + decodedString);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}