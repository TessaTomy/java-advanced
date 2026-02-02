class Geometry{
    double area(int a)
    {
        return a*a;
    }
    double area(int a,int b)
    {
        return a*b;
    }
    double area(double a)
    {
        return 3.14*a;
    }
}

public class pg6 {
    public static void main(String[] args) {
        Geometry g=new Geometry();
        System.out.println("Area of sqaure = "+g.area(5)+"\nArea of recatngle ="+g.area(3,4)+"\nArea of circle = "+g.area(1));
    }
}
