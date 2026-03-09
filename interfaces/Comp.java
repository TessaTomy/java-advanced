import java.awt.*;
import javax.swing.*;

// Custom interface for shapes
interface ComparableShape {
    double volume();
    boolean compare(ComparableShape other);
}

// Cuboid implementation
class Cuboid implements ComparableShape {
    private int length, width, height;

    Cuboid(int l, int w, int h) {
        this.length = l;
        this.width = w;
        this.height = h;
    }

    public double volume() {
        return length * width * height;
    }

    public boolean compare(ComparableShape other) {
        return this.volume() < other.volume();
    }

    public void draw() {
        JFrame f = new JFrame("Cuboid");
        f.setSize(400, 400);
        f.add(new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawRect(40, 40, width * 20, height * 20); 
            }
        });
        f.setVisible(true);
    }

    public String toString() {
        return "Cuboid(" + length + "×" + width + "×" + height + ")";
    }
}

// Cylinder implementation
class Cylinder implements ComparableShape {
    private int radius, height;

    Cylinder(int r, int h) {
        this.radius = r;
        this.height = h;
    }

    public double volume() {
        return Math.PI * radius * radius * height;
    }

    public boolean compare(ComparableShape other) {
        return this.volume() < other.volume();
    }

    public String toString() {
        return "Cylinder(r=" + radius + ", h=" + height + ")";
    }
}

// Driver
public class Comp {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid(2, 3, 4);
        Cylinder cylinder = new Cylinder(2, 5);

        System.out.println("Cuboid volume: " + cuboid.volume());
        System.out.println("Cylinder volume: " + cylinder.volume());

        System.out.println("Is cuboid smaller than cylinder? " + cuboid.compare(cylinder));
        System.out.println("Is cylinder smaller than cuboid? " + cylinder.compare(cuboid));

        cuboid.draw();
    }
}
