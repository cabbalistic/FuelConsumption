import java.util.Scanner;

public class DayOfWeek2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a week day number: ");
        int n = input.nextInt();
        dayOfWeek(n);
    }

    public static void dayOfWeek(int n) {
            switch (n) {
                case 1:
                    System.out.println("Monday");
                case 2:
                    System.out.println("Tuesday");
                case 3:
                    System.out.println("Wednesday");
                case 4:
                    System.out.println("Thursday");
                case 5:
                    System.out.println("Friday");
                case 6:
                    System.out.println("Saturday");
                case 7:
                    System.out.println("Sunday");
                    break;
                default:
                    System.out.println("Invalid day!");
                    break;
            }
    }
}
