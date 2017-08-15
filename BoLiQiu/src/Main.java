import java.util.Scanner;

/**
 * Created by yanxutao on 3/25/17.
 */
public class Main {
    private static int[] tmp = new int[101];
    private static int shuru = 0;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        shuru = in.nextInt();

        tmp[1] = 1;
        tmp[2] = 2;

//        System.out.println(n);
        System.out.println(f(shuru));
//
//        for (int i = 1; i < 40; i++) {
//            System.out.println(i + "： " + tmp[i]);
//        }

    }

    static int f(int n) {
        if (tmp[n] != 0) {
            return tmp[n];
        }

        int min = n;
        for (int x = 1; x <= n; x++) {
            int max = Math.max(x, 1 + f(n - x));
            if (max < min) {
                min = max;
            }
            if (n == shuru) {
                System.out.println(x + ": " + min);
            }
        }
        tmp[n] = min;
        return min;
    }
}