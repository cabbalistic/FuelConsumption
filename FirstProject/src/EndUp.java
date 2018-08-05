import java.util.Scanner;

public class EndUp {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String str = input.nextLine();
        System.out.print(endUp(str));
    }
    public static String endUp(String str){
        if(str.length() <= 3) {
            return str.toUpperCase();
        }
        int cutPosition = str.length()-3;
        String portion1 = str.substring(0, cutPosition);
        String portion2 = str.substring(cutPosition);
        return portion1 + portion2.toUpperCase();
    }
}
