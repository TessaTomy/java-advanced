import java.util.*;
class pg20{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        HashMap <Integer,String> stud=new HashMap<>();
        int choice;
        do{
            System.out.print("1.Add\t2.Find\t3.Display\t4.Exit \n>> ");
            choice=s.nextInt();
            switch(choice){
             
             case 1->{
                System.out.println("Roll no and Name :");
                int r=s.nextInt();
                s.nextLine();
                String n=s.nextLine();
                stud.put(r,n);
             }   
             case 2->
             {
                System.out.print("Roll No : ");
                int r=s.nextInt();
                if(stud.containsKey(r))
                    System.out.println(r+ " : "+stud.get(r));
                else 
                    System.out.println("No student of ID "+r+" Found !!");
             }
             case 3->{
                for(Map.Entry<Integer,String> e:stud.entrySet())
                    System.out.println( e.getKey() + " : " + e.getValue());
             }
            }
        }while(choice!=4);
        s.close();
    }
}
