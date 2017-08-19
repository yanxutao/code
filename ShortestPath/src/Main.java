import java.util.*;

/**
 * Created by yanxutao on 3/6/17.
 */

public class Main {

    private class IndexMinPQ<Key extends Comparable<Key>> {
        private int[] indexToLoc;
        private int[] heap;
        private Key[] keys;

        private int N;

        public IndexMinPQ(int n) {
            indexToLoc = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                indexToLoc[i] = -1;
            }

            heap = new int[n + 1];
            keys = (Key[]) new Comparable[n + 1];
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public void insert(int i, Key key) {
            N++;
            indexToLoc[i] = N;
            heap[N] = i;
            keys[i] = key;
            swim(N);
        }

        public int delMin() {
            int min = heap[1];
            exch(1, N--);
            sink(1);
            indexToLoc[min] = -1;
            keys[min] = null;
            return min;
        }

        public void decreaseKey(int i, Key key) {
            keys[i] = key;
            swim(indexToLoc[i]);
        }

        private boolean greater(int i, int j) {
            return keys[heap[i]].compareTo(keys[heap[j]]) > 0;
        }

        private void exch(int i, int j) {
            int tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
            indexToLoc[heap[i]] = i;
            indexToLoc[heap[j]] = j;
        }

        private void swim(int k) {
            while (k > 1 && greater(k / 2, k)) {
                exch(k, k / 2);
                k = k / 2;
            }
        }

        private void sink(int k) {
            while (2 * k <= N) {
                int j = 2 * k;
                if (j < N && greater(j, j + 1)) {
                    j = j + 1;
                }
                if (!greater(k, j)) {
                    break;
                }
                exch(k, j);
                k = j;
            }
        }
    }

    private void dijkstra(int[][] dist, int s, int[] path) {
        int n = dist.length;

        IndexMinPQ<Integer> queue = new IndexMinPQ<>(n);

        for (int j = 0; j < n; j++) {
            if (dist[s][j] < Integer.MAX_VALUE) {
                queue.insert(j, dist[s][j]);
                path[j] = s;
            }
        }

        while (!queue.isEmpty()) {
            int i = queue.delMin();
            for (int j = 0; j < n; j++) {
                if (dist[s][i] != Integer.MAX_VALUE && dist[i][j] != Integer.MAX_VALUE
                        && dist[s][j] > dist[s][i] + dist[i][j]) {
                    dist[s][j] = dist[s][i] + dist[i][j];
                    path[j] = i;
                    queue.decreaseKey(j, dist[s][j]);
                }
            }
        }
    }

    private void outputDist(int[][] dist) {
        System.out.println();
        int v = dist.length;
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) {
                    System.out.print("x ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int v = in.nextInt();
        int e = in.nextInt();

        int[][] dist = new int[v][v];

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < v; i++) {
            dist[i][i] = 0;
        }

        for (int i = 0; i < e; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            int d = in.nextInt();
            dist[from][to] = d;
        }

        int[] path = new int[v];
        for (int i = 0; i < v; i++) {
            path[i] = -1;
        }

        int s = 4;

        Main main = new Main();

        //main.outputDist(dist);
        main.dijkstra(dist, s, path);
        //main.outputDist(dist);

        System.out.println();

        for (int i = 0; i < v; i++) {
            System.out.print(s + " to " + i + ", path: ");

            int tmp = i;
            if (path[tmp] == -1) {
                System.out.println("no path");
                continue;
            } else {
                System.out.print(s);
            }


            Stack<Integer> stack = new Stack<>();
            while (path[tmp] != tmp) {
                stack.push(tmp);
                tmp = path[tmp];
            }

            while (!stack.isEmpty()) {
                System.out.print("->" + stack.pop());
            }

            System.out.println(", dist: " + dist[s][i]);
        }

        /*
        HashMap<String, Integer> locToIndex = new HashMap<>();
        HashMap<Integer, String> indexToLoc = new HashMap<>();


        for (int i = 0; i < n; i++) {
            String[] s = in.nextLine().split(",");
            if (locToIndex.containsKey(s[0]) == false) {
                locToIndex.put(s[0], k);
                indexToLoc.put(k, s[0]);
                k++;
            }
            if (locToIndex.containsKey(s[1]) == false) {
                locToIndex.put(s[1], k);
                indexToLoc.put(k, s[1]);
                k++;
            }
            dist[locToIndex.get(s[0])][locToIndex.get(s[1])] = Double.parseDouble(s[2]);
        }

        int src = locToIndex.get(in.nextLine().trim());

        int[][] path = new int[100][100];

        for (int pass = 0; pass < k; pass++) {
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    if (dist[i][j] > dist[i][pass] + dist[pass][j]) {
                        dist[i][j] = dist[i][pass] + dist[pass][j];
                        path[i][j] = pass;
                    }
                }
            }
        }

        Stack<Integer> stack = new Stack<>();

        int dest = locToIndex.get("XH");
        int a = dest;
        stack.push(a);
        while (a != src) {
            a = path[src][a];
            stack.push(a);
        }

        while (stack.empty() == false) {
            if (stack.peek() == dest) {
                System.out.print(indexToLoc.get(dest));
            } else {
                System.out.print(indexToLoc.get(stack.peek()) + "->");
            }

            stack.pop();
        }

        System.out.println();
        */
    }

}
