import java.util.Scanner;

public class StringYak {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String str = input.next();
        System.out.print(stringYak(str));

    }
    public static String stringYak (String str){
        String tmp = "";
        for(int i=0; i<str.length(); i++){
            if(i+2<str.length() && str.charAt(i)=='y' && str.charAt(i+2)=='k') {
                i = i + 2;
            } else {
                tmp = tmp + str.charAt(i);
            }
        } return tmp;
    }
}
