import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by yanxutao on 8/25/17.
 * I made a lot of mistake in Alibaba written exam
 * It's over...
 */

public class PasswordCheck {

    static int PasswordCheck(String password) {
        int n = password.length();
        if (n == 0) {
            return 8;
        }

        ArrayList<Integer> counts = new ArrayList<>();

        int count = 1;
        char cur = password.charAt(0);

        for (int i = 1; i < Math.min(n, 20); i++) {
            char c = password.charAt(i);
            if (c == cur) {
                count += 1;
            } else {
                if (count >= 3) {
                    counts.add(count);
                }
                count = 1;
                cur = c;
            }
        }

        if (count >= 3) {
            counts.add(count);
        }

        for (int i = 0; i < counts.size(); i++) {
            counts.set(i, counts.get(i) / 3);
        }

        int miss = 3;

        boolean A = false;
        boolean a = false;
        boolean d = false;

        for (int i = 0; i < n; i++) {
            char c = password.charAt(i);

            if (A == false && c >= 'A' && c <= 'Z') {
                A = true;
                miss -= 1;
            } else if (a == false && c >= 'a' && c <= 'z') {
                a = true;
                miss -= 1;
            } else if (d == false && c >= '0' && c <= '9') {
                d = true;
                miss -= 1;
            }
        }

        int res = 0;

        while (n < 8) {
            res++;
            n++;

            if (miss > 0) {
                miss--;
            }

            if (counts.size() > 0) {
                counts.set(0, counts.get(0) - 1);
                if (counts.get(0) == 0) {
                    counts.remove(0);
                }
            }
        }

        while (miss > 0) {
            res++;
            miss--;

            if (counts.size() > 0) {
                counts.set(0, counts.get(0) - 1);
                if (counts.get(0) == 0) {
                    counts.remove(0);
                }
            }
        }

        while (counts.size() > 0) {
            res++;
            counts.set(0, counts.get(0) - 1);
            if (counts.get(0) == 0) {
                counts.remove(0);
            }
        }

        if (n > 20) {
            res += (n - 20);
        }

        return res;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _password;
        try {
            _password = in.nextLine();
        } catch (Exception e) {
            _password = null;
        }

        res = PasswordCheck(_password);
        System.out.println(String.valueOf(res));

    }
}
