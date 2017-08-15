import java.util.Scanner;

/**
 * Created by yanxutao on 8/8/17.
 */
public class Numeric {

    private boolean isDigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNumeric(char[] str) {
        int n = str.length;
        int i = 0;
        int state = 0;
        char c;

        while (i < n) {
            c = str[i];
            switch (state) {
                case -1:
                    return false;
                case 0:
                    if (c == '+' || c == '-') {
                        state = 1;
                        i++;
                    } else if (isDigit(c)) {
                        state = 1;
                    } else {
                        state = -1;
                    }
                    break;
                case 1:
                    if (isDigit(c)) {
                        state = 2;
                        i++;
                    } else {
                        state = -1;
                    }
                    break;
                case 2:
                    if (isDigit(c)) {
                        state = 2;
                        i++;
                    } else if (c == '.') {
                        state = 3;
                        i++;
                    } else if (c == 'e' || c == 'E') {
                        state = 4;
                        i++;
                    } else {
                        state = -1;
                    }
                    break;
                case 3:
                    if (isDigit(c)) {
                        state = 5;
                        i++;
                    } else {
                        state = -1;
                    }
                    break;
                case 4:
                    if (isDigit(c)) {
                        state = 6;
                    } else if (c == '+' || c == '-') {
                        state = 6;
                        i++;
                    } else {
                        state = -1;
                    }
                    break;
                case 5:
                    if (isDigit(c)) {
                        state = 5;
                        i++;
                    } else if (c == 'e' || c == 'E') {
                        state = 4;
                        i++;
                    } else {
                        state = -1;
                    }
                    break;
                case 6:
                case 7:
                    if (isDigit(c)) {
                        state = 7;
                        i++;
                    } else {
                        state = -1;
                    }
                    break;
            }
        }

        if (i == n && (state == 2 || state == 5 || state == 7)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Numeric numeric = new Numeric();
        while (true) {
            String str = sc.nextLine();
            System.out.println(numeric.isNumeric(str.toCharArray()));
        }
    }

}
