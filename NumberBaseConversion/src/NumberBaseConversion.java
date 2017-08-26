import java.util.Scanner;

/**
 * Created by yanxutao on 8/26/17.
 */
public class NumberBaseConversion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        char[] a = {'0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        String flag = "";
        if (m < 0) {
            flag += '-';
            m *= (-1);
        }

        StringBuilder sb = new StringBuilder();
        while (m > 0) {
            sb.append(a[m % n]);
            m /= n;
        }

        System.out.println(sb.append(flag).reverse().toString());
    }

}
