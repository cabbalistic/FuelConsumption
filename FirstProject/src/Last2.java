import java.util.Scanner;

public class Last2 {
    public static void main (String[] args){
        Scanner inputValue = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String str = inputValue.next();
        System.out.print(last2(str));
    }
    public static int last2(String str){
        if (str.length() < 2)
            return 0;
        //int cut = str.length()-2;
        int counter = 0;
        String lastChars = str.substring(str.length()-2);
        for (int i = 0; i < str.length()-2; i++){
            String tmp = str.substring(i,i+2);
            if(tmp.equals(lastChars)){
                counter++;
            }
        } return counter;
    }
}
