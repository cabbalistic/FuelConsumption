import java.util.Scanner;

public class LoneTeen {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a first number: ");
        int n1 = input.nextInt();
        System.out.print("Please enter a second number: ");
        int n2 = input.nextInt();
        System.out.print(loneTeen(n1,n2));
    }
    public static boolean loneTeen(int a, int b){
        boolean t1 = (a>=13 && a<=19) ;
        boolean t2 = (b>=13 && b<=19);
        return (t1 && !t2) || (!t1 && t2);
    }
}
