import java.util.Scanner;

public class moneyTrouble {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter true or false for monkey a: ");
        boolean a = input.nextBoolean();
        System.out.print("Please enter true or false for monkey b: ");
        boolean b = input.nextBoolean();
        System.out.print(moneyTrouble(a,b));
    }
    public static boolean moneyTrouble(boolean aSmile, boolean bsmile){
        if ( (!aSmile && !bsmile) || (aSmile && bsmile)){
            return true;
        } else return false;
    }
}
