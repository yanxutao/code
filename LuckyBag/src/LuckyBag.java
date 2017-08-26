import java.util.Scanner;

/**
 * Created by yanxutao on 8/23/17.
 */
public class LuckyBag {

    private static boolean isLucky() {
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }

    }

}
