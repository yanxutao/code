import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanxutao on 4/12/17.
 */
public class SumMaxProduct {

    private static void method1() {
        int N = 15;

        int[][] dp = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            dp[i][i] = i;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                for (int k = 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - j][k] * j);
                }
            }
        }

        int max = dp[N][0];
        for (int j = 1; j <= N; j++) {
            max = Math.max(max, dp[N][j]);
        }

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                System.out.print(String.format("%3d ", dp[i][j]));
            }
            System.out.println();
        }

        System.out.println(max);
    }

    private static void method2() {
        int N = 15;

        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
//            for (int j = 1; j <)
            dp[i] = Math.max(i, i);
        }
    }

    private static int getMax(int n) {
        int max = 1;
        int i = 2;
        List<Integer> list = new ArrayList<>();
        while (n >= i) {
//            System.out.println("n = " + n + ", i = " + i);
            list.add(i);
            n = n - i;
            i++;
        }
//        for (Integer integer : list) {
//            System.out.print(integer + " ");
//        }
//        System.out.println();
        for (int k = list.size() - 1, j = 0; j < n; j++, k--) {
//            System.out.println("j = " + j + ", k = " + k);
            list.set(k, list.get(k) + 1);
        }
        for (Integer integer : list) {
            System.out.print(integer + " ");
            max *= integer;
        }
        System.out.println();
        return max;
    }

    public static void main(String[] args) {
//        method1();
        System.out.println("max = " + getMax(100));

        // strcpy

    }
}
