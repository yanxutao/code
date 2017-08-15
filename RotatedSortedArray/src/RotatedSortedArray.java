/**
 * Created by yanxutao on 7/24/17.
 */
public class RotatedSortedArray {

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }

            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
                right--;
            } else {
                left++;
                right = middle - 1;
            }
        }

        return -1;
    }

    private int findMinIndex(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            if (nums[0] < nums[1]) {
                return 0;
            } else {
                return 1;
            }
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] > nums[middle + 1]) {
                return middle + 1;
            }

            if (nums[middle - 1] > nums[middle]) {
                return middle;
            }

            if (nums[middle] < nums[right]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;

        if (n == 0) {
            return -1;
        }

        if (n == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        int left = 0;
        int right = n - 1;

        if (nums[left] < nums[right]) {
            return binarySearch(nums, left, right, target);
        } else {
            int minIndex = findMinIndex(nums);
            if (target < nums[minIndex] || target > nums[minIndex - 1]) {
                return -1;
            } else if (target <= nums[right]) {
                return binarySearch(nums, minIndex, right, target);
            } else {
                return binarySearch(nums, left, minIndex - 1, target);
            }
        }
    }

    public int search2(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        int rotate = left;

        left = 0;
        right = n - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            int realMiddle = (middle + rotate) % n;
            if (nums[realMiddle] == target) {
                return realMiddle;
            } else if (nums[realMiddle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }

}
