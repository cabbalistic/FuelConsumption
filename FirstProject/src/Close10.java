import java.util.Scanner;

public class Close10 {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the first number: ");
        int a = input.nextInt();
        System.out.print("Please enter the second number: ");
        int b = input.nextInt();
        System.out.print(close10(a,b));
    }
    public static int close10(int a, int b){
        int aDifference = Math.abs(10 - a);
        int bDifference = Math.abs(10 - b);
        int zero = 0;
        if (aDifference > bDifference) {
            return b;
        } else if (aDifference < bDifference){
            return a;
        } else return zero;
    }
}
