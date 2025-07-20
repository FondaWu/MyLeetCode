package array;

import java.util.Arrays;

public class BuyChoco {

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 2};
        int money = 3;

        int result = buyChoco(prices, money);
        System.out.println("The result is:" + result);
    }

    public static int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);

        int tmp = prices[0] + prices[1];
        if (tmp <= money)
            return money - tmp;
        else
            return money;
    }
}
