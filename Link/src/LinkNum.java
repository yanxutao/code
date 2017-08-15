import java.util.*;

/**
 * Created by yanxutao on 5/3/17.
 */
public class LinkNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] r = new String[n][2];
        HashMap<String, String> map1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] f = line.split(" ");
            r[i][0] = f[0];
            r[i][1] = f[1];
            map1.put(f[0], f[1]);
        }

        HashSet<String> set = new HashSet<>();
        set.add("main");

        Queue<String> queue = new LinkedList<>();
        queue.add("main");

        while (!queue.isEmpty()) {
            String s = queue.poll();
        }


    }

}
