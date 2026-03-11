import java.util.*;

class OutoFStockException extends RuntimeException{
    public OutoFStockException(String msg)
    {
        super(msg);
    }
}
public class Product {
    String pname="abc";
    static int quantity=100;
    public static Boolean purchase(int q)
    {
        if(q<=0)
            throw new IllegalArgumentException("Quantity Must be Positive !!");
        if(q>quantity)
            throw new OutoFStockException("Out of Stock Exception !!");
        quantity-=q;
        System.out.println("Purchase Placed !!");
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            System.out.print("Quantity : ");
            purchase(sc.nextInt());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally{
            sc.close();
        }        
    }
}
