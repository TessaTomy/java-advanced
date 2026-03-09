import java.util.*;

interface Shape {
    Scanner sc = new Scanner(System.in);
    double area();
    double perimeter();
}

class Circle implements Shape {
    private int r;
    Circle() { System.out.print("Radius: "); r = sc.nextInt(); }
    public double area() { return 3.14 * r * r; }
    public double perimeter() { return 2 * 3.14 * r; }
}

class Rectangle implements Shape {
    private int l, b;
    Rectangle() { System.out.print("Length & Breadth: "); l = sc.nextInt(); b = sc.nextInt(); }
    public double area() { return l * b; }
    public double perimeter() { return 2 * (l + b); }
}

public class pg10 {
    public static void main(String[] args) {
        while (true) {
            System.out.print("1.Circle  2.Rectangle  0.Exit : ");
            Shape s = null;
            int choice = Shape.sc.nextInt();
            switch (choice) {
                case 1: s = new Circle(); break;
                case 2: s = new Rectangle(); break;
                case 0: System.exit(0);
            }
            if (s != null) System.out.println("Area=" + s.area() + "\tPerimeter=" + s.perimeter());
        }
    }
}
