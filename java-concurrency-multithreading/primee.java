import java.util.*;

class shared
{
    boolean seePrime=true;
    boolean primeFinished=false;
    boolean studentFinished=false;
}

class student
{
    String name,rollno;
    shared s;
    Scanner sc=new Scanner(System.in);
    student(shared s)
    {
        this.s=s;
        name=sc.nextLine();
        rollno=sc.nextLine();
    }
    void display() throws Exception{
        synchronized(s)
        {
            if(s.primeFinished)
            {
                System.out.println(name);
                return;
            }
            while(s.seePrime)
                s.wait();
            System.out.println(name);
            s.seePrime=true;
            s.notifyAll();
        }
    }    
}

class Prime
{
    static shared s;
    Prime(shared s)
    {
        this.s=s;
    }
    void display(int n)  throws Exception{
        synchronized(s)
        {
            if(s.studentFinished)
            {
                checkPrime(n);
                return;
            }
            while(!s.seePrime)
                s.wait();
            checkPrime(n);
            s.seePrime=false;
            s.notifyAll();
        }
    }

    void checkPrime(int n)
    {
        if(n==0||n==1)
            return;
        for(int i=2;i<n;i++)
        {
            if(n%i==0)
                return;
        }
        System.out.println(n+" - Prime");
    }    
}

class primee{
    public static void main(String a[]) throws Exception
    {
        shared s=new shared();
        Prime p=new Prime(s);
        ArrayList<student> st=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        do{
            st.add(new student(s));
            System.out.println("Wanna add new Student (y/n) : ");
        }while("y".equals(sc.nextLine()));

        Thread t1=new Thread(()->{
            try{
                for(int i=2;i<=st.size();i++)
                    p.display(i);
                s.primeFinished=true;
            }catch(Exception e){}
        });

        Thread t2=new Thread(()->{
            try{
                for(student st1:st)
                    st1.display();
                s.studentFinished=true;
            }catch(Exception e){}
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
