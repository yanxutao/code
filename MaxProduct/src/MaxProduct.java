import java.util.Scanner;

/**
 * Created by yanxutao on 8/19/17.
 */
public class MaxProduct {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int d = sc.nextInt();

        long[][][] f = new long[n + 1][k + 1][2];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= k; j++) {
//                f[i][j][0] = Long.MIN_VALUE;
//                f[i][j][1] = Long.MIN_VALUE;
//            }
//        }

        long ans = Long.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            f[i][1][0] = a[i];
            f[i][1][1] = a[i];

            for (int j = 2; j <= k; j++) {
                for (int l = i - 1; l >= Math.max(i - d, 1); l--) {
                    f[i][j][0] = Math.max(f[i][j][0],
                                          Math.max(f[l][j - 1][0] * a[i],
                                                   f[l][j - 1][1] * a[i]));
                    f[i][j][1] = Math.min(f[i][j][1],
                                          Math.min(f[l][j - 1][0] * a[i],
                                                   f[l][j - 1][1] * a[i]));
                }
            }

            ans = Math.max(ans, Math.max(f[i][k][0], f[i][k][1]));
        }

        System.out.println(ans);
    }

}
