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
        this.country = returnCountry();
    }

    private String returnCountry () {

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
