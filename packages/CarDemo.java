package demo;

import vehicle.car.Car;
import vehicle.ecar.Ecar;
import vehicle.Vehicle;
import java.util.Scanner;

public class CarDemo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Total number of Ecars:");
        int n = s.nextInt();
        s.nextLine(); // consume newline
        Ecar[] e = new Ecar[n];
        for (int i = 0; i < n; i++) {
            e[i] = new Ecar();
            e[i].read();
        }

        System.out.println("Total number of Cars:");
        n = s.nextInt();
        s.nextLine(); // consume newline
        Car[] c = new Car[n];
        for (int i = 0; i < n; i++) {
            c[i] = new Car();
            c[i].read();
        }

        System.out.println("\n--- Electric Cars ---");
        for (Ecar x : e) {
            x.display();
        }

        System.out.println("\n--- Cars ---");
        for (Car x : c) {
            x.display();
        }

        System.out.println("\nTotal vehicles created: " + Vehicle.getCount());
    }
}
