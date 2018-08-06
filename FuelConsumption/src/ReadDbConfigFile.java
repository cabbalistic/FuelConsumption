import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadDbConfigFile {
    public static String readFileAsString ()throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get("C:\\Users\\Ivan\\IdeaProjects\\FuelConsumption\\dbconfig.txt")));
        return data;
    }
}
