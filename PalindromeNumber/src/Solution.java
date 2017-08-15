/**
 * Created by yanxutao on 2/15/17.
 */
public class Solution {

    public boolean isPalindrome(int x) {

//        if (x < 0 || (x % 10 == 0 && x != 0)) {
//            return false;
//        }
//
//        int j = 0;
//        while (x > j) {
//            j = j * 10 + x % 10;
//            x = x / 10;
//        }
//
//        return (x == j || x == j / 10);

        if (x < 0) {
            return false;
        }

        if (x == 0) {
            return true;
        }

        int[] s = new int[10];
        int i = 0;
        while (x > 0) {
            s[i] = x % 10;
            x /= 10;
            i++;
        }

        i--;
        for (int j = 0; j < i; j++, i--) {
            if (s[i] != s[j]) {
                return false;
            }
        }

        return true;
    }

}
