public class SqlConnection {
    public static String sqlConnection() throws Exception {
        String dbConnection = "";
        String database = ReadDbConfigFile.readFileAsString();
        switch(database)
        {
            case "msql":
                dbConnection ="jdbc:sqlserver://BAHUR:1433;instanceName=dbo.inputValue;databaseName=test;user=ovi;password=123";;
                break;
            case "mysql":
                dbConnection = "jdbc:mysql://localhost/test?user=ovi&password=123";
                break;
        }
        return dbConnection;
    }
}
