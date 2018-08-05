import java.util.Scanner;

public class StringTimes {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String str = input.nextLine();
        System.out.print("Please enter a number: ");
        int n = input.nextInt();
        System.out.print(stringTimes(str,n));
    }
    public static String stringTimes(String str, int n){
        String tmp = "";
        for (int i = 0; i < n; i++){
            str = str + tmp;
        }
        return tmp;
    }
}
