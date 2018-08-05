import java.util.Scanner;

public class Array667 {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a size of the array: ");
        int n = input.nextInt();
        int[] nums = new int[n];
        System.out.print("Please enter the elements (int type) of the array: ");
        for (int i = 0; i < n; i++) {//for reading array
            nums[i] = input.nextInt();
        }
        System.out.print(array667(nums));
    }
    public static int array667(int[] nums){
        int counter = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == 6 && (nums[i+1] == 6 || nums[i+1] == 7)) {
                counter++;
            }
        } return counter;
    }
}
