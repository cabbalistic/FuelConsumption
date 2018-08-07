import java.util.ArrayList;

public class Main {
    public static void main (String[] args) throws Exception {

        ReadSourceFile readSrc = new ReadSourceFile();

        ArrayList<String> arrl = new ArrayList<String>();
        arrl = readSrc.readSourceFile();

        ArrayList<Car> obj = new ArrayList<Car>();

        for (int i = 0; i < arrl.size(); i++) {
            obj.add(new Car(arrl.get(i)));
        }

        for (int i = 0; i < obj.size(); i++) {
            String brand = "";
            String country = "";
            brand = obj.get(i).carBrand;
            switch (brand) {
                case "mercedes":
                case "bwm":
                case "vw":
                case "audi":
                    country = " Germany" ;
                    break;
                case "peugeot":
                case "renault":
                    country = " France" ;
                    break;
                case "ford":
                    country = " USA" ;
                    break;
            }
            System.out.println(brand +country);
        }
    }
}
