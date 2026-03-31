import java.io.*;
import java.util.Scanner;

public class SearchReplace2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        File original = new File("sample.txt");
        File temp = new File("sample2.txt");
        int totalCount = 0;

        System.out.print("Old word: ");
        String oldW = sc.next();
        System.out.print("New word: ");
        String newW = sc.next();

    
        try (BufferedReader br = new BufferedReader(new FileReader(original));
             BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {
            
            String line;
            while ((line = br.readLine()) != null) {
                
                String countLine = line;
                while (countLine.contains(oldW)) {
                    totalCount++;
                    countLine = countLine.replaceFirst(oldW, "");
                }
                
               
                bw.write(line.replace(oldW, newW));
                bw.newLine(); 
            }
        }

     
        if (original.delete()) {  
            temp.renameTo(original);  
        }

        System.out.println("Replaced: " + totalCount + " occurrences.");
    }
}
