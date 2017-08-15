import java.util.Scanner;

/**
 * Created by yanxutao on 6/16/17.
 */
public class LongestCommonSubseq {

    public static int lcs(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int dp[][] = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String str1 = sc.nextLine();
//        String str2 = sc.nextLine();
//        System.out.println("lcs = " + lcs(str1, str2));
        String str = sc.nextLine();
        String reverseStr = new StringBuilder(str).reverse().toString();
        System.out.println(str.length() - lcs(str, reverseStr));
    }
}
