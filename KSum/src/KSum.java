import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yanxutao on 7/11/17.
 */
public class KSum {

    private List<List<Integer>> kSum(int[] nums, int target, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < k || k < 2) {
            return result;
        }
        Arrays.sort(nums);
        kSum(nums, target, k, 0, result, new ArrayList<Integer>());
        return result;
    }

    private void kSum(int[] nums, int target, int k, int start,
                      List<List<Integer>> result, List<Integer> path) {
        int max = nums[nums.length - 1];
        if (nums[start] * k > target || max * k < target) {
            return;
        }

        if (k == 2) {
            int left = start;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    result.add(new ArrayList<>(path));
                    result.get(result.size() - 1).addAll(
                            Arrays.asList(nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        } else {
            for (int i = start; i <= nums.length - k; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (nums[i] + max * (k - 1) < target) {
                    continue;
                }
                if (nums[i] * k > target) {
                    break;
                }
                if (nums[i] * k == target) {
                    if (nums[i + k - 1] == nums[i]) {
                        result.add(new ArrayList<>(path));
                        List<Integer> temp = new ArrayList<>();
                        for (int x = 0; x < k; x++) {
                            temp.add(nums[i]);
                        }
                        result.get(result.size() - 1).addAll(temp);
                    }
                    break;
                }
                path.add(nums[i]);
                kSum(nums, target - nums[i], k - 1, i + 1, result, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        return kSum(nums, target, 4);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        KSum ksum = new KSum();
        List<List<Integer>> result = ksum.fourSum(nums, target);
        for (int i = 0; i < result.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.print("]\n");
        }
    }

}
