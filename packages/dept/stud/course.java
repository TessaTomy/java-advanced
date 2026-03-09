package dept.stud;

import java.util.*;

public class course {
    public static Scanner s=new Scanner(System.in);
    public String coursename,duration;
    int studcount;
    student st[];
    public void read()
    {
        System.out.println("Enter course name,duration and stud count : ");
        coursename=s.nextLine();
        duration=s.nextLine();
        studcount=s.nextInt();
        st=new student[studcount];
        s.nextLine();
        System.out.println("Enter details of student :");
        for(int i=0;i<studcount;i++)
            {
                st[i]=new student();
                st[i].read();
            }
        
    }
    public String toString()
    {
        return coursename+" : "+duration;
    }

    public void display(){
        System.out.println(coursename+"\n------------\n");
        Arrays.sort(st,(a,b)->a.mark-b.mark);
        for(student sz:st)
            System.out.println(sz);
    }

    public class student {
        String name;
        int mark;
        public void read()
        {
            System.out.println("Enter name and mark : ");
            name=s.nextLine();
            mark=s.nextInt();
            s.nextLine();
        }
    
        public String toString()
        {
            return name+" : "+mark;
        }
    }
    
}
