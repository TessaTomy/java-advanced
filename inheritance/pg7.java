class Animal{
    private String species;
    protected int age,weight;
    String color;
    Animal()
    {
        species="";
        age=0;
        weight=0;
        color="";
    }
    Animal(String s,int a,int w,String c)
    {
        species=s;
        age=a;
        weight=w;
        color=c;
    }
    Animal(Animal s)
    {
        species=s.species;
        age=s.age;
        weight=s.weight;
        color=s.color;
    }

    public String toString()
    {
        return species+" of age :"+age+" color :"+color+" weights"+weight;
    }
}

class Dog extends Animal{
    String breed,name,owner;
    Dog(String s,int a,int w,String c)
    {
        super(s,a,w,c);
        breed="xyz";
        name="dog";
        owner="x";
    }
    public String toString()
    {
        return name+" of breed :"+breed+" belongs to :"+owner;
    }
}

class Cat extends Animal{
    String name,eyecolor,tailLength;
    Cat(String s,int a,int w,String c)
    {
        super(s,a,w,c);
        name="cat";
        eyecolor="abc";
        tailLength="x";
    }
    public String toString()
    {
        return name+" of eyecolor :"+eyecolor+" with tail lenght of :"+tailLength;
    }
}

public class pg7 {
    public static void main(String[] args) {
        Animal a;
        a=new Dog("dog",12,56,"black");
        System.out.println(a);
        a=new Cat("cat",2,45,"white");
        System.out.println(a);
    }
}

