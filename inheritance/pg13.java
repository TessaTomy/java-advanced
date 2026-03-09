interface Comparable{
    public double volume();
    public String compare(Comparable b);
}

class Cuboid implements Comparable{
    int l,b,h;
    Cuboid()
    {
        l=16;
        b=20;
        h=30;
    }
    public double volume()
    {
        return l*b*h;
    }

    public String compare(Comparable b)
    {
        if(this.volume()>b.volume())
            {
                return "Rectangle is higher --"+volume();
            }
        else if(this.volume()<b.volume())
            {
                return "Circle is higher --"+b.volume();
            }
        else
            {
                return "both are same -- "+volume();
            }
    }
}
class Cylinder implements Comparable{
    int r,h;
    Cylinder()
    {
        r=3;
        h=1;
    }
    public double volume()
    {
        return Math.PI*Math.pow(r,2)*h;
    }
    public String compare(Comparable b){return "";}
}
public class pg13 {
    public static void main(String[] args) {
        Comparable a=new Cuboid();
        System.out.println("Area of "+a.compare(new Cylinder()));

    }    
}

