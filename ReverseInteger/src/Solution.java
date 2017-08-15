/**
 * Created by yanxutao on 2/15/17.
 */
public class Solution {

    public int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x *= -1;
        }

        long j = 0;
        while (x > 0) {
            j = j * 10 + x % 10;
            if (j > Math.pow(2, 31) - 1) {
                return 0;
            }
            x /= 10;
        }

        return sign * (int)j;
    }

}
