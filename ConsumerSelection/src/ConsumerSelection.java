import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by yanxutao on 8/24/17.
 */
public class ConsumerSelection {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        PriorityQueue<Customer> queue = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            int count = sc.nextInt();
            int money = sc.nextInt();
            if (count <= a[n - 1]) {
                queue.add(new Customer(count, money));
            }
        }

        boolean[] visited = new boolean[n];

        long sum = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            if (count == n) {
                break;
            }

            Customer customer = queue.poll();
            for (int i = 0; i < n; i++) {
                if (customer.count <= a[i] && visited[i] == false) {
                    sum += customer.money;
                    visited[i] = true;
                    count++;
                    break;
                }
            }
        }

        System.out.println(sum);
    }

    static class Customer implements Comparable<Customer> {
        private int count;
        private int money;

        public Customer(int count, int money) {
            this.count = count;
            this.money = money;
        }

        public int compareTo(Customer o) {
            if (o.money > this.money) {
                return 1;
            } else if (o.money < this.money) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}
