import java.sql.*;
import java.util.Scanner;

public class EnterValue {
    public static void enterValue() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the km: ");
        double km = input.nextDouble();
        System.out.print("Please enter the ltr: ");
        double fuel = input.nextDouble();
        System.out.print("Please enter the date: ");
        String date = input.next();

        String dbResult[] = SqlConnection.sqlConnection();
        String database = dbResult[0];
        String dbconnection = dbResult[1];

        try (Connection con = DriverManager.getConnection(dbconnection); Statement stmt = con.createStatement();) {

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
        MainManu.returnToMainMenu();
        //getInputChoice(choice());
    }
}
