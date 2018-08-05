import java.util.Scanner;

public class Exercise1 {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.print("Enter your first name: ");
        String fName = input.next();
        System.out.print("Enter your second name: ");
        String lName = input.next();
        System.out.println();
        System.out.println("Hello \n" + fName + " " + lName);
    }
}
