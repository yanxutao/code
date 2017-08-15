/**
 * Created by yanxutao on 7/18/17.
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int length = 1;
        int tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tmp != nums[i]) {
                tmp = nums[i];
                nums[length] = nums[i];
                length++;
            }
        }
        return length;
    }

}
