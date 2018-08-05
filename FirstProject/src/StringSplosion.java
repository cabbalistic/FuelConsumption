import java.util.Scanner;

public class StringSplosion {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the second string: ");
        String str = input.next();
        System.out.print(stringSplosion(str));
    }
    public static String stringSplosion(String str){
        String tmp = "";
        for(int i=0; i<=str.length(); i++){
            tmp = tmp + str.substring(0,i);
        } return tmp;
    }
}
