import java.util.*;

class zoo{
    String name;
    String region[];
    static Scanner s;
    int n;
    contact c;
    Enclosure e[];
    void read()
    {
        s=new Scanner(System.in);
        System.out.println("Enter name of zoo and total no of regions in it  :\n");
        name=s.nextLine();
        n=s.nextInt();
        s.nextLine();
        System.out.println("Enter the regions : ");
        region=new String[n];
        for(int i=0;i<n;i++)
        {
            region[i]=s.nextLine();
        }

        c=new contact();
        c.read();
        
        e=new Enclosure[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enclosure : "+(i+1));
            e[i]=this.new Enclosure();
            e[i].read();
        }
       
    }

    void display()
    {
        System.out.println("Name :"+name+"\n Region :");
        for(String x:region)
        {
            System.out.println(x);
        }
        c.display();
        for(int i=0;i<n;i++)
            {
                System.out.println("Enclosure : "+(i+1));
               
                e[i].display();
            }
    }
    class Enclosure{
        String name,type;
        String[] animals;
        int p;
        void read()
        {
            s=new Scanner(System.in);
            System.out.println("Enter name and type of enclosure followed by total no of animals in it  :\n");
            name=s.nextLine();
            type=s.nextLine();
            p=s.nextInt();
            s.nextLine();
            System.out.println("Enter the animals : ");
            animals=new String[p];
            for(int i=0;i<p;i++)
            {
                animals[i]=s.nextLine();
            }
    
        }
    
        void display()
        {
            System.out.println("Name :"+name+"\nType :"+type+"\n Region :");
            for(String x:animals)
            {
                System.out.println(x);
            }
        }
    }
    static class contact
    {
        String address,phoneno;

        void read()
        {
            System.out.println("Enter Address and phone number : ");
            address=s.nextLine();
            phoneno=s.nextLine();
        }

        void display()
        {
            System.out.println("Address="+address+"\nPhone No : "+phoneno);
        }
    }

}

public class pg {
    public static void main(String[] args) {
     zoo z=new zoo();   
     z.read();
     z.display();
    }
}
