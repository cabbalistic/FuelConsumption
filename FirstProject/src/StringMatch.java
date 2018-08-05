import java.util.Scanner;

public class StringMatch {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the first string: ");
        String str1 = input.next();
        System.out.print("Please enter the second string: ");
        String str2 = input.next();
        System.out.print(stringMatch(str1,str2));
    }
    public static int stringMatch (String str1, String str2){
        int n = Math.min(str1.length(), str2.length());
        int counter = 0;

        for(int i=0; i<n-1; i++){
            String a = str1.substring(i,i+2);
            String b = str2.substring(i,i+2);
            if( a.equals(b)) {
                counter++;
            }
        } return counter;
    }
}
