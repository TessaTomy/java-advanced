package person.student;

import person.*;

public class Student extends Person implements printer
{
    int id,course;
    public void read()
    {
        id=s.nextInt();
        course=s.nextInt();
        super.read();
    }
    public String display()
    {
        return id+" : "+course+" : "+name;
    }
}
