import java.nio.CharBuffer;

public class Lab13 {
    public static void main(String[] args) {
        CharBuffer buffer= CharBuffer.allocate(15);
        String text = "Prateek Giree";

        System.out.println("Input text: " + text);
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            buffer.put(c); //put data in buffer and increment position by 1
        }
        int buffpos = buffer.position(); //get buffer position
        System.out.println("Position after data is written into buffer: " + buffpos);

        System.out.println("Reading buffer contents: ");
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get()); //retrieve data from position
        }

        buffer.position(5);
        buffer.mark(); //set mark as 5
        buffer.position(7);
        buffer.reset(); //set position to mark

        System.out.println("\nRestored buffer position : " + buffer.position());
    }
}
