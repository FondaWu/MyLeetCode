package number;

import java.util.*;

public class GrayCode {
    private List<Integer> result;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int n = 2;
        List<Integer> result = new GrayCode().grayCode(n);
        System.out.println("result = " + Arrays.toString(result.toArray()));
        System.out.println("函数执行时间:" + (System.currentTimeMillis() - start) + "MS");
    }

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int count = 1;
        int total = (int) Math.pow(2, n);
        int first = result.get(0);
        while (result.size() < total) {

            for (int i = 1; i < total; i++) {
                if (!set.contains(i)) {

                }
            }
        }
        pushNext(1, count, total, set, result);

        return result;
    }

    private void pushNext(int n, int count, int total, Set<Integer> set, List<Integer> result) {
        int last = result.get(result.size() - 1);
        if (onlyOneBit(n ^ last)) {
            if (result.size() == total - 1) {
                int first = result.get(0);
                if (onlyOneBit(n ^ first)) {
                    result.add(n);
                    set.add(n);
                } else {

                }
            } else {
                result.add(n);
                set.add(n);
                if (n < total) {
                    pushNext(n + 1, count, total, set, result);
                } else {
                    for (int i = 1; i < n; i++) {

                    }
                }

            }
        }


    }

    private boolean onlyOneBit(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
