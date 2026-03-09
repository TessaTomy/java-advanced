package vehicle.ecar;
import vehicle.*;

public class Ecar extends Vehicle implements printer{
    int battery;
    public void read()
    {
        System.out.println("Enter make model and Battery :");
        make=s.nextInt();
        model=s.nextInt();
        battery=s.nextInt();
    }
    public void display(){
        System.out.println(this);
    }
    public String toString()
    {
        return make+" "+model+" "+battery;
    }
}
