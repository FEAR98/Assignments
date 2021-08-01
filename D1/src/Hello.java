import java.util.Scanner;


public class Hello{

    public static void main(String[] args)
    {
        System.out.println("Please enter your age");

        Scanner reader = new Scanner(System.in);
        int number = reader.nextInt();

        if(number>30)
        {
            System.out.println("Old");
        }
        else
        {
            System.out.println("Young");
        }
    }


}
