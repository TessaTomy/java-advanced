import java.io.*;
public class Copy {
    public static void main(String[] args) {
        String content="";
        try(BufferedInputStream b=new BufferedInputStream(new FileInputStream("sample.txt")))
        {
            int x;
            while((x=b.read())!=-1)
                content+=(char)x;
        }
        catch(Exception e){}

        content=content.toUpperCase();

        try(BufferedOutputStream b=new BufferedOutputStream(new FileOutputStream("sample2.txt")))
        {
            b.write(content.getBytes());
        }

        catch(Exception e){}
    }
}
