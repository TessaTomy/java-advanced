package dept;
import java.util.*;

public class Dept{
    public String deptname,location;
    public static Scanner s=new Scanner(System.in);
    public void read()
    {
        deptname=s.nextLine();
        location=s.nextLine();
    }

    

    public void display()
    {
        System.out.println(deptname);
    }
}
