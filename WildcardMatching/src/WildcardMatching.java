import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yanxutao on 7/9/17.
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        s = s.replace('*', 'a');
        s = s.replace('?', 'a');
        p = p.replace("*", "\\w*");
        p = p.replace("?", "\\w{1}");
        Pattern pattern = Pattern.compile(p);
        Matcher m = pattern.matcher(s);
        return m.matches();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String pattern = sc.nextLine();

        WildcardMatching wm = new WildcardMatching();
        System.out.println(wm.isMatch(str, pattern));
    }

}
