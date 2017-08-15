/**
 * Created by yanxutao on 2/13/17.
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int size = nums1.length + nums2.length;
        int[] num = new int[size];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                num[k] = nums1[i];
                k++;
                i++;
            } else {
                num[k] = nums2[j];
                k++;
                j++;
            }
        }

        if (i == nums1.length) {
            while (j < nums2.length) {
                num[k] = nums2[j];
                k++;
                j++;
            }
        }

        if (j == nums2.length) {
            while (i < nums1.length) {
                num[k] = nums1[i];
                k++;
                i++;
            }
        }

        if (size % 2 == 0) {
            return (num[size / 2] + num[size / 2 - 1] + 0.0) / 2;
        } else {
            return num[size / 2];
        }
    }

}
