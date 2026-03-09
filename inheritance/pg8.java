class Vehicle{
    String model,company;
    Vehicle()
    {
        model="sample";
        company="sampleCompany";
    }

    String display()
    {
        return model+"--"+company;
    }
}

class Car extends Vehicle{
    int no_of_doors;
    String fuel_type;
    Car()
    {
        no_of_doors=2;
        fuel_type="p";
    }

    String display()
    {
        return model+"--"+company+"--"+no_of_doors+"--"+fuel_type;
    }
}

class Electric extends Car{
    int batterycapacity;
    Electric()
    {
        batterycapacity=739488;
    }
    String display()
    {
        return model+" "+company+" "+no_of_doors+" "+fuel_type+" "+batterycapacity;
    }
}

public class pg8 {
    public static void main(String args[])
    {
        Vehicle v;
        v=new Car();
        System.out.println(v.display());
        v=new Electric();
        System.out.println(v.display());
    }
}
