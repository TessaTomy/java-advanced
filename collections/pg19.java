import java.util.*;

class Product{
    String name;
    int price;
    Product(String n,int p)
    {
        name=n;
        price=p;
    }
    public String toString()
    {
        return name+" : "+price;
    }
}

public class pg19{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        ArrayList <Product> p =new ArrayList<>();
        do{
            System.out.print("1.Add\t2.Sort\t3.Display :");
            switch(s.nextInt())
            {
                case 1->{
                    System.out.print("Name & Price :");
                    s.nextLine();
                    p.add(new Product(s.next(),s.nextInt()));
                }
                case 2->{
                    System.out.println("Sorted !!");
                    Collections.sort(p,Comparator.comparing((Product pr)->pr.price));
                }
                case 3->{
                    for(Product pr:p)
                        System.out.println(pr);
                }
            }
            s.nextLine();
            System.out.print("Continue? (y/n): ");
        }while(s.next().equals("y"));
    }
}
