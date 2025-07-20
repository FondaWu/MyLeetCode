package array;

import java.util.TreeMap;

public class MaxPoints {

    public static void main(String[] args) {
        //int points[][] = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        int points[][] = {{1, 1}, {2, 2}, {3, 3}};
        int result = new MaxPoints().maxPoints(points);
        System.out.println("计算结果：" + result);
    }

    public int maxPoints(int[][] points) {
        TreeMap<Double, Integer> map = new TreeMap<>();
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double k = calcK(points[i], points[j]);
                int count = map.getOrDefault(k, 1) + 1;
                map.put(k, count);
            }
        }
        return map.lastEntry().getValue();
    }

    double calcK(int point1[], int point2[]) {
        int delX = point2[0] - point1[0];
        int delY = point2[1] - point1[1];
        return delY / delX;
    }
}
