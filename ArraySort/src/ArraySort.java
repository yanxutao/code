import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by yanxutao on 8/8/17.
 */
public class ArraySort {

    public String PrintMinNumber(int [] numbers) {
        int n = numbers.length;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(numbers[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i);
        }

        return sb.toString();
    }

}
