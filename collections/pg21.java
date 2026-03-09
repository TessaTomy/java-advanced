import java.util.*;
class Attendee{
    int regId;
    String name,email;
    Attendee(String n,String e,int id)
    {
        regId=id;
        name=n;
        email=e;
    }
    public String toString()
    {
        return regId+" : "+name+" : "+email;
    }
    public int hashCode()
    {
        return Objects.hash(regId);
    }
    public boolean equals(Object o)
    {
        if(this==o) return true;
        if(!(o instanceof Attendee))
            return false;
        Attendee a=(Attendee)o;
        return this.regId==a.regId;
    }
}
public class pg21{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        HashSet<Attendee> a=new HashSet<>();
        System.out.print("Total Number of Attendee : ");
        int n=s.nextInt();
        while(a.size()<n)
        {  
            System.out.print("Enter Your Name,Mail id and RegId : ");
            a.add(new Attendee(s.next(),s.next(),s.nextInt()));
        }
        for(Attendee x:a)
        {
            System.out.println(x);
        }
        s.close();
    }
}
