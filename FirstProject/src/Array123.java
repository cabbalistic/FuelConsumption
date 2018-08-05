import java.util.Scanner;

public class Array123 {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a size of the array: ");
        int n = input.nextInt();
        int[] num = new int[n];
        System.out.print("Please enter the elements (int type) of the array: ");
        for(int i=0;i<n;i++){//for reading array
            num[i]=input.nextInt();
        }
        System.out.print(array123(num));
    }
    public static boolean array123(int[] nums) {
        for (int i = 0; i < (nums.length - 2); i++) {
            if (nums[i] == 1 && nums[i + 1] == 2 && nums[i + 2] == 3)
                return true;
        }
        return false;
    }
}
