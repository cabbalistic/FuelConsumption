import java.util.Scanner;

public class ArrayFront9 {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a size of the array: ");
        int n = input.nextInt();
        int[] num = new int[n];
        System.out.print("Please enter the elements (int type) of the array: ");
        for (int i = 0; i < n; i++) {//for reading array
            num[i] = input.nextInt();
        }
        System.out.print(arrayFront9(num));
    }
    public static boolean arrayFront9(int[] nums){
        int len = 4;
        if(nums.length<=4){
            len = nums.length;
        }
        for(int i=0; i<len; i++){
            if(nums[i] == 9) return true;
        } return false;
    }
}
