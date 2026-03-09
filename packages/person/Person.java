package person;
import java.util.Scanner;

abstract public class Person
{
    public String name;
    public int age;
    public static Scanner s=new Scanner(System.in);
    public void read()
    {
        s.nextLine();
        name=s.nextLine();
        age=s.nextInt();
    }
}
