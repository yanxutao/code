/**
 * Created by yanxutao on 7/4/17.
 */
public class LongestValidParenthes {

    public int longestValidParentheses(String s) {
        int max = 0;
        int open = 0;

        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                if (open > 0) {
                    dp[i] = dp[i - 1] + 2;
                    if (i - dp[i] > 0) {
                        dp[i] += dp[i - dp[i]];
                    }

                    if (dp[i] > max) {
                        max = dp[i];
                    }

                    open--;
                }
            }
        }

        return max;
    }

}
