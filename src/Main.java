import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        char[] chars = {'1', '2', '3', '4', '5', '6'};

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'L') {
                L(chars);
            }
            if (str.charAt(i) == 'R') {
                R(chars);
            }
            if (str.charAt(i) == 'F') {
                F(chars);
            }
            if (str.charAt(i) == 'B') {
                B(chars);
            }
            if (str.charAt(i) == 'A') {
                A(chars);
            }
            if (str.charAt(i) == 'C') {
                C(chars);
            }
        }

        System.out.println(chars);
    }

    static void L(char[] chars) {
        char zuo = chars[0];
        char you = chars[1];
        char shang = chars[4];
        char xia = chars[5];

        chars[0] = shang;
        chars[1] = xia;
        chars[4] = you;
        chars[5] = zuo;
    }

    static void R(char[] chars) {
        char zuo = chars[0];
        char you = chars[1];
        char shang = chars[4];
        char xia = chars[5];

        chars[0] = xia;
        chars[1] = shang;
        chars[4] = zuo;
        chars[5] = you;
    }

    static void F(char[] chars) {
        char qian = chars[2];
        char hou = chars[3];
        char shang = chars[4];
        char xia = chars[5];

        chars[2] = shang;
        chars[3] = xia;
        chars[4] = hou;
        chars[5] = qian;
    }

    static void B(char[] chars) {
        char qian = chars[2];
        char hou = chars[3];
        char shang = chars[4];
        char xia = chars[5];

        chars[2] = xia;
        chars[3] = shang;
        chars[4] = qian;
        chars[5] = hou;
    }

    static void A(char[] chars) {
        char zuo = chars[0];
        char you = chars[1];
        char qian = chars[2];
        char hou = chars[3];

        chars[0] = hou;
        chars[1] = qian;
        chars[2] = zuo;
        chars[3] = you;
    }

    static void C(char[] chars) {
        char zuo = chars[0];
        char you = chars[1];
        char qian = chars[2];
        char hou = chars[3];

        chars[0] = qian;
        chars[1] = hou;
        chars[2] = you;
        chars[3] = zuo;
    }
}
