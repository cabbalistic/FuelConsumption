import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;
import java.util.Scanner;

public class MainManu {
    public static void main (String[] args){

        returnToMainMenu();
    }

    public static int choice(){
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    public static String[]  filterDate(){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter year: ");
        String year = input.next();
        System.out.print("Please enter month: ");
        String month = input.next();
        if (month.length() == 1) month = "0" + month;
        System.out.print("Please enter day: ");
        String day = input.next();
        if (day.length() == 1) day = "0" + day;
        return new String[] {year, month, day};

    }

//    public static void displayMenu()  {
//        System.out.println("Please choose an option: \n\n1. Enter values \n2. View report \n");
//    }

    public static void returnToMainMenu()  {
        System.out.println();
        System.out.println("Please choose an option: \n\n1. Enter values \n2. View report \n");
        getInputChoice(choice());
    }

    public static void getInputChoice(int choice) {
        switch (choice) {
            case 1:
                enterValue();
                break;
            case 2:
                viewReport();
                break;
            default:
                while (choice != 1 && choice != 2) {
                    System.out.println("There is NOT such option. Please try again");
                    returnToMainMenu();
                    getInputChoice(choice());
                    if (choice == 1) enterValue();
                    if (choice == 2) viewReport();
                }
        }
    }

    public static String sqlConnection(){
        // Create a variable for the connection string.
        return "jdbc:sqlserver://BAHUR:1433;instanceName=dbo.inputValue;databaseName=test;user=ovi;password=123";
    }

    public static void enterValue(){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the km: ");
        double km = input.nextDouble();
        System.out.print("Please enter the ltr: ");
        double fuel = input.nextDouble();
        System.out.print("Please enter the date: ");
        String date = input.next();

        try (Connection con = DriverManager.getConnection(sqlConnection()); Statement stmt = con.createStatement();) {

            PreparedStatement st =  con.prepareStatement("INSERT INTO inputValue(km,fuel,date) VALUES (?,?,?)");
            st.setDouble(1,km);
            st.setDouble(2,fuel);
            st.setString(3,date);
            int a = st.executeUpdate();
            System.out.println();
            if (a>0){
                System.out.print("The record has been inserted!");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println();
        returnToMainMenu();
        //getInputChoice(choice());
    }

    public static void viewReport(){
        generalReport();
        averageReport();
        System.out.println();
        System.out.print("Press 1 to return to main menu\nPress 2 to view report for particular date\n");
        int option = choice();
        switch (option) {
            case 1:
                returnToMainMenu();
                break;
            case 2:
                String result[] = filterDate();
                String year = result[0];
                String month = result[1];
                String day = result[2];
                detailedReport(result[0],result[1],result[2]);
                break;
            default:
                result = filterDate();
                year = result[0];
                month = result[1];
                day = result[2];
                while (option != 1 && option != 2) {
                    System.out.println("There is NOT such option. Please try again");
                    System.out.println("Press 1 to back to main menu or 2 for detailed report");
                    option=choice();
                    if (option == 1) returnToMainMenu();
                    if (option == 2) detailedReport(year,month,day);
                }
        }
    }

    public static void generalReport(){
        try (Connection con = DriverManager.getConnection(sqlConnection()); Statement stmt = con.createStatement();) {
            String SQL = "SELECT km, fuel, CONVERT(char(10), date,126) as date FROM inputValue order by date";
            ResultSet rs = stmt.executeQuery(SQL);

            System.out.print("  km \t|  fuel |  date\t\t  | ltrPerKm | ltrPer100km\n---------------------------------------------------------\n");

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                DecimalFormat f = new DecimalFormat("0.00");
                float km = rs.getFloat("km");
                float fuel = rs.getFloat("fuel");
                String date = rs.getString("date");
                double ltrPerKm = (fuel/km) ;
                double ltrPer100km = ((fuel/km)*100) ;
                System.out.println(km + "\t|  " + fuel +
                        "\t| " + date + "  | " + f.format(ltrPerKm) +
                        "\t | \t " + f.format(ltrPer100km));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void averageReport(){
        try (Connection con = DriverManager.getConnection(sqlConnection()); Statement stmt = con.createStatement();) {
            String SQL = "SELECT (SUM(fuel)/SUM(km))*100 as average FROM inputValue";
            ResultSet rs = stmt.executeQuery(SQL);
            System.out.println();
            System.out.print("Average ltrs per 100km\n------\n");
            while (rs.next()) {
                double average = rs.getDouble("average");
                DecimalFormat f = new DecimalFormat("##.00");
                System.out.println(f.format(average));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void detailedReport(String year, String month ,String day){
        try (Connection con = DriverManager.getConnection(sqlConnection()); Statement stmt = con.createStatement();) {
            String SQL = "SELECT km, fuel, CONVERT(char(10), date,126) as date FROM inputValue WHERE DATEPART(year,date)=" + year +" AND DATEPART(month,date)=" + month + " AND DATEPART(day,date)=" + day;
            ResultSet rs = stmt.executeQuery(SQL);
            System.out.println();
            System.out.print("  km \t|  fuel |  date\t\t  | ltrPerKm | ltrPer100km\n---------------------------------------------------------\n");
            while (rs.next()) {
                DecimalFormat f = new DecimalFormat("0.00");
                float km = rs.getFloat("km");
                float fuel = rs.getFloat("fuel");
                String date = rs.getString("date");
                double ltrPerKm = (fuel/km) ;
                double ltrPer100km = ((fuel/km)*100) ;
                System.out.println(km + "\t|  " + fuel +
                        "\t| " + date + "  | " + f.format(ltrPerKm) +
                        "\t | \t " + f.format(ltrPer100km));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }


        try (Connection con = DriverManager.getConnection(sqlConnection()); Statement stmt = con.createStatement();) {
            String SQL = "SELECT (SUM(fuel)/SUM(km))*100 as average FROM inputValue WHERE DATEPART(year,date)=" + year +" AND DATEPART(month,date)=" + month + " AND DATEPART(day,date)=" + day;
            ResultSet rs = stmt.executeQuery(SQL);
            System.out.println();
            System.out.print("Average ltrs per 100km\n------\n");
            while (rs.next()) {
                double average = rs.getDouble("average");
                DecimalFormat f = new DecimalFormat("##.00");
                System.out.println(f.format(average));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}