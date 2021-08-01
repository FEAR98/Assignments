import java.util.Scanner;

public class Array
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Enter Element Number of Array");
        int length=scan.nextInt();

        int[] A = new int[length];
        int[] B = new int[length];

        for(int t=0; t<length; t++)
        {
            System.out.println("Please Enter "+t+". Number of Array");
            A[t]=scan.nextInt();
        }

        System.out.println("Your Array: ");
        for(int t=0; t<length; t++)
        {
            System.out.print(A[t]+" ");
        }
        System.out.println("\n\nReverse of Your Array: ");
        for(int t=length-1; t>=0; t--)
        {
            System.out.print(A[t]+" ");
            B[length-t-1]=A[t];
        }
        System.out.println("\n\nArray B: ");
        for(int t=0; t<length; t++)
        {
            System.out.print(B[t]+" ");
        }
    }
}
