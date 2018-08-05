import java.util.Scanner;

public class FrontTimes {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String str = input.next();
        System.out.print("Please enter a number: ");
        int n = input.nextInt();
        System.out.print(frontTimes(str,n));
    }
    public static String frontTimes(String str, int n){
        String tmp = "";
        int position = 3;
        if (str.length() <= 3) {
            position = str.length();
        }
        String front = str.substring(0,position);
        for(int i=1; i<=n; i++){
           tmp = tmp + front;
        } return tmp;
    }
}
