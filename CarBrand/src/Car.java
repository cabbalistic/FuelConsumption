import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Car {
    String carBrand;
    String country;

    Car(String brand) {
        this.carBrand = brand;
        setCountry();
    }

    private void setCountry () {
            switch (carBrand) {
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
        }
}
