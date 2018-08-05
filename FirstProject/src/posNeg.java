import java.util.Scanner;

public class posNeg {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter first number: ");
        int firstNum = input.nextInt();
        System.out.print("Please enter second number: ");
        int secondNum = input.nextInt();
        System.out.print("Please enter true or false for the negative parameter: ");
        boolean negative = input.nextBoolean();
        System.out.print(posNeg(firstNum,secondNum,negative));
    }
    public static boolean posNeg (int a, int b, boolean negative){
       return( (a > 0 && b < 0 && !negative) || (a < 0 && b > 0 && !negative) || (a < 0 && b < 0 && negative) );
        }
    }
