import java.util.Scanner;

public class lastDigit {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter first number: ");
        int firstNum = input.nextInt();
        System.out.print("Please enter second number: ");
        int secondNum = input.nextInt();
        System.out.print(lastDigit(firstNum,secondNum));
    }
    public static boolean lastDigit(int a, int b){
        return(a % 10 == b % 10);
    }
}
