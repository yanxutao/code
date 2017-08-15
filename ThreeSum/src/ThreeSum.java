import java.util.*;

/**
 * Created by yanxutao on 5/30/17.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int lo = i + 1, hi = nums.length - 1; lo < hi; ) {
                if (nums[i] + nums[lo] + nums[hi] == 0) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo + 1]) {
                        lo++;
                    }
                    while (lo < hi && nums[hi] == nums[hi - 1]) {
                        hi--;
                    }
                    lo++;
                    hi--;
                } else if (nums[i] + nums[lo] + nums[hi] < 0) {
                    while (lo < hi && nums[lo] == nums[lo + 1]) {
                        lo++;
                    }
                    lo++;
                } else {
                    while (lo < hi && nums[hi] == nums[hi - 1]) {
                        hi--;
                    }
                    hi--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 5, 8};
        ThreeSum ts = new ThreeSum();
        ts.threeSum(nums);
    }

}
