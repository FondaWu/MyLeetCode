package string;

import java.util.Arrays;

public class DayOfYear {

    public static void main(String[] args) {
        String date = "2019-02-10";
        int result = dayOfYear(date);
        System.out.println("The result is:" + result);
    }

    private static int dayOfYear(String date) {
        String[] dateUnits = date.split("-");

        int year = Integer.parseInt(dateUnits[0]);
        int month = Integer.parseInt(dateUnits[1]);
        int day = Integer.parseInt(dateUnits[2]);
        return getDays(year, month, day);
    }

    private static int isLeap(int year) {
        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0)
            return 1;
        return 0;
    }

    private static int getDays(int year, int month, int day) {
        int months[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int res = 0;
        for (int i = 0; i < month - 1; i++) {
            res += months[i];
        }
        if (month > 2) res += isLeap(year);
        return res + day;
    }
}
