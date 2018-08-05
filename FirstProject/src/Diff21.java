import java.util.Scanner;

public class Diff21 {
    public static void main (String[] args) {
    Scanner inputNumber = new Scanner (System.in);
    System.out.print("Pleas enter a number: ");
    int number = inputNumber.nextInt();
    System.out.print(diff(number));

    }

    public static int diff (int number){
        int result = 21 - number;
        if (number < 21 ) {
            return result;
        } else
            return Math.abs(result * 2);

    }
}
