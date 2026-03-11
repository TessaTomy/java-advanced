import java.util.*;

public class pg22 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        ArrayList <Integer> a=new ArrayList<>();
        System.out.print("Size : ");
        int n=sc.nextInt();
        System.out.print("Elements : ");
        while(a.size()<n)
        {
            try{
                a.add(sc.nextInt());
                if(a.get(a.size()-1)<0)
                    throw new Exception("Negative Number not Allowed !!");
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                a.remove(a.size()-1);
            }
        }
        if(a.size()>0)
        {
            int avg=0;
            for(int x:a)
                {
                    avg+=x;
                }
            System.out.println("Average = "+avg/a.size());
        }
        sc.close();
    }
}
