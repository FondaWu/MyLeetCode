package array;

public class MaxArea {
    public static void main(String[] args) {
        final int MAX = 1000;
        final int COUNT = 100000;

        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        //int[] height  = NumberUtil.getRandomData(COUNT, MAX);
        long start = System.currentTimeMillis();
        int result = maxArea(height);
        System.out.println("函数运行时间:" + (System.currentTimeMillis() - start) + "MS");
        System.out.println("容器可以储存的最大水量:" + result);
    }

    public static int maxArea1(int[] height) {
        int len = height.length;
        int maxArea = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int hi = height[i] < height[j] ? height[i] : height[j];
                int wid = j - i;
                int area = hi * wid;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public static int maxArea(int[] height) {
        int len = height.length;
        int maxArea = 0;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int hi = height[left] < height[right] ? height[left] : height[right];
            int wid = right - left;
            int area = hi * wid;
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[left] < height[right]) {
                left += 1;
            } else {
                right -= 1;
            }
        }

        return maxArea;
    }
}
