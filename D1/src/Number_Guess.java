import java.util.Scanner;
import java.util.Random;


public class Number_Guess{

    public static void main(String[] args)
    {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        int top = 100, bound = 0;

        int random_Number = rand.nextInt(100);
        System.out.println((random_Number));

        int move = 0;

        while(move<5)
        {
            System.out.println("(Top:"+ top +", Bound: "+ bound +") Enter your guess: ");
            int guess = scan.nextInt();

            if( guess > random_Number )
            {
                System.out.println("Down");
                top = guess;
                move++;
            }
            else if( guess == random_Number )
            {
                System.out.println("True! You won!");
                break;
            }
            else
            {
                System.out.println("Up");
                bound = guess;
                move++;
            }
        }
        if(move == 5)
        {
            System.out.println("You did 5 moves! You lose!");
        }

    }


}
