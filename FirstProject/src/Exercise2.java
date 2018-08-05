import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner inputValue = new Scanner(System.in);
        System.out.print("Enter your first number: ");
        int firstNumber = inputValue.nextInt();
        System.out.print("Enter your second number: ");
        int secondNumber = inputValue.nextInt();
        int sum = firstNumber + secondNumber;
        System.out.println();
        System.out.println("The sum of the two numbers is: " + sum);
    }
}