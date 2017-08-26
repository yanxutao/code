import java.util.Scanner;

/**
 * Created by yanxutao on 8/24/17.
 */
public class PrimePairs {

    private static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int min = 2; min <= n - min; min++) {
            if (isPrime(min) && isPrime(n - min)) {
                count += 1;
            }
        }

        System.out.println(count);
    }

}
