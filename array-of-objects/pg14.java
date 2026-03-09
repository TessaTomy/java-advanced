import java.util.*;

class Person{
    Scanner sc=new Scanner(System.in);
    String name,gender,phoneno;
    Person()
    {
        System.out.println("Enter your name,gender and phone no :");
        name=sc.nextLine();
        gender=sc.nextLine();
        phoneno=sc.nextLine();
    }
}

interface showable{
    void show();
}

class Student extends Person{
    String course;
    int score;
    Student()
    {
        System.out.println("Enter your course and score : ");
        course=sc.nextLine();
        score=sc.nextInt();
        sc.nextLine();
    }
}

class PgStudent extends Student{
    String rarea,guide;
    PgStudent()
    {
        System.out.println("Enter yout rarea and guide  : ");
        rarea=sc.nextLine();
        guide=sc.nextLine();
    }
    public String toString() {
        
        return name + "|"+ course + "|" + score + "|" + rarea + "|" ;
    }
}

public class pg14 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Total no of faculties :");
        int n=sc.nextInt();
        PgStudent p[]=new PgStudent[n];
        for(int i=0;i<n;i++)
            p[i]=new PgStudent();
        for (PgStudent s : p) {
            System.out.println(s); 
        }

        Arrays.sort(p, (a, b) -> b.score - a.score); 
        System.out.println("\nSorted by Rank (Score):");
        for (PgStudent s : p) {
            System.out.println(s); 
        }
        Arrays.sort(p, (a, b) -> a.rarea.compareToIgnoreCase(b.rarea));
        System.out.println("\nSorted by Research Area:");
        for (PgStudent s : p) {
            System.out.println(s); 
        }
    }
}
