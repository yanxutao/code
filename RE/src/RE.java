import java.util.Scanner;

/**
 * Created by yanxutao on 4/23/17.
 */
public class RE {

    public boolean isMatch(String str, String pattern) {
        return str.matches(pattern);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String pattern = sc.nextLine();
        RE re = new RE();
        System.out.println(re.isMatch(str, pattern));
    }
}
