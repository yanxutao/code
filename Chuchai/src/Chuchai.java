import java.util.Scanner;

public class Chuchai {

    public static void main(String[] args) {

        int src = 5;

        Scanner in = new Scanner(System.in);

        int dest = in.nextInt();
        int fog = in.nextInt();

        if (src == fog || dest == fog) {
            System.out.println(1000);
            System.out.println("[]");
            return;
        }

        if (src == dest) {
            System.out.println(0);
            System.out.println("[" + src + "]");
            return;
        }

        int dist[][] = {
                {1000, 1000, 1000, 1000, 1000, 1000, 1000},
                {1000,    0,    2,   10,    5,    3, 1000},
                {1000, 1000,    0,   12, 1000, 1000, 10},
                {1000, 1000, 1000,    0, 1000,    7, 1000},
                {1000,    2, 1000, 1000,    0,    2, 1000},
                {1000,    4, 1000, 1000,    1,    0, 1000},
                {1000,    3, 1000,    1, 1000,    2,    0}
        };

        if (fog != 0) {
            for (int i = 1; i < 7; i++) {
                for (int j = 1; j < 7; j++) {
                    if (i == fog || j == fog) {
                        dist[i][j] = 1000;
                    }
                }
            }
        }

//        for (int i = 1; i < 7; i++) {
//            for (int j = 1; j < 7; j++) {
//                System.out.print(dist[i][j] + " ");
//            }
//            System.out.println();
//        }

        int[][] path = new int[7][7];

        for(int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                if (dist[i][j] < 1000) {
                    path[i][j] = j;
                }
            }
        }

        for (int k = 1; k < 7; k++) {
            for (int i = 1; i < 7; i++) {
                for (int j = 1; j < 7; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = path[i][k];
                    }
                }
            }
        }

//        System.out.println();
//        for (int i = 1; i < 7; i++) {
//            for (int j = 1; j < 7; j++) {
//                System.out.print(path[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        System.out.println(dist[src][dest]);

        System.out.print("[");
        System.out.print(src);
        while (path[src][dest] != dest) {
            src = path[src][dest];
            System.out.print(", " + src);
        }
        System.out.print(", " + dest);
        System.out.println("]");
    }

}
