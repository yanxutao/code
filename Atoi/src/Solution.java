/**
 * Created by yanxutao on 2/15/17.
 */
public class Solution {

    public int myAtoi(String str) {

        int i = 0;
        while (i++ < str.length() && str.charAt(i) == ' ');
        if (i >= str.length()) {
            return 0;
        }

        int sign = 1;
        if (str.charAt(i) == '+') {
            sign = 1;
            i++;
        } else if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        long j = 0;
        long maxInt = 2147483647;

        while (i++ < str.length()) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                j = j * 10 + c - '0';
                if (sign == -1 && j > maxInt + 1) {
                    return (int)(-1 * (maxInt + 1));
                } else if (sign == 1 && j > maxInt) {
                    return (int)maxInt;
                }
            } else {
                break;
            }
        }

        return sign * (int) j;
    }

}
