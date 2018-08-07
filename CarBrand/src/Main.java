import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main (String[] args) throws Exception {

        ReadSourceFile readSrc = new ReadSourceFile();

        ArrayList<String> arrl = new ArrayList<String>();
        arrl = readSrc.readSourceFile();
        Iterator<String> itr = arrl.iterator();

        while(itr.hasNext()){
            Car obj = new Car(itr.next());
            System.out.println(obj.carBrand);
        }
    }
}
