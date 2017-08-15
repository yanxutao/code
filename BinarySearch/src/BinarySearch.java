/**
 * Created by yanxutao on 3/25/17.
 */
public class BinarySearch {

    public static void main(String[] args) {

    }

    public int findIndexFor(int key, int[] array) {

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (key < array[middle]) {
                right = middle - 1;
            } else if (key > array[middle]) {
                left = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
