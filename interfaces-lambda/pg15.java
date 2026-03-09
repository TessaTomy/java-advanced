// functional interfaces
interface Dim{
    double area(int x);
}
public class pg15{
    public static void main(String[] args) {
        Dim square=(x)->x*x;
        Dim cube=(x)->x*x*x;
        Dim circle=(x)->3.14*x*x;
        Dim sphere=(x)->(4/3)*3.14*x*x*x;
        System.out.println("Sqare = "+square.area(5)+"\nCube = "+cube.area(5)+"\nCircle = "+circle.area(5)+"\nSphere = "+sphere.area(5));
    }
}
