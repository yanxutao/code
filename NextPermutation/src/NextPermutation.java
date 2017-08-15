import java.util.Scanner;

/**
 * Created by yanxutao on 7/21/17.
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int k = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                k = i;
            }
        }
        if (k == -1) {
            for (int i = 0; i < nums.length / 2; i++) {
                int tmp = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = tmp;
            }
            return;
        }

        int l = k + 1;
        int min = nums[k + 1];
        for (int i = k + 1; i < nums.length; i++) {
            if (nums[i] > nums[k] && nums[i] <= min) {
                l = i;
                min = nums[i];
            }
        }

        int tmp = nums[k];
        nums[k] = nums[l];
        nums[l] = tmp;

        int begin = k + 1;
        int end = nums.length - 1;
        for (; begin < end; begin++, end--) {
            tmp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        NextPermutation np = new NextPermutation();
        np.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

}
