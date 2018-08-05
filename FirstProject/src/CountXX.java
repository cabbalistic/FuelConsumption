import java.util.Scanner;

public class CountXX {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the second string: ");
        String str = input.next();
        System.out.print(countXX(str));
    }
    public static int countXX(String str){
        int counter = 0;
        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i) == 'x' && str.charAt(i+1) == 'x' ){
                counter++;
            }
        } return counter;
    }
}
