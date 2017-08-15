import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by yanxutao on 8/8/17.
 */
public class UglyNumber {

    private HashSet<Integer> set = new HashSet<>();
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int[] factors = {2, 3, 5};

    private int maxIndex = 1;

    {
        set.add(1);
        map.put(1, 1);
    }

    private boolean isUglyNumber(int num) {
        for (int i = 0; i < factors.length; i++) {
            int factor = factors[i];
            while (num % factor == 0) {
                num = num / factor;
                if (set.contains(num)) {
                    return true;
                }
            }
        }

        return false;
    }

    public int GetUglyNumber_Solution(int index) {
        if (index <= maxIndex) {
            return map.get(index);
        }

        int num = map.get(maxIndex);

        for (int i = maxIndex + 1; i <= index; i++) {
            num++;

            while (isUglyNumber(num) == false) {
                num++;
            }

            set.add(num);
            map.put(i, num);
        }

        return num;
    }

    public int GetUglyNumber_Solution1(int index) {
        int[] ans = new int[index];
        ans[0] = 1;

        int n2 = 0, n3 = 0, n5 = 0;

        for (int i = 1; i < index; i++) {
            ans[i] = Math.min(ans[n2] * 2, Math.min(ans[n3] * 3, ans[n5] * 5));
            if (ans[i] == ans[n2] * 2) {
                n2++;
            }
            if (ans[i] == ans[n3] * 3) {
                n3++;
            }
            if (ans[i] == ans[n5] * 5) {
                n5++;
            }
        }

        return ans[index - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        UglyNumber un = new UglyNumber();
        System.out.println(un.GetUglyNumber_Solution(n));

        /*
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + ": " + un.isUglyNumber(i));
        }
        System.out.println("done!");
        */
    }

}
