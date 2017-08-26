import java.util.Scanner;

/**
 * Created by yanxutao on 8/26/17.
 */
public class ZeroNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 5; i <= n; i++) {
            int j = i;
            while (j % 5 == 0) {
                count += 1;
                j /= 5;
            }
        }

        System.out.println(count);
    }

}
