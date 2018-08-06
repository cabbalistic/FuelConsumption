import java.sql.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Report {
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
    public static void viewReport(){
        generalReport();
        averageReport();
        System.out.println();
        System.out.print("Press 1 to return to main menu\nPress 2 to view report for particular date\n");
        int option = MainManu.choice();
        switch (option) {
            case 1:
                MainManu.returnToMainMenu();
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
                    option= MainManu.choice();
                    if (option == 1) MainManu.returnToMainMenu();
                    if (option == 2) detailedReport(year,month,day);
                }
        }
    }

    public static void generalReport(){
        try (Connection con = DriverManager.getConnection(SqlConnection.sqlConnection()); Statement stmt = con.createStatement();) {
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
        try (Connection con = DriverManager.getConnection(SqlConnection.sqlConnection()); Statement stmt = con.createStatement();) {
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
        try (Connection con = DriverManager.getConnection(SqlConnection.sqlConnection()); Statement stmt = con.createStatement();) {
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


        try (Connection con = DriverManager.getConnection(SqlConnection.sqlConnection()); Statement stmt = con.createStatement();) {
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
