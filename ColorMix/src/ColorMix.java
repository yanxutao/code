import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by yanxutao on 8/23/17.
 */
public class ColorMix {

    private static int getHighestPosition(int a) {
        int pos = 0;
        while (a > 0) {
            a = a >> 1;
            pos += 1;
        }

        return pos;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> x = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            x.addLast(sc.nextInt());
        }

        Collections.sort(x);

        int res = 0;

        while (x.size() > 2) {
            if (getHighestPosition(x.get(x.size() - 1))
                    == getHighestPosition(x.get(x.size() - 2))) {
                int tmp = x.get(x.size() - 1) ^ x.get(x.size() - 2);
                if (x.indexOf(tmp) == -1) {
                    x.addLast(tmp);
                    Collections.sort(x);
                }
            } else {
                res++;
            }

            x.removeLast();
        }

        System.out.println(res + x.size());
    }

}
