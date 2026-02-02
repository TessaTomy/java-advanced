import java.util.*;
class Student{
    int rollno,mark;
    String name;
    static int count;

    Student()
    {
        count++;
    }
    Student(int rno,String name,int mark)
    {
        this.rollno=rno;
        this.name=name;
        this.mark=mark;
    }
    Student(Student s)
    {
        this.rollno=s.rollno;
        this.name=s.name;
        this.mark=s.mark;
    }


}

class pg1{
    public static void main(String args[])
    {
        Student s[]=new Student[10];
        Scanner sc=new Scanner(System.in);
        System.out.println("Total Number of Students :");
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
            {
                s[i]=new Student();
                System.out.println("Enter roll no, Name and mark of student "+(i+1)+"  :");
                s[i].rollno=sc.nextInt();
                s[i].name=sc.next();
                s[i].mark=sc.nextInt();
            }

        sortStudent(s,n);

        System.out.println("Rank\tRollNo\tName\tMark");
        for(int i=0;i<n;i++)
            System.out.println((i+1)+".\t"+s[i].rollno+"\t"+s[i].name+"\t"+s[i].mark);

        System.out.println("Total No of students appeared : "+Student.count);

        sc.close();
    }

    static void sortStudent(Student s[],int n)
    {
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++)
        {
            if(s[j].mark>s[i].mark)
                {
                    Student t=s[j];
                    s[j]=s[i];
                    s[i]=t;
                }
        }


    }
}
