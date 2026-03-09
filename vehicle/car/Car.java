package vehicle.car;
import vehicle.*;

public class Car extends Vehicle implements printer{
    int no_of_doors;
    public void read()
    {
        System.out.println("Enter make model and no of doors :");
        make=s.nextInt();
        model=s.nextInt();
        no_of_doors=s.nextInt();
    }
    public void display(){
        System.out.println(this);
    }
    public String toString()
    {
        return make+" "+model+" "+no_of_doors;
    }
}
