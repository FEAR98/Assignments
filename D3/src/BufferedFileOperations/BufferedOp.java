package BufferedFileOperations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedOp
{

    public void readBuf(String filename)
    {
        try{
            FileReader fr=new FileReader(filename);
            BufferedReader br=new BufferedReader(fr);

            int i;
            while((i=br.read())!=-1){
                System.out.print((char)i);
            }
            br.close();
            fr.close();
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    public void writeBuf(String filename, String text)
    {
        try{
            FileWriter writer = new FileWriter(filename,true);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.newLine();
            buffer.write(text);
            buffer.close();
            System.out.println("Successfully completed");
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args)
    {
        BufferedOp b1 = new BufferedOp();
        b1.writeBuf("test.txt","Deneme2");

        b1.readBuf("test.txt");
    }
}
