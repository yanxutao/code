/**
 * Created by yanxutao on 3/4/17.
 */
public class FourSubArray {

    public static void main(String[] args) {
//        int[] arr = {100, 2, 3, 4, 100, 2, 3, 4, 100, 2, 3, 4, 100, 2, 3};
//        int[] arr = {100, 2, 3, 9, 3, 3, 3, 2, 4, 2, 5, 1, -1, 1};
        int[] arr = {1, 2, 4, 4, -1, 7, -3, 6, 2, 1, 2};
        if (isPossible(arr)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static boolean isPossible (int[] arr) {

        int head = 0;
        int tail = arr.length - 1;

        int s1 = 0, s2 = 0, s = 0;

        int a1 = 0, a2 = 0;

        int stage = 1;

        for (; head < tail;) {
            s1 += arr[head];
            s2 += arr[tail];

            if (stage == 2 && ((s1 > s) || (s2 > s))) {
                head = a1;
                tail = a2;
                s1 = s;
                s2 = s;
                stage = 1;
                continue;
            }

            while (s1 != s2 && head < tail) {
                if (s1 < s2) {
                    head++;
                    s1 += arr[head];
                } else if (s1 > s2) {
                    tail--;
                    s2 += arr[tail];
                }
            }

            if (s1 == s2 && head < tail) {
                if (stage == 1) {
                    a1 = head + 1;
                    a2 = tail - 1;
                    head += 2;
                    tail -= 2;
                    s = s1;
                    s1 = 0;
                    s2 = 0;
                    stage = 2;
                    continue;
                } else if (stage == 2) {
                    if (s1 < s) {
                        head++;
                        tail--;
                        continue;
                    } else if (s1 > s) {
                        head = a1;
                        tail = a2;
                        s1 = s;
                        s2 = s;
                        stage = 1;
                        continue;
                    } else if (head + 1 == tail - 1) {
                        return true;
                    } else {
                        head = a1;
                        tail = a2;
                        s1 = s;
                        s2 = s;
                        stage = 1;
                        continue;
                    }
                }
            }

        }

        return false;
    }
}
