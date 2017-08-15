/**
 * Created by yanxutao on 8/8/17.
 */
public class InversePairsCount {

    private int count;
    private int[] a;

    public int InversePairs(int [] array) {
        count = 0;

        int n = array.length;
        a = new int[n];

        mergeSort(array, 0, n - 1);

        return count;
    }

    private void mergeSort(int[] array, int begin, int end) {
        if (begin == end) {
            return;
        }

        int middle = begin + (end - begin) / 2;
        mergeSort(array, begin, middle);
        mergeSort(array, middle + 1, end);

        merge(array, begin, middle, end);
    }

    private void merge(int[] array, int begin, int middle, int end) {
        int i = begin;
        int j = middle + 1;
        int k = begin;

        while (i <= middle && j <= end) {
            if (array[i] > array[j]) {
                count += (middle - i + 1);
                count %= 1000000007;
                a[k++] = array[j++];
            } else {
                a[k++] = array[i++];
            }
        }

        if (i <= middle) {
            while (i <= middle) {
                a[k++] = array[i++];
            }
        }
        if (j <= end) {
            while (j <= end) {
                a[k++] = array[j++];
            }
        }

        for (int l = begin; l <= end; l++) {
            array[l] = a[l];
        }
    }

    public static void main(String[] args) {
        int[] array = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        InversePairsCount ipc = new InversePairsCount();
        System.out.println(ipc.InversePairs(array));
    }

}
