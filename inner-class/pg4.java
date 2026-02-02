import java.util.*;

class CPU{
    int price;
    RAM r;
    Processor p;
    static class RAM{
        int memory;
        String manufacturer;
        void read()
        {
            Scanner s=new Scanner(System.in);
            System.out.print("Memory : ");
            this.memory=s.nextInt();
            s.nextLine();
            System.out.print("Manufacturer : ");
            this.manufacturer=s.nextLine();
        }
        void display(){
            System.out.println("RAM\n==================\nMemory : "+memory+"\n"+"Manufacturer :"+manufacturer);
        }
    }
    class Processor{
        int no_of_cores;
        String manufacturer;

        void read()
        {
            Scanner s=new Scanner(System.in);
            System.out.print("Cores : ");
            this.no_of_cores=s.nextInt();
            s.nextLine();
            System.out.print("Manufacturer : ");
            this.manufacturer=s.nextLine();
        }
        void display(){
            System.out.println("PROCESSOR\n==============\nCores : "+no_of_cores+"\n"+"Manufacturer :"+manufacturer);
        }
    }

    void read()
        {
            Scanner s=new Scanner(System.in);
            System.out.print("Price : ");
            this.price=s.nextInt();
            r=new RAM();
            CPU c=new CPU();

            r.read();
            p=c.new Processor();
            p.read();
        }
        void display(){
            System.out.println("Price : "+price);
            r.display();
            p.display();
        }
}

class pg4{
    public static void main(String[] args) {
        CPU c=new CPU();
        c.read();
        c.display();
    }
}
