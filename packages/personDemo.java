import person.student.Student;
import person.prof.Prof;

import java.util.Scanner;

class personDemo
{
    public static void main(String args[])
    {
        int a,b;
        Scanner s=new Scanner(System.in);
        System.out.println("Enter total number of students in class and b : ");
        a=s.nextInt();
        b=s.nextInt();

        Student sa[]=new Student[a];
        for(int i=0;i<a;i++)
        {
            System.out.println("Id,course,name,age : ");
            sa[i]=new Student();
            sa[i].read();
        }

        Prof p[]=new Prof[2];

        System.out.println("Tutor : ");
        p[0]=new Prof();
        p[0].read();

        System.out.println("batch B : ");
         Student sb[]=new Student[b];
        for(int i=0;i<b;i++)
        {
            System.out.println("Id,course,name,age : ");
            sb[i]=new Student();
            sb[i].read();
        }

        
        System.out.println("Tutor : ");
        p[1]=new Prof();
        p[1].read();


        System.out.println(p[0].display());
        System.out.println("Batch A : ");
        for(Student x : sa)
        {
            System.out.println(x.display());
        }
    }
}
