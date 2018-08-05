import java.util.Scanner;

public class SleepIn {
    public static void main (String[] args) {
        Scanner inputValue = new Scanner(System.in);
        System.out.print("Please enter true or false for weekday: ");
        boolean weekday = inputValue.nextBoolean();
        System.out.print("Please enter true or false for vacation: ");
        boolean vacation = inputValue.nextBoolean();

        if (sleepIn(weekday, vacation)) {
            System.out.print("You can go to sleep.");
        } else {
            System.out.print("You cannot go to sleep");
        }

    }

    public static boolean sleepIn ( boolean weekday, boolean vacation){
        if (!weekday || vacation) {
            return true;
        }
        return false;
    }
}
