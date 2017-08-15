/**
 * Created by yanxutao on 6/19/17.
 */
public class SJF {

    private static void sortDuration(int[] request, int[] duration) {
        int n = request.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (duration[i] > duration[j]) {
                    int tmp1 = duration[i];
                    duration[i] = duration[j];
                    duration[j] = tmp1;

                    int tmp2 = request[i];
                    request[i] = request[j];
                    request[j] = tmp2;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] request = {0, 1, 3, 9};
        int[] duration = {2, 1, 5, 7};

        sortDuration(request, duration);

        boolean[] flag = new boolean[request.length];

        int time = 0;
        int wait = 0;
    }

}
