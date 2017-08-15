/**
 * Created by yanxutao on 7/25/17.
 */
public class InsertPosition {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

}
