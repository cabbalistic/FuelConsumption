import java.util.Scanner;

public class StartOz {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String str = input.next();
        System.out.print(startOz(str));
    }
    public static String startOz(String str){
        String result = "";
        if (str.charAt(0)=='o' && str.length() >= 1) {
            result = result + str.charAt(0);
        }
        if (str.charAt(1)=='z' && str.length() >= 2) {
            result = result + str.charAt(1);
        }
        return result;
    }
}
