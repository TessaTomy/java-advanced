package vehicle;
import java.util.Scanner;

public class Vehicle{
    public int make,model;
    public static int count;
    public static Scanner s=new Scanner(System.in);
    public Vehicle()
    {
        counter();
    }
    public static void counter()
    {
        count++;
    }
    public static int getCount()
    {
        return count;
    }
}

