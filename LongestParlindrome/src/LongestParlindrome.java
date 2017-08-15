import java.util.Scanner;

/**
 * Created by yanxutao on 7/22/17.
 */
public class LongestParlindrome {

    private String longestCommonSubstring (String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 0; i < l1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < l2; j++) {
            dp[0][j] = 0;
        }

        int max = 0;
        int mi = 0;
        int mj = 0;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        mi = i;
                        mj = j;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return s1.substring(mi - max, mi);
    }

    public String longestPalindrome(String s) {
        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            String s1 = extend(s, i, i);
            String s2 = extend(s, i, i + 1);
            if (s1.length() > longest.length()) {
                longest = s1;
            }
            if (s2.length() > longest.length()) {
                longest = s2;
            }
        }

        return longest;
    }

    private String extend(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        return s.substring(i + 1, j);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        LongestParlindrome lp = new LongestParlindrome();
        String subString = lp.longestPalindrome(s);
        System.out.println(subString);
    }
}
