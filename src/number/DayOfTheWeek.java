package number;

import java.util.Calendar;
import java.util.Date;

/**
 * 1185. 一周中的第几天(简单)
 * 【描述】
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 *
 * 【示例】
 * 示例 1：
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 * 示例 2：
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 * 示例 3：
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 *
 * 【提示】
 * 给出的日期一定是在 1971 到 2100 年之间的有效日期。
 **/
public class DayOfTheWeek {

    public static void main(String[] args) {
        int day = 31, month = 8, year = 2019;
        String result = dayOfTheWeek(day, month, year);
        System.out.println("The result is:" + result);

    }
    private static String dayOfTheWeek(int day, int month, int year) {
        String[] weeks = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int res = 4;
        // 年
        for (int i = 1971; i < year; i++)
            res += 365 + isLeap(i);
        // 月
        for (int i = 1; i < month; i++)
            res += getDays(year, i);
        // 日
        res += day;

        res %= 7;
        return weeks[res];
    }

    private static int isLeap(int year) {
        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0)
            return 1;
        return 0;
    }

    private static int getDays(int year, int month) {
        int months[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int res = months[month];
        if (month == 2) res += isLeap(year);
        return res;
    }


    private static String dayOfTheWeek1(int day, int month, int year) {
        String[] weeks = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        cal.set(year, month - 1, day);
        int i = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weeks[i];
    }
}
