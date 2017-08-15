/**
 * Created by yanxutao on 8/3/17.
 */
public class Continuous {

    public boolean isContinuous(int [] numbers) {
        int n = numbers.length;

        int min = numbers[0];
        for (int i = 0; i < n; i++) {
            if (numbers[i] > 0) {
                min = numbers[i];
                break;
            }
        }

        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            if (numbers[i] == 0) {
                zeroCount++;
            } else if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        int[] a = new int[n];
        a[0] = min;
        for (int i = 0; i < n; i++) {
            int index = numbers[i] - min;
            if (index < 0) {
                continue;
            } else if (index >= 0 && index < n) {
                a[index] = numbers[i];
            } else {
                return false;
            }
        }

        for (int i = 1; i < n; i++) {
            if (a[i] - a[i - 1] != 1) {
                if (zeroCount > 0) {
                    zeroCount--;
                    a[i] = a[i - 1] + 1;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] a = {0, 3, 2, 6, 4};
        Continuous continuous = new Continuous();
        System.out.println(continuous.isContinuous(a));
    }

}
