class ReaderWriter{
    boolean isWriting=false;
    public synchronized void read() throws InterruptedException
    {
        while(isWriting)
            wait();
        System.out.println("Reading......");
        notifyAll();
    }
    public synchronized void write() throws InterruptedException
    {
        while(isWriting)
            wait();
        isWriting=true;
        System.out.println("Writing......");
         Thread.sleep(100);
        isWriting=false;
        notifyAll();
    }
}

class pg25{
    static int data;
    public static void main(String args[])
    {
        ReaderWriter rw=new ReaderWriter();
        Thread rd=new Thread(()->{
            for(int i=0;i<5;i++)
            {
                try{
                
                        rw.read();
                       
                     Thread.sleep(100);
                }
                catch(InterruptedException e){}
            }
        });

        Thread wt=new Thread(()->{
            for(int i=0;i<5;i++)
            {
                try{
                    
                        rw.write();
                       
                    
                }
                catch(InterruptedException e){}
            }
        });

        rd.start();
        wt.start();
    }
}
