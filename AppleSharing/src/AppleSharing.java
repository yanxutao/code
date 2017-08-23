import java.util.Scanner;

/**
 * Created by yanxutao on 8/22/17.
 */
public class AppleSharing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }

        if (sum % n != 0) {
            System.out.println(-1);
            return;
        }

        int m = sum / n;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (Math.abs(a[i] - m) % 2 != 0) {
                System.out.println(-1);
                return;
            } else {
                count += (Math.abs(a[i] - m) / 2);
            }
        }

        System.out.println(count / 2);
    }

}
