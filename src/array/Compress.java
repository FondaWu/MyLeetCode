package array;

import java.util.Arrays;

/*
443. 压缩字符串(中等)
【描述】
给你一个字符数组 chars ，请使用下述算法压缩：
从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
如果这一组长度为 1 ，则将字符追加到 s 中。
否则，需要向 s 追加字符，后跟这一组的长度。
压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
请在 修改完输入数组后 ，返回该数组的新长度。
你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
【提示】
1) 1 <= chars.length <= 2000
2) chars[i] 可以是小写英文字母、大写英文字母、数字或符号
 */
public class Compress {

    public static void main(String[] args) {
        //char chars[] = {'a', 'a', 'a', 'b', 'b', 'a', 'a'};
        char chars[] = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        //char chars[] = {'a'};
        int result = compress(chars);
        System.out.println(Arrays.toString(chars));
        System.out.println("结果字符串长度：" + result);
    }

    public static int compress(char[] chars) {
        int i, h = 0;
        int len = 0;
        for (i = 1; i <= chars.length; i++) {
            if (i == chars.length || chars[i] != chars[h]) {
                chars[len++] = chars[h];
                if (i - h > 1) {
                    String s = String.valueOf(i - h);
                    for (int j = 0; j < s.length(); j++) {
                        chars[len++] = s.charAt(j);
                    }
                }
                h = i;
            }
        }
        //System.arraycopy(chars2, 0, chars, 0, len);
        return len;
    }

}
