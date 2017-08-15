import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yanxutao on 7/22/17.
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        List<List<Character>> l = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            l.add(new ArrayList<Character>());
        }

        int i = 0;
        int flag = 1;
        for (int j = 0; j < s.length(); j++) {
            l.get(i).add(s.charAt(j));

            i += flag;
            if (i == numRows) {
                i = Math.max(i - 2, 0);
                flag = -1;
            }
            if (i == -1) {
                i = Math.min(i + 2, numRows - 1);
                flag = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (i = 0; i < l.size(); i++) {
            for (int j = 0; j < l.get(i).size(); j++) {
                sb.append(l.get(i).get(j));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        ZigZagConversion zzc = new ZigZagConversion();
        System.out.println(zzc.convert(s, n));
    }

}
