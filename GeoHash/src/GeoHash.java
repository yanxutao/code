import java.util.Scanner;

/**
 * Created by yanxutao on 8/24/17.
 */
public class GeoHash {

    private static String geoHash(int n) {
        StringBuilder sb = new StringBuilder();

        int left = -90;
        int right = 90;
        for (int i = 0; i < 6; i++) {
            //int mid = (int) Math.floor((max + min) / 2);
            int mid = (right + left) / 2;
            //int mid = left + (right - left) / 2;
            System.out.println("left = " + left + ", right = " + right + ", mid = " + mid);
            if (n >= mid) {
                left = mid;
                sb.append('1');
            } else {
                right = mid;
                sb.append('0');
            }
        }

        return sb.toString();
    }

    private static void test() {
        int left = 1;
        int right = 4;
        System.out.println((left + right) / 2);
        System.out.println(Math.floor((left + right) / 2));
        System.out.println(left + (right - left) / 2);
        System.out.println(Math.floor(left + (right - left) / 2));
        left = -1;
        right = -4;
        System.out.println((left + right) / 2);
        System.out.println(Math.floor((left + right) / 2));
        System.out.println(left + (right - left) / 2);
        System.out.println(Math.floor(left + (right - left) / 2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(geoHash(n));
//        test();
    }

}
