import java.util.Scanner;

public class TwoDimensionalArray
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Enter Number of Area");
        int length=scan.nextInt();

        String[][] CityArea = new String[2][length];

        for(int i=0; i<length ; i++)
        {
            System.out.println("Enter Area No:"+ i);
            CityArea[1][i] = scan.next();

            System.out.println("Please Enter City of Area: "+ CityArea[1][i]);
            CityArea[0][i] = scan.next();
        }
        for(int j=0; j<length; j++)
        {
            System.out.println( CityArea[0][j] +","+ CityArea[1][j] );
        }

    }
}
