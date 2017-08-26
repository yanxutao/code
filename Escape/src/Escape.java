import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by yanxutao on 8/26/17.
 */
public class Escape {

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int n;
    private static int m;
    private static int[][] map;
    private static boolean[][] visited;

    private static int search(int i, int j, int p, ArrayList<Point> points) {
        points.add(new Point(i, j));

        if (i == 0 && j == m - 1) {
            return p;
        }

        visited[i][j] = true;

        ArrayList<Point> tmp = new ArrayList<>();

        int max = -1;

        if (i > 0 && map[i - 1][j] == 1 && visited[i - 1][j] == false && p >= 3) {
            ArrayList<Point> t = new ArrayList<>();
            int res = search(i - 1, j, p - 3, t);
            if (res > max) {
                tmp = t;
                max = res;
            }
        }

        if (i < n - 1 && map[i + 1][j] == 1 && visited[i + 1][j] == false) {
            ArrayList<Point> t = new ArrayList<>();
            int res = search(i + 1, j, p, t);
            if (res > max) {
                tmp = t;
                max = res;
            }
        }

        if (j < m - 1 && map[i][j + 1] == 1 && visited[i][j + 1] == false && p >= 1) {
            ArrayList<Point> t = new ArrayList<>();
            int res = search(i, j + 1, p - 1, t);
            if (res > max) {
                tmp = t;
                max = res;
            }
        }

        if (j > 0 && map[i][j - 1] == 1 && visited[i][j - 1] == false && p >= 1) {
            ArrayList<Point> t = new ArrayList<>();
            int res =  search(i, j - 1, p - 1, t);
            if (res > max) {
                tmp = t;
                max = res;
            }
        }

        if (max != -1) {
            for (Point point : tmp) {
                points.add(point);
            }
        } else {
            points.remove(points.size() - 1);
        }

        visited[i][j] = false;

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int p = sc.nextInt();

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[n][m];

        ArrayList<Point> points = new ArrayList<>();

        if (search(0, 0, p, points) == -1) {
            System.out.println("Can not escape!");
        } else {
            System.out.print("[0,0]");
            for (int i = 1; i < points.size(); i++) {
                System.out.print(",[" + points.get(i).x + ","
                        + points.get(i).y + "]");
            }
            System.out.println();
        }
    }

}
