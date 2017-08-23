import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by yanxutao on 8/23/17.
 */
public class ArrayConstruction {

    private static void calcPerm(ArrayList<ArrayList<Integer>> perm,
                                 ArrayList<Integer> list, int index) {
        if (index == list.size()) {
            perm.add(new ArrayList<>(list));
        } else {
            for (int i = index; i < list.size(); i++) {
                Collections.swap(list, i, index);
                calcPerm(perm, list, index + 1);
                Collections.swap(list, index, i);
            }
        }
    }

    private static int calcValue(ArrayList<Integer> miss, int[] a) {
        int n = a.length;
        int val = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                a[i] = miss.get(j++);
                for (int k = 0; k < i; k++) {
                    if (a[k] != 0 && a[k] < a[i]) {
                        val += 1;
                    }
                }
                for (int k = i + 1; k < n; k++) {
                    if (a[k] != 0 && a[i] < a[k]) {
                        val += 1;
                    }
                }
            }
        }

        return val;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        boolean[] flag = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] != 0) {
                flag[a[i]] = true;
            }
        }

        ArrayList<Integer> miss = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (flag[i] == false) {
                miss.add(i);
            }
        }

        ArrayList<ArrayList<Integer>> perm = new ArrayList<>();

        calcPerm(perm, miss, 0);

        int originalSum = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != 0) {
                for (int j = i + 1; j < n; j++) {
                    if (a[j] != 0 && a[i] < a[j]) {
                        originalSum += 1;
                    }
                }
            }
        }

        int res = 0;
        for (ArrayList<Integer> tmp : perm) {
            int sum = originalSum;
            int[] tmpA = Arrays.copyOf(a, n);
            sum += calcValue(tmp, tmpA);
            if (sum == k) {
                res += 1;
            }
        }

        System.out.println(res);
    }

}
