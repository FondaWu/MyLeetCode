package number;

import java.util.ArrayList;
import java.util.List;

public class WaysToBuyPensPencils {
    private static List<int[]> buyWays = new ArrayList<>();
    private static long count;

    public static void main(String[] args) {
        long reuslt = waysToBuyPensPencils3(1000000, 1, 1);
        System.out.println("所以买钢笔和铅笔的总方案数为:" + reuslt);
        for (int[] buyWay : buyWays) {
            System.out.println(buyWay[0] + ":" + buyWay[1]);
        }

    }

    private static long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (total == 0) return 1;
        return findWay(total, cost1, 0, cost2, 0);
    }

    private static long findWay(int total, int cost1, int n1, int cost2, int n2) {
        if (n1 * cost1 + n2 * cost2 > total) return count;

        int[] buyWay = new int[]{n1, n2};
        buyWays.add(buyWay);
        ++count;
        if (n1 * cost1 + n2 * cost2 < total) {
            findWay(total, cost1, n1 + 1, cost2, n2);
            findWay(total, cost1, n1, cost2, n2 + 1);
        }
        return count;
    }

    private static long waysToBuyPensPencils2(int total, int cost1, int cost2) {
        int n1 = total / cost1;
        int n2 = total / cost2;

        int count = 0;
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i * cost1 + j * cost2 <= total)
                    count++;
            }
        }
        return count;
    }

    private static long waysToBuyPensPencils3(int total, int cost1, int cost2) {
        int n1 = cost1 > cost2 ? cost1 : cost2;
        int n2 = cost1 > cost2 ? cost2 : cost1;
        long count = 0;
        for (int i = 0; i <= total / n1; i++) {
            count += (total - i * n1) / n2 + 1;
        }
        return count;
    }
}
