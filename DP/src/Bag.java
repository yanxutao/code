import java.util.Scanner;

/**
 * Created by yanxutao on 4/23/17.
 */
public class Bag {

    private int N;
    private int W;

    private int[] weight;
    private int[] value;

    private void Input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        W = sc.nextInt();

        weight = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            weight[i] = sc.nextInt();
        }

        value = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            value[i] = sc.nextInt();
        }
    }

    private void bag1() {
        int[] K = new int[W + 1];
        K[0] = 0;

        for (int w = 1; w <= W; w++) {
            for (int i = 1; i <= N; i++) {
                if (weight[i] <= w && K[w] < K[w - weight[i]] + value[i]) {
                    K[w] = K[w - weight[i]] + value[i];
                }
            }
        }

        System.out.println(K[W]);
    }

    private void bag2() {
        int[][] K = new int[W + 1][N + 1];

        for (int j = 1; j <= N; j++) {
            K[0][j] = 0;
        }

        for (int i = 1; i <= W; i++) {
            K[i][0] = 0;
        }

        for (int w = 1; w <= W; w++) {
            for (int j = 1; j <= N; j++) {
                if (weight[j] > w) {
                    K[w][j] = K[w][j - 1];
                } else {
                    K[w][j] = Math.max(K[w][j - 1],
                                       K[w - weight[j]][j - 1] + value[j]);
                }
            }
        }

        System.out.println(K[W][N]);
    }

    public static void main(String[] args) {
        Bag bag = new Bag();
        bag.Input();
        bag.bag1();
        bag.bag2();
    }

}
