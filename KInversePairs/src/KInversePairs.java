/**
 * Created by yanxutao on 7/4/17.
 */
public class KInversePairs {

    public int kInversePairs(int n, int k) {
        int max = n * (n - 1) / 2;

        if (k > max) {
            return 0;
        }

        if (k == 0 || k == max) {
            return 1;
        }

        int mod = 1000000007;

        long[][] dp = new long[n + 1][k + 1];

        dp[1][0] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(k, i * (i - 1) / 2); j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                if (j >= i) {
                    dp[i][j] -= dp[i - 1][j - i];
                }
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }

        return (int) dp[n][k];
    }

    public static void main(String[] args) {
        KInversePairs kip = new KInversePairs();
        System.out.println(kip.kInversePairs(10, 5));
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j <= 5; j++) {
                int ret = kip.kInversePairs(i, j);
                System.out.print(ret + " ");
            }
            System.out.println();
        }
    }

}
