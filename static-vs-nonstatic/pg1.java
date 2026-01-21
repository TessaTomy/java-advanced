import java.util.*;

class pg1
{
    public static int fact(int n)
    {
        if(n==0||n==1)
            return 1;
        return n*fact(n-1);
    }

    public static int fib(int n)
    {
        if(n==0||n==1)
            return 1;
        return fib(n-1)+fib(n-2);
    }
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        System.out.print("Number : ");
        int n=s.nextInt();
        System.out.println("Factorial = "+fact(n));
        System.out.println(n+"th fibnocci no = "+fib(n));
        s.close();
    }
}
