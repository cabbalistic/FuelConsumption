import java.util.Scanner;

public class StringE {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String str = input.next();
        System.out.print(stringE(str));
    }

    public static boolean stringE(String str){
        int counter = 0;
        for ( int i=0; i<str.length(); i++) {
            if (str.charAt(i) == 'e') {
                counter++;
            }
        }
        if (counter <= 3 && counter > 0) {
                return true;
            } else return false;

    }
}
