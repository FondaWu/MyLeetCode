package application;

import common.Utils;

public class SmallestInfiniteSet {
    private final int MAX = 1000000000;
    private final int COUNT = 400000000;
    private final int len = (int) Math.ceil(MAX / 8.0);
    private byte[] bytes = new byte[len];
    private int minVal= Integer.MIN_VALUE;

    public SmallestInfiniteSet() {
    }

    public int popSmallest() {
        int oldMinVal = minVal;
        int j = oldMinVal >> 3;
        int k = oldMinVal % 8;
        Utils.unsetBit(bytes[j], k);

        for (; j < len; j++){
            if (bytes[j] > 0) {
                for (k = 0; k < 8; k++){
                    if (Utils.getBit(bytes[j], k) > 0) {
                        break;
                    }
                }
            }
        }
        minVal = j << 3 + k;
        return oldMinVal;
    }

    public void addBack(int num) {
        int j = num >> 3;
        int k = num % 8;
        bytes[j] = Utils.setBit(bytes[j], k);
        if (num < minVal) minVal = num;
    }

}
