import java.io.*;
import java.util.Scanner;

public class SearchReplace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter word to replace: ");
        String oldWord = sc.nextLine();

        System.out.print("Enter new word: ");
        String newWord = sc.nextLine();

        String fileName = "sample.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName));
             BufferedWriter bw = new BufferedWriter(new FileWriter("sample2.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                line = line.replace(oldWord, newWord);
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
           
        }

        

        System.out.println("Search and replace completed. Original file updated.");
    }
}
