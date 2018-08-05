import java.util.Scanner;

public class IcyHot {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number1: ");
        int n1 = input.nextInt();
        System.out.print("Please enter a number2: ");
        int n2 = input.nextInt();
        System.out.print(icyHot(n1,n2));
    }
    public static boolean icyHot(int temp1, int temp2){
        return((temp1<0 && temp2>100) || (temp1>100 && temp2<0));
    }
}
