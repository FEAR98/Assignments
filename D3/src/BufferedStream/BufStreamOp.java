package BufferedStream;

import BufferedFileOperations.BufferedOp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufStreamOp implements FileReadWrite
{

    @Override
    public String read(String filePath)
    {
        String str = "";
        try{
            FileInputStream fin=new FileInputStream(filePath);
            BufferedInputStream bin=new BufferedInputStream(fin);
            int i;
            while((i=bin.read())!=-1)
            {
                str += (char) i;
            }
            bin.close();
            fin.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }

        return str;
    }

    @Override
    public void write(String filePath, String data)
    {
        try {
            FileOutputStream fout = new FileOutputStream(filePath,true);
            BufferedOutputStream bout = new BufferedOutputStream(fout);
            String s = data;
            byte b[] = s.getBytes();
            bout.write(b);
            bout.flush();
            bout.close();
            fout.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String args[])
    {

        BufStreamOp b1 = new BufStreamOp();
        System.out.print("Current Time in milliseconds = ");
        long t1=System.currentTimeMillis();
        System.out.println(t1);
        for(int i=0; i<100000; i++)
        {
            b1.write("BIStest.txt","Emre ");
        }
        System.out.print("Current Time in milliseconds = ");
        long t2=System.currentTimeMillis();
        System.out.println(t2);
        System.out.println("Time: " + Math.subtractExact(t2, t1));

        b1.read("BIStest.txt");

        System.out.print("Current Time in milliseconds = ");
        long t3=System.currentTimeMillis();
        System.out.println(t3);
        System.out.println("Time: " + Math.subtractExact(t3, t2));
    }
}
