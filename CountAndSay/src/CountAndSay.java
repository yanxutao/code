/**
 * Created by yanxutao on 7/25/17.
 */
public class CountAndSay {

    private String next(String current) {
        char[] cs = current.toCharArray();
        StringBuilder sb = new StringBuilder();
        char c = cs[0];
        int count = 1;
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] == c) {
                count++;
            } else {
                sb.append(count);
                sb.append(c);
                c = cs[i];
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);

        return sb.toString();
    }

    public String countAndSay(int n) {
        String current = "1";
        while (--n > 0) {
            current = next(current);
        }
        return current;
    }

}
