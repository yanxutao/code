import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by yanxutao on 8/19/17.
 */
public class BFS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();
        xQueue.add(sc.nextInt());
        yQueue.add(sc.nextInt());

        int k = sc.nextInt();

        int[][] move = new int[k][2];
        for (int i = 0; i < k; i++) {
            move[i][0] = sc.nextInt();
            move[i][1] = sc.nextInt();
        }

        int[][] nums = new int[n][m];
        nums[xQueue.peek()][yQueue.peek()] = 0;
        map[xQueue.peek()][yQueue.peek()] = 'X';

        while (!xQueue.isEmpty()) {
            int x = xQueue.remove();
            int y = yQueue.remove();
            for (int i = 0; i < k; i++) {
                int nx = x + move[i][0];
                int ny = y + move[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (map[nx][ny] == '.') {
                    xQueue.add(nx);
                    yQueue.add(ny);
                    nums[nx][ny] = nums[x][y] + 1;
                    map[nx][ny] = 'X';
                }
            }
        }

        boolean flag = true;
        int max = 0;
        for (int i = 0; i < n && flag == true; i++) {
            for (int j = 0; j < m && flag == true; j++) {
                if (map[i][j] == '.') {
                    flag = false;
                }
                if (nums[i][j] > max) {
                    max = nums[i][j];
                }
            }
        }

        if (flag == false) {
            System.out.println(-1);
        } else {
            System.out.println(max);
        }
    }

}
