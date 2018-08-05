import java.util.Scanner;

public class StringX {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String str = input.next();
        System.out.print(stringX(str));
    }
    public static String stringX (String str){
        String result = "";
        for (int i=0; i<str.length(); i++) {
            // Only append the char if it is not the "x" case
            if (!(i > 0 && i < (str.length()-1) && str.charAt(i) == 'x')) {
                result = result + str.substring(i, i+1);
            }
        }
        return result;

//        if(str.length()<=2) {
//            return str;
//        } else {
//            String begin = str.substring(0, 1);
//            String end = str.substring(str.length() - 1, str.length());
//            String middle = str.substring(1, str.length() - 1);
//            middle = middle.replace("x", "");
//            middle = begin + middle + end;
//            return middle;
//        }

    }
}
