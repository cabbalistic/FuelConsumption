import java.util.Scanner;

public class EveryNth {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String str = input.next();
        System.out.print("Please enter a number: ");
        int n = input.nextInt();
        System.out.print(everyNth(str,n));
    }
    public static String everyNth(String str, int n){
        String result = "";
        for(int i = 0; i < str.length(); i = i +n){
            result = result + str.charAt(i);
        }
        return result;
    }
}
