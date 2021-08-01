package FileOperation1;

import java.io.FileWriter;

public class FileWriterTest
{
    public static void Writer(String st)
    {
        try{
            FileWriter fw=new FileWriter("test.txt");
            fw.write(st);
            fw.close();
        }catch(Exception e){System.out.println(e);}
        System.out.println("Success.");
    }



    public static void main(String args[])
    {
        Writer("1 2 3 4 Tamam");
    }

}
