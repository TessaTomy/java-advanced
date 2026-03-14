class ThreadDemo{
    public static void main(String args[]) throws InterruptedException{
        ThreadA a=new ThreadA();
        Thread b=new Thread(new ThreadB());
        a.start(); b.start();
        a.join(); b.join();
        System.out.println("Calculation Completed !!");
    }
}
class ThreadA extends Thread{
    public void run()
    {
        for(int i=1;i<=10;i++)
        {
            System.out.println("Square("+i+") = "+i*i);
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){}
        }
    }
}
class ThreadB extends Thread{
    public void run()
    {
        for(int i=1;i<=10;i++)
        {
            System.out.println("Cube("+i+") = "+i*i*i);
            try{
                Thread.sleep(700);
            }
            catch(Exception e){}
        }
    }
}
