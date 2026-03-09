class Rectangle
{
    int l,b;
    Rectangle(int l,int b)
    {
        this.l=l;this.b=b;
    }
}

interface Measureable{
    public double volume();
    public void printable();
}

class Cuboid extends Rectangle implements Measureable
{
    int h;
    Cuboid(int l,int b,int h)
    {
        super(l,b);
        this.h=h;
    }
    public double volume()
    {
        return l*b*h;
    }
    public void printable(){
        System.out.println("Volume = "+volume());
    }
}
class pg11
{
    public static void main(String args[])
    {
        new Cuboid(1,2,3).printable();
    }
}
