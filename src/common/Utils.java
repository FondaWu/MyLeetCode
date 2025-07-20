package common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Utils {

    public static String readStringFromFile(String fileName) {
        StringBuffer sb = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            while (in.ready()) {
                sb = new StringBuffer(in.readLine());
            }
        } catch (Exception e) {
            return null;
        }
        return sb.toString();
    }


    public static Integer[] readIntegersFromFile(String fileName) {
        StringBuffer sb = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            while (in.ready()) {
                sb = new StringBuffer(in.readLine());
            }
        } catch (Exception e) {
            return null;
        }

        String[] dataStrs = sb.toString().split(",");
        return Strs2Integers(dataStrs);
    }

    private static Integer[] Strs2Integers(String[] strs) {
        Integer[] intArray = new Integer[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].compareTo("null") != 0)
                intArray[i] = Integer.parseInt(strs[i]);
        }
        return intArray;
    }

    public static Integer[] readIntegersFromFile2(String fileName) {
        StringBuffer sb = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            while (in.ready()) {
                sb = new StringBuffer(in.readLine());
            }
        } catch (Exception e) {
            return null;
        }

        String[] dataStrs = sb.toString().split(",");
        return Arrays.stream(dataStrs).map(Integer::parseInt).toArray(Integer[]::new);
    }


    public static int[] readArrayFromFile(String fileName) {
        StringBuffer sb = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            while (in.ready()) {
                sb = new StringBuffer(in.readLine());
            }
        } catch (Exception e) {
            return null;
        }

        String[] dataStrs = sb.toString().split(",");
        return Arrays.stream(dataStrs).mapToInt(Integer::parseInt).toArray();
    }

    public static int[][] read2dArrayFromFile(String fileName) {
        int[] data = readArrayFromFile(fileName);
        int[][] result = new int[data.length >> 1][2];

        for (int i = 0; i < result.length; i++) {
            result[i][0] = data[2 * i];
            result[i][1] = data[2 * i + 1];
        }
        return result;
    }

    public static Byte setBit(byte b, int i) {
        b |= 0x01 << i;
        return b;
    }

    public static void unsetBit(byte b, int i) {
        b &= ~(0x01 << i);
    }

    public static int getBit(byte b, int i) {
        return (b >> i) & 0x01;
    }

    public static void setBits(byte[] count, int i) {
        int n1 = i >> 3;
        int n2 = i % 8;
        count[n1] |= 1 << n2;
    }

    public static int getBits(byte[] count, int i) {
        int n1 = i >> 3;
        int n2 = i % 8;
        return (count[n1] >> n2) & 0x01;
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int mid = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < nums[left]) {
                swap(nums, ++mid, i);
            }
        }
        swap(nums, left, mid);

        quickSort(nums, left, mid - 1);
        quickSort(nums, mid + 1, right);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
