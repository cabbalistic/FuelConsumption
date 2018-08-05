import java.util.Scanner;

public class ArrayCount9 {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a size of the array: ");
        int n = input.nextInt();
        int[] num = new int[n];
        System.out.print("Please enter the elements (int type) of the array: ");
        for(int i=0; i<n; i++){//for reading array
            num[i]=input.nextInt();
        }
        System.out.print(arrayCount9(num));
    }
    public static int arrayCount9 (int[] num){
        int counter = 0;
        for (int i=0; i<num.length; i++) {
            if(num[i] == 9){
                counter++;
            }
        } return counter;
    }
}
