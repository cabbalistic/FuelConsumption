import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadSourceFile {

        public static ArrayList<String> readSourceFile ()throws Exception {

            //read file and get line count
            BufferedReader reader = new BufferedReader(new FileReader("cars.txt"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();

            //read file and push elements to arrayList
            Scanner sc = new Scanner(new File("cars.txt"));
            ArrayList<String> arrL = new ArrayList<String>();
            int i = 0;
            while (sc.hasNextLine() && i < lines) {
                String str = sc.nextLine();
                arrL.add(i,str);
                i++;
            }
            return arrL;
        }
}

