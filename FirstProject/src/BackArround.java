import java.util.Scanner;

public class BackArround {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String string = input.next();
        System.out.print(backArround(string));
    }
    public static String backArround(String str){
        String lastChar = str.substring(str.length()-1,str.length());
        String newStr = lastChar + str + lastChar;
        return newStr;

        }
}

