import java.util.*;

class pg2
{
    void multiplication(int n,int limit)
    {
        for(int i=1;i<=limit;i++)
            System.out.println(i+" x "+n+" = "+(i*n));
    }

    String isPrime(int n)
    {
        if(n<=1)
            return "Neither prime or composite";
        for(int i=2;i<=Math.sqrt(n);i++)
            if(n%i==0)
                return "Composite";
        return "Prime";
    }
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        System.out.print("Number : ");
        int n=s.nextInt();
        System.out.print("Limit : ");
        int l=s.nextInt();

        new pg2().multiplication(n,l);
        
        System.out.println(n+" is "+new pg2().isPrime(n));
        s.close();
    }
}
