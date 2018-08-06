import java.sql.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Report {

    SqlConnection connection = new SqlConnection();
    MainManu ruturnMain = new MainManu();

    private String[]  filterDate(){
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

    private int[] filterDayCount() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the days: ");
        int days = input.nextInt();
        System.out.print("Please record count: ");
        int records = input.nextInt();
        return new int[] {days, records};
    }

    public void viewReport() throws Exception {

        //SqlConnection connection = new SqlConnection();


        generalReport();
        //averageReport();
        System.out.println();
        System.out.print("Press 1 to return to main menu\nPress 2 to view report for particular date\nPress 3 to view report for N days ago from today\n");
        int option = ruturnMain.choice();
        switch (option) {
            case 1:
                ruturnMain.returnToMainMenu();
                break;
            case 2:
                String result[] = filterDate();
                String year = result[0];
                String month = result[1];
                String day = result[2];
                detailedReport(result[0],result[1],result[2]);
                break;
            case 3:
                int daysResult[] = filterDayCount();
                int days = daysResult[0];
                int records = daysResult[1];
                nDaysAgoReport(days,records);
                break;
            default:
                result = filterDate();
                year = result[0];
                month = result[1];
                day = result[2];
                daysResult = filterDayCount();
                days = daysResult[0];
                records = daysResult[1];
                while (option != 1 && option != 2) {
                    System.out.println("There is NOT such option. Please try again");
                    System.out.println("Press 1 to back to main menu or 2 for detailed report");
                    option= ruturnMain.choice();
                    if (option == 1) ruturnMain.returnToMainMenu();
                    if (option == 2) detailedReport(year,month,day);
                    if (option == 3) nDaysAgoReport(days,records);

                }
        }
    }

    private void generalReport() throws Exception {
        String dbResult[] = connection.sqlConnection();
        String database = dbResult[0];
        String dbconnection = dbResult[1];

        try (Connection con = DriverManager.getConnection(dbconnection); Statement stmt = con.createStatement();) {
            String SQL = "SELECT km, fuel, date FROM inputValue order by date";
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

        try (Connection con = DriverManager.getConnection(dbconnection); Statement stmt = con.createStatement();) {
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

    private void detailedReport(String year, String month ,String day) throws Exception {
        String dbResult[] = connection.sqlConnection();
        String database = dbResult[0];
        String dbconnection = dbResult[1];
        try (Connection con = DriverManager.getConnection(dbconnection); Statement stmt = con.createStatement();) {
            String SQL = "SELECT km, fuel,  date FROM inputValue WHERE DATEPART(year,date)=" + year +" AND DATEPART(month,date)=" + month + " AND DATEPART(day,date)=" + day;
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


        try (Connection con = DriverManager.getConnection(dbconnection); Statement stmt = con.createStatement();) {
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

    private void nDaysAgoReport(int days, int records) throws Exception {
        String dbResult[] = connection.sqlConnection();
        String database = dbResult[0];
        String dbconnection = dbResult[1];

        try (Connection con = DriverManager.getConnection(dbconnection); Statement stmt = con.createStatement();) {
            String SQL = "";

            switch (database){
                case "msql":
                    SQL =  "SELECT TOP " + records +" km, fuel, date FROM inputValue WHERE date between DateAdd(DD,-" + days +",GETDATE() ) and GETDATE()";
                    break;
                case "mysql":
                    SQL = "SELECT km, fuel, date FROM inputValue WHERE  date BETWEEN DATE_ADD( NOW() , INTERVAL -" + days + " DAY) AND NOW() order by date LIMIT " + records;
                    break;
            }
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


        try (Connection con = DriverManager.getConnection(dbconnection); Statement stmt = con.createStatement();) {
            String SQL = "";

            switch (database){
                case "msql":
                    SQL =  "SELECT TOP " + records +" (SUM(fuel)/SUM(km))*100 as average FROM inputValue WHERE date between DateAdd(DD,-" + days +",GETDATE() ) and GETDATE()";
                    break;
                case "mysql":
                    SQL = "SELECT (SUM(fuel)/SUM(km))*100 as average FROM inputValue WHERE date BETWEEN DATE_ADD( NOW() , INTERVAL -" + days + " DAY) AND NOW() order by date LIMIT " + records;
                    break;
            }
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
