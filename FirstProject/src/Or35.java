import java.util.Scanner;

public class Or35 {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int n = input.nextInt();
        System.out.print(or35(n));
    }
    public static boolean or35(int n){
        return (n%3 == 0 || n%5 == 0);
    }
}
