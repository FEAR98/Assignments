import java.util.Scanner;

public class HW2 {

    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);

        System.out.println("Please Enter Integer Number (Enter 101 for Exit)");
        int number;
        int count=1,total=0;
        float avg=0;
        int E=101;
        while(true) {

            number = reader.nextInt();

            if(number!=E)
            {

                if (number <= 100 && number >= 0) {

                    total += number;
                    avg = total / count;
                    count++;
                }
                else {
                    System.out.println("Please Enter Valid Integer Number");
                    break;
                }
            }
            else break;

        }
        System.out.println("Average: " + avg);
    }
}
