import java.util.Scanner;

public class StringBits {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String str = input.next();
        System.out.print(stringBits(str));
    }
    public static String stringBits(String str){
        String tmp = "";
        for(int i = 0; i<str.length(); i+=2){
            tmp = tmp + str.charAt(i);
        } return tmp;
    }
}
