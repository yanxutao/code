import java.util.Scanner;

/**
 * Created by yanxutao on 6/16/17.
 */
public class Main {

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int k = in.nextInt();
//
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int n = in.nextInt();
//        int[] h = new int[n];
//        for (int i = 0; i < n; i++) {
//            h[i] = in.nextInt();
//        }
//
//        Arrays.sort(h);
//        int[] hr = new int[n];
//        for (int i = 0; i < n; i++) {
//            hr[i] = h[n - 1 - i];
//        }
//
//        int max = Math.max(hr[0] - hr[1], hr[0] - hr[2]);
//
//        for (int i = 3; i < n; i++) {
//            max = Math.max(max, hr[i - 2] - hr[i]);
//        }
//
//        max = Math.max(max, hr[n - 2] - hr[n - 1]);
//
//        System.out.println(max);
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int bushu = 1;
        int jiedianshu = 1 << bushu;
        int red = 4;

        for (bushu = 2; bushu <= n; bushu++) {
            red = (red * 2) + jiedianshu;
            jiedianshu = 1 << bushu;
        }

        System.out.println(red / (1 << n));
    }

}
