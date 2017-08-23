/**
 * Created by yanxutao on 8/20/17.
 */
public class Candy {

    public int candy(int[] ratings) {
        int n = ratings.length;

        if (n == 0 || n == 1) {
            return n;
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                dp[i] = dp[i + 1] + 1;
            }
        }

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1] && dp[i] <= dp[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        int sum = dp[0];
        for (int i = 1; i < n; i++) {
            sum += dp[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 3, 4, 3, 2, 1};
        Candy candy = new Candy();
        System.out.println(candy.candy(ratings));
    }

}
