package UserProject;

import java.io.*;

public class Test
{
    public void Serializer(String filePath,int id,String name, String surname, String password, int age)
    {

        try
        {
            User user = new User(id,name,surname,password,age);
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void Deserializer(String filepath)
    {

        try
        {
            FileInputStream is = new FileInputStream(filepath);
            ObjectInput ois = new ObjectInputStream(is);
            User us = (User) ois.readObject();
            System.out.println(us.getName());
            System.out.println(us.getId());
            System.out.println(us.getPassword());
        } catch (ClassNotFoundException | IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args)
    {
        Test t1 = new Test();
        t1.Serializer("UserList.txt",123,"Emre","Omer","12345",25);
        t1.Deserializer("UserList.txt");
    }
}
