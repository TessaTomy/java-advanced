import java.util.*;
import dept.stud.course;
import dept.Dept;

public class studDemo {
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        Dept d=new Dept();
        course c[];
        d.read();
        d.display();
        int n;
        System.out.println("Total number of course : ");
        n=s.nextInt();
        c=new course[n];
        for(int i=0;i<n;i++)
        {
            c[i]=new course();
            c[i].read();
        }
        Arrays.sort(c,(a,b)->a.coursename.compareToIgnoreCase(b.coursename));
        for(course z:c)
        {
               z.display(); 
        }

        
    }
}
