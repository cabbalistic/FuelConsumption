import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Car {
    String carBrand;
    String country;

    Car(String brand) throws Exception {
        this.carBrand = brand;
        this.country = setCountry();
    }

    public String setCountry ()throws Exception {

            switch (carBrand) {
                case "mercedes":
                case "bwm":
                case "vw":
                case "audi":
                    this.country = " Germany" ;
                    break;
                case "peugeot":
                case "renault":
                    this.country = " France" ;
                    break;
                case "ford":
                    this.country = " USA" ;
                    break;
            }
        return country;
        }
}
