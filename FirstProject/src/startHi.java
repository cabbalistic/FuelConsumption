import java.util.Scanner;

public class startHi {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String inputStr = input.next();
        System.out.print(startHi(inputStr));
    }
    public static boolean startHi(String str){
        String firstTwoChars = str.substring(0,2);
        if (firstTwoChars.equals( "hi")){
            return true;
        } else return false;
    }

}
