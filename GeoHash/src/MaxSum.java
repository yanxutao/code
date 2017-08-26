import java.util.Scanner;

/**
 * Created by yanxutao on 8/24/17.
 */
public class MaxSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int max = a[0];
        int sum = a[0];
        for (int i = 1; i < n; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += a[i];
            if (sum > max) {
                max = sum;
            }
        }

        System.out.println(max);
    }

}
