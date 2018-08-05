import java.util.Scanner;

public class HasTeen {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the first number:");
        int first = input.nextInt();
        System.out.print("Please enter the second number:");
        int second = input.nextInt();
        System.out.print("Please enter the third number:");
        int third = input.nextInt();
        System.out.print(hasTeen(first,second,third));
    }
    public static boolean hasTeen (int a, int b, int c) {
        if ( (a>=13 && a<=19) || (b>=13 && b<=19) || (c>=13 && c<=19) )    {
            return true;
        } else return false;
    }

}
