import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        // try-with-resources ensures automatic closing of the stream
        try (FileOutputStream in = new FileOutputStream("input.bin")) {
            byte[] data={65,66,67,68};
            in.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
