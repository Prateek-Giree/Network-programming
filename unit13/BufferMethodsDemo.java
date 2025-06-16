import java.nio.CharBuffer;

public class BufferMethodsDemo {
    public static void main(String[] args) {
        CharBuffer buffer= CharBuffer.allocate(10);
        String text = "Buffer Demo";

        System.out.println("Input text: " + text);
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            buffer.put(c); //put data in buffer and increment position by 1
        }
        int buffpos = buffer.position(); //get buffer position
        System.out.println("Position after data is written into buffer: " + buffpos);
        buffer.flip();

        System.out.println("Reading buffer contents: ");
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get()); //retrieve data from position
        }

        buffer.position(5);
        buffer.mark(); //set mark as 5
        buffer.position(7);
        buffer.reset(); //set position to mark

        System.out.println("Restored buffer position : " + buffer.position());
    }
}
