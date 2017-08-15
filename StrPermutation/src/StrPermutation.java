import java.util.*;

/**
 * Created by yanxutao on 7/30/17.
 */
public class StrPermutation {

    private boolean next(int[] pailie) {
        int n = pailie.length;
        int k = -1;
        for (int i = 0; i < n - 1; i++) {
            if (pailie[i] < pailie[i + 1]) {
                k = i;
            }
        }

        if (k == -1) {
            return false;
        }

        int j = k + 1;
        for (int i = k + 1; i < n; i++) {
            if (pailie[i] > pailie[k] && pailie[i] <= pailie[j]) {
                j = i;
            }
        }

        int tmp = pailie[k];
        pailie[k] = pailie[j];
        pailie[j] = tmp;

        int begin = k + 1;
        int end = n - 1;
        for (; begin < end; begin++, end--) {
            int t = pailie[begin];
            pailie[begin] = pailie[end];
            pailie[end] = t;
        }

        return true;
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();

        if (str == null || str.length() == 0) {
            return list;
        }

        int n = str.length();
        int[] pailie = new int[n];
        for (int i = 0; i < n; i++) {
            pailie[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        TreeSet<String> set = new TreeSet<>();
        do {
            for (int i = 0; i < n; i++) {
                sb.append(str.charAt(pailie[i]));
            }
            set.add(sb.toString());
            sb.setLength(0);
        } while (next(pailie) == true);

        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            list.add(it.next());
        }

        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        StrPermutation sp = new StrPermutation();
        ArrayList<String> list = sp.Permutation(str);

        for (String s : list) {
            System.out.println(s);
        }
    }

}
