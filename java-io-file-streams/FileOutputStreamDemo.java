import java.io.*;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[] args) {
        // try-with-resources ensures automatic closing of the stream
        try (FileOutputStream in = new FileOutputStream("input.bin")) {
            byte[] data={65,66,67,68};
            in.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream in = new FileInputStream("input.bin")) {
            int x;
            while((x=in.read())!=-1)
                System.out.println((char)x);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
