import java.util.Scanner;

public class ParrotTrouble {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter true or false if the parrot is talking: ");
        boolean isTalking = input.nextBoolean();
        System.out.print("Please enter an hour: ");
        int hour = input.nextInt();
        System.out.print(parrotTrouble(isTalking,hour));
    }
    public static boolean parrotTrouble(boolean talking, int hour){
        if (talking && (hour < 7 || hour >20)){
            return true;
        } else {
            return false;
        }
    }
}
