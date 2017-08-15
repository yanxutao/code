import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by yanxutao on 3/6/17.
 */
public class Main {

    public static void main(String[] args) {

        HashMap<String, Integer> locToIndex = new HashMap<>();
        HashMap<Integer, String> indexToLoc = new HashMap<>();

        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine().trim());

        int k = 0;

        double dist[][] = new double[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                dist[i][j] = 10000;
            }
        }

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
    }

}
