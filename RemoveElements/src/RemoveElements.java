/**
 * Created by yanxutao on 7/18/17.
 */
public class RemoveElements {

    public int removeElement(int[] nums, int val) {
        int cnt = 0;
        int loc = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                cnt++;
                if (loc > i) {
                    loc = i;
                }
            } else {
                if (loc < i) {
                    nums[loc] = nums[i];
                    loc++;
                }
            }
        }
        return nums.length - cnt;
    }

}
