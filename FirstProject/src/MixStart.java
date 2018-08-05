import java.util.Scanner;

public class MixStart {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String str = input.next();
        System.out.print(mixStart(str));
    }
    public static boolean mixStart(String str){
        String secondThirdLetters = str.substring(1,3);
        if (secondThirdLetters.equals( "ix")){
            return true;
        } else return false;
    }

}
