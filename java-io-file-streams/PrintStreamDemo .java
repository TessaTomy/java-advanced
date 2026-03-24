import java.io.*;

public class PrintStreamDemo {
    public static void main(String[] args) {
        try (PrintStream ps = new PrintStream(new FileOutputStream("printstream.txt", true))) {
            ps.println("Hello using PrintStream!");
            ps.printf("Number: %d, String: %s%n", 42, "Java I/O");
            ps.print("This line has no newline.");
            System.out.println("Data written using PrintStream.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
