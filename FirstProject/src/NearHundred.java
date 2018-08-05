import java.util.Scanner;

public class NearHundred {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int inputNumber = input.nextInt();
        System.out.print(nearHundred(inputNumber));
    }

    public static boolean nearHundred(int num) {
        if (Math.abs(100 - num) <= 10 || Math.abs(200 - num) <=10) {
            return true;
        } else return false;
    }
}
