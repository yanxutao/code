/**
 * Created by yanxutao on 7/24/17.
 */
public class RangeSearch {

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];

        int start = -1;
        int end = -1;

        int n = nums.length;
        int left = 0;
        int right = n - 1;

        int middle = binarySearch(nums, left, right, target);

        int index = middle;
        while (index != -1) {
            start = index;
            index = binarySearch(nums, left, index - 1, target);
        }

        index = middle;
        while (index != -1) {
            end = index;
            index = binarySearch(nums, index + 1, right, target);
        }

        result[0] = start;
        result[1] = end;
        return result;
    }

}
