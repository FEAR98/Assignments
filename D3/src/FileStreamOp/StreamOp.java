package FileStreamOp;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class StreamOp
{
    public void write(String filePath, String data)
    {
        try{
            FileOutputStream fout=new FileOutputStream(filePath);

            byte b[]=data.getBytes();
            fout.write(b);
            fout.close();
            System.out.println("Success");
        }catch(Exception e){System.out.println(e);}
    }
    public String read(String filePath)
    {
        String str = "";

        try{
            FileInputStream fin = new FileInputStream(filePath);
            int i;
            while((i=fin.read())!=-1)
            {
                str += (char) i;
                System.out.print(i + " ");
            }
            System.out.println();
            fin.close();
        }catch(Exception e){System.out.println(e);}
        return str;
    }

    public static void main(String args[])
    {
        StreamOp s1 = new StreamOp();
        s1.write("FIStest.txt","Test");
        System.out.println(s1.read("FIStest.txt"));
    }
    }
