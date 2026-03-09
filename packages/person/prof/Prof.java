package person.prof;

import person.*;

public class Prof extends Person implements printer
{
    int id,dept;
    public void read()
    {
        id=s.nextInt();
        dept=s.nextInt();
        super.read();
    }
    public String display()
    {
        return id+" : "+dept;
    }
}
