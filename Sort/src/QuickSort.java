/**
 * Created by yanxutao on 4/11/17.
 */
public class QuickSort {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }

        int j = partition(a, left, right);

        sort(a, left, j - 1);
        sort(a, j + 1, right);
    }

    private static int partition(int[] a, int left, int right) {
        int i = left;
        int j = right + 1;
        int v = a[left];

        while (true) {
            while (a[++i] < v) {
                if (i == right) {
                    break;
                }
            }
            while (a[--j] > v) {
                if (j == left) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(a, i, j);
        }

        exchange(a, left, j);
        return j;
    }

    private static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {8, 2, 6, 9, 1};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
