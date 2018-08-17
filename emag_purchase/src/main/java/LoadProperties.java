import java.io.*;
import java.util.Properties;

public class LoadProperties {

    private LoadProperties(){}

    public static String getValue(String key){
        Properties prop = new Properties();
        InputStream input = null;

        String value = "";
        try {
            input = new FileInputStream("properties.txt");

            // load a properties file
            prop.load(input);

            // set the property value
            value = prop.getProperty(key);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } return value;
    }
}


