/**
 * Created by yanxutao on 8/3/17.
 */
public class SentenceReversion {

    public String ReverseSentence(String str) {
        StringBuilder sb = new StringBuilder();
        int n = str.length();
        int end = n;
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                sb.append(str.substring(i + 1, end));
                sb.append(' ');
                end = i;
            }
        }
        sb.append(str.substring(0, end));
        return sb.toString();
    }

    public static void main(String[] args) {
        SentenceReversion sr = new SentenceReversion();
        System.out.println(sr.ReverseSentence(" I am a student. "));
    }

}
