import java.util.ArrayList;

/**
 * Created by yanxutao on 8/2/17.
 */
public class MinK {

    private int[] heap;
    private int maxSize;
    private int size;

    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    private void swim() {
        int pos = size - 1;
        while (pos > 0) {
            int parent = (pos - 1) / 2;
            if (heap[pos] > heap[parent]) {
                swap(pos, parent);
                pos = parent;
            } else {
                break;
            }
        }
    }

    private void sink() {
        int pos = 0;
        while (pos < size) {
            int left = 2 * pos + 1;
            int right = 2 * pos + 2;
            if (left < size && heap[pos] < heap[left]) {
                swap(pos, left);
                pos = left;
            } else if (right < size && heap[pos] < heap[right]) {
                swap(pos, right);
                pos = right;
            } else {
                break;
            }
        }
    }

    private void insert(int num) {
        if (size == maxSize) {
            if (num < heap[0]) {
                heap[0] = num;
                sink();
            }
        } else {
            heap[size] = num;
            size++;
            swim();
        }
    }

    private int delMax() {
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        sink();
        return max;
    }

    public ArrayList<Integer> GetLeastNumbers(int [] input, int k) {
        maxSize = k;
        heap = new int[maxSize];
        size = 0;

        for (int i = 0; i < input.length; i++) {
            insert(input[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(delMax());
        }

        ArrayList<Integer> reverseList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            reverseList.add(list.get(list.size() - 1 - i));
        }

        return reverseList;
    }

    public static void main(String[] args) {
        MinK mk = new MinK();
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8, 1};
        ArrayList<Integer> list = mk.GetLeastNumbers(input, 5);
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
