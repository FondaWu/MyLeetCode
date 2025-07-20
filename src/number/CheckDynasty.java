package number;

import java.util.Arrays;

/*
LCR 186. 文物朝代判断（简单）
【描述】
展览馆展出来自 13 个朝代的文物，每排展柜展出 5 个文物。某排文物的摆放情况记录于数组 places，其中 places[i] 表示处于第 i 位文物的所属
朝代编号。其中，编号为 0 的朝代表示未知朝代。请判断并返回这排文物的所属朝代编号是否连续（如遇未知朝代可算作连续情况）。

【示例】
示例 1：
输入: places = [0, 6, 9, 0, 7]
输出: True

示例 2：
输入: places = [7, 8, 9, 10, 11]
输出: True

【提示】
places.length = 5
0 <= places[i] <= 13
 */
public class CheckDynasty {

    public static void main(String[] args) {
        //int[] places = new int[]{0, 0, 8, 5, 4};
        int[] places = new int[]{0, 6, 9, 0, 7};

        System.out.println("计算结果：" + checkDynasty(places));
    }

    private static boolean checkDynasty(int[] places) {
        Arrays.sort(places);

        int zeroCount = 0, gapCount = 0;
        for (int i = 0; i < places.length; i++){
            if (places[i] == 0) zeroCount++;
            else {
                if (i > 0 && places[i-1] != 0){
                    if (places[i] == places[i-1]) return false;
                    gapCount += places[i] - places[i-1] - 1;
                }

            }
        }
        return gapCount <= zeroCount;
    }

    private static boolean checkDynasty1(int[] places) {
        int last = places[0];
        int order = 0;
        for (int i = 1; i < places.length; i++) {
            if (places[i] == 0) {


            } else {
                if (places[i] == last) return false;
                if (last != 0) {
                    if (order == 0) {
                        if (places[i] < last) order = -1;
                        if (places[i] > last) order = 1;
                    } else {
                        if (order == -1 && places[i] > last) return false;
                        if (order == 1 && places[i] < last) return false;
                    }
                }
                last = places[i];
            }
        }
        return true;
    }
}
