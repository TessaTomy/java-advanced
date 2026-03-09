import java.util.*;

class Person
{
    Scanner s=new Scanner(System.in);
    String name,gender,address,age;
    Person()
    {
        System.out.println("Enter Name,gender,address and age");
        name=s.nextLine();
        gender=s.nextLine();
        address=s.nextLine();
        age=s.nextLine();
    }
}

class Employee extends Person{
    String empid,company,qualification,salary;
    Employee()
    {
        System.out.println("Enter your empid,company,qualification and salary : ");
        empid=s.nextLine();
        company=s.nextLine();
        qualification=s.nextLine();
        salary=s.nextLine();
    }
}

class Teacher extends Employee{
    String tid,subject,dept;
    Teacher()
    {
        System.out.println("Enter your tid,subject and dept : ");
        tid=s.nextLine();
        subject=s.nextLine();
        dept=s.nextLine();
    }

    public String toString(){
        return name+" "+subject;
    }
}
public class pg9 {
    public static void main(String[] args) {
        int n;
        Scanner s=new Scanner(System.in);
        System.out.println("Enter total number of staffs :");
        n=s.nextInt();
        s.nextLine();
        Teacher t[]=new Teacher[n];
        for(int i=0;i<n;i++)
        {
            t[i]=new Teacher();
        }

        for(int i=0;i<n;i++)
        {
            System.out.println(t[i]);
        }
    }
}
