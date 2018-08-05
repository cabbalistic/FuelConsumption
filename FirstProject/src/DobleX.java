import java.util.Scanner;

public class DobleX {
    public static void main(String[] args){
        Scanner inputValue = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String str = inputValue.nextLine();
        System.out.print(doubleX(str));
    }
    public static boolean doubleX(String str){
        int position1 = str.indexOf("x");
        if (position1 >= str.length()-1 || position1 == -1)
            return false;
        if(position1 >= 0 && str.charAt(position1+1)=='x' ){
            return true;
        }
        return false;
    }
}
