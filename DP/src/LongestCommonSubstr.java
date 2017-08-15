/**
 * Created by yanxutao on 6/16/17.
 */
public class LongestCommonSubstr {

    public static int lcs(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int result = 0;

        int dp[][] = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return result;
    }
}
