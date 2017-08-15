import java.util.Arrays;

/**
 * Created by yanxutao on 4/30/17.
 */
public class Main {

    public static void main(String[] args) {

        int[] a = {0, 3, 3, 1, 2, 1};
        int N = a.length - 1;

        Arrays.sort(a);

        for (int i = 1; i <= N; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();

        while (true) {
            int k = 0;
            for (int i = 1; i <= N - 1; i++) {
                if (a[i] < a[i + 1]) {
                    k = i;
                }
            }
            if (k == 0) {
                break;
            }

            int min = a[k + 1];
            int j = k + 1;
            for (int i = k + 1; i <= N; i++) {
                if (a[i] > a[k] && a[i] <= min) {
                    j = i;
                    min = a[i];
                }
            }

            int tmp = a[k];
            a[k] = a[j];
            a[j] = tmp;

            int begin = k + 1;
            int end = N;
            for (; begin < end; begin++, end--) {
                int t = a[begin];
                a[begin] = a[end];
                a[end] = t;
            }

            for (int i = 1; i <= N; i++) {
                System.out.print(a[i] + " ");
            }

            System.out.println();
        }
    }
}
