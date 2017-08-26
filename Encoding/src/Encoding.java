import java.util.Scanner;

/**
 * Created by yanxutao on 8/24/17.
 */
public class Encoding {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.next().toCharArray();
        int n = s.length;

        int sum = 0;
        int curSum = 0;
        for (int i = 0; i < 4; i++) {
            curSum *= 25;
            if (i < n) {
                curSum += s[i] - 'a';
            }

            sum += curSum;

            if (i < n - 1) {
                sum += 1;
            }
        }

        System.out.println(sum);
    }

}
