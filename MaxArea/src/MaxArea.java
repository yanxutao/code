import java.util.Scanner;

/**
 * Created by yanxutao on 5/1/17.
 */
public class MaxArea {

    public int maxArea(int[] height) {
        int maxArea = 0;

        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            if (area > maxArea) {
                maxArea = area;
            }

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        MaxArea ma = new MaxArea();
        ma.maxArea(height);
    }

}
