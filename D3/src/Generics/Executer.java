package Generics;

public class Executer
{
    public static void main(String args[])
    {
        String filePath="Generic.txt";
        
        User u = new User(15,"Emre","Omer","12345",12);
        Utility<User> g = new Utility<User>(u);
        g.serialize(u,filePath);

        System.out.println(g.deSerialize(filePath).getName() +" "+ g.deSerialize(filePath).getAge());
    }
}
