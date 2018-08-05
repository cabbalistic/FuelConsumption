import java.util.Scanner;

public class NoTripples {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a size of the array: ");
        int n = input.nextInt();
        int[] nums = new int[n];
        System.out.print("Please enter the elements (int type) of the array: ");
        for(int i=0;i<n;i++){//for reading array
            nums[i]=input.nextInt();
        }
        System.out.print(noTripples(nums));
    }
    public static boolean noTripples (int[] nums){
        for(int i=0; i<(nums.length-2); i++){
            if (nums[i+1]==nums[i] && nums[i+2]==nums[i]) return false;
        }
        return true;
    }
}
