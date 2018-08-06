import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import java.util.Scanner;

public class MainManu {
    public static void main (String[] args) throws Exception {

        returnToMainMenu();
    }

    public static int choice(){
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    public static void returnToMainMenu() throws Exception {
        System.out.println();
        System.out.println("Please choose an option: \n\n1. Enter values \n2. View report \n");
        getInputChoice(choice());
    }

    public static void getInputChoice(int choice) throws Exception {
        switch (choice) {
            case 1:
                EnterValue.enterValue();
                break;
            case 2:
                Report.viewReport();
                break;
            default:
                while (choice != 1 && choice != 2) {
                    System.out.println("There is NOT such option. Please try again");
                    returnToMainMenu();
                    getInputChoice(choice());
                    if (choice == 1) EnterValue.enterValue();
                    if (choice == 2) Report.viewReport();
                }
        }
    }

}