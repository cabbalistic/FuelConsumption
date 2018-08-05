import java.util.Scanner;

public class MissingChar {
    public static void main (String[] args){
        Scanner inputValue = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String stringValue = inputValue.next();
        System.out.print("Please enter the position of the char you want to remove: ");
        int position = inputValue.nextInt();
        int strLength = stringValue.length()-1;
        String msg = "Please enter a number between 0 and " + strLength + " :";
        while (strLength < position) {
            System.out.print(msg);
            position = inputValue.nextInt();
        }
        System.out.print(missChar(stringValue, position));
    }
    public static String missChar(String str, int n){
            String firstStr = str.substring(0,n);
            String secondStr = str.substring(n+1);
            String result = firstStr +secondStr;
            return result;
    }
}
