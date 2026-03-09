import java.util.*;

class pg18 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        do {
            System.out.println("\n1.Add 2.Remove 3.Search 4.Sort 5.Display 6.Desc Sort");
            
            switch (s.nextInt()) { 
                case 1 -> {
                    s.nextLine(); 
                    System.out.print("Name to add: ");
                    names.add(s.nextLine());
                }
                case 2 -> {
                    s.nextLine(); 
                    System.out.print("Name to remove: ");
                    System.out.println(names.remove(s.nextLine()) ? "Removed" : "Not found");
                }
                case 3 -> {
                    s.nextLine(); 
                    System.out.print("Search for: ");
                    System.out.println(names.contains(s.nextLine()) ? "Present" : "Absent");
                }
                case 4 -> Collections.sort(names);
                case 5 -> System.out.println("List: " + names);
                case 6 -> names.sort(Collections.reverseOrder());
                default -> System.out.println("Invalid option.");
            }

            System.out.print("Continue? (y/n): ");
        } while (s.next().equalsIgnoreCase("y"));
        
        s.close();
    }
}
