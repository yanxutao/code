import java.util.Arrays;

/**
 * Created by yanxutao on 6/4/17.
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        int length = nums.length;
        int result = nums[0] + nums[1] + nums[length - 1];

        Arrays.sort(nums);

        for (int i = 0; i < length - 2; i++) {

            int j = i + 1;
            int k = length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    j++;
                } else {
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;
                }

                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosest tsc = new ThreeSumClosest();
        int[] nums = {-5, -4, -3, -2, 3};
        int ret = tsc.threeSumClosest(nums, -1);
        System.out.println(ret);
    }
}
