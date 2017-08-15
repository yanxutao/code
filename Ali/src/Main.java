import java.util.Scanner;

public class Main {

    private static int N;
    private static int[] num;
    private static boolean[] flag;

    private static int f(int n) {

        if (flag[n] == true) {
            return num[n];
        }

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                num[n] = f(i) + f(n / i);
                flag[n] = true;
                return num[n];
            }
        }

        num[n] = 1;
        flag[n] = true;
        return num[n];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        num = new int[N + 1];
        flag = new boolean[N + 1];

        int sum = 0;
        for (int i = 2; i <= N; i++) {
            sum += f(i);
        }

        System.out.println(sum);
    }

}
