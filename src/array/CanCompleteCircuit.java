package array;

import common.Utils;

public class CanCompleteCircuit {

    public static void main(String[] args) {
        //int[] gas = {1, 2, 3, 4, 5}, cost = {3, 4, 5, 1, 2};
        int[] gas = {2, 3, 4}, cost = {3, 4, 3};
        //int[] gas = {5, 1, 2, 3, 4}, cost = {4, 4, 1, 5, 1};
        //int[] gas = {0}, cost = {0};
        //int[] gas = Utils.readArrayFromFile("res\\134\\34\\gas.txt");
        //int[] cost = Utils.readArrayFromFile("res\\134\\34\\cost.txt");
        long start = System.currentTimeMillis();
        System.out.println("开始计算。。。");
        int result = new CanCompleteCircuit().canCompleteCircuit(gas, cost);
        System.out.println("运行时长：" + (System.currentTimeMillis() - start) + "ms");
        System.out.println("The result is:" + result);
    }


    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0;
        while (i < gas.length) {
            int store = gas[i];
            int j = i;
            int count = 0;
            while (count < gas.length) {
                store -= cost[j];
                if (store < 0) break;
                j = (j + 1) % gas.length;
                store += gas[j];
                ++count;
            }
            if (count == gas.length) {
                return i;
            }
            i = i + count + 1;
        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int start = -1;
        int len;
        while (true) {
            start = getStart(gas, cost, start);
            if (start == gas.length)
                return -1;
            int i = start;
            int j;
            len = 0;
            int total = gas[i];
            do {
                j = (i + 1) % gas.length;
                if (total >= cost[i]) {
                    total += gas[j] - cost[i];
                    len++;
                    i = j;
                } else {
                    break;
                }

            } while (len < gas.length);
            if (len == gas.length) return start;
        }
    }

    private int getStart(int[] gas, int[] cost, int from) {
        int i = from + 1;
        for (; i < gas.length; i++) {
            if (gas[i] >= cost[i]) {
                break;
            }
        }
        return i;
    }
}
