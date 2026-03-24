import java.io.*;

public class BufferedOutputDemo {
    public static void main(String[] args) {
        String text = "Buffered streams make I/O faster!";
        try (FileOutputStream fos = new FileOutputStream("buffered.txt");
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            bos.write(text.getBytes());
            bos.flush(); 
            System.out.println("Data written using BufferedOutputStream.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream("buffered.txt");
             BufferedInputStream bis = new BufferedInputStream(fis)) {

            int b;
            while ((b = bis.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
