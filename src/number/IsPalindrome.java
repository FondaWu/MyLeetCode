package number;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {

    public static void main(String[] args) {
        int x = 121;
        boolean result = isPalindrome(x);
        System.out.println("The result is:" + result);
    }

    private static boolean isPalindrome(int x) {
        if (x < 0) return false;

        List<Integer> numbers = new ArrayList<>();
        while (x > 0) {
            numbers.add(x - x / 10 * 10);
            x /= 10;
        }

        for (int i = 0; i < numbers.size() - i; i++) {
            if (numbers.get(i) != numbers.get(numbers.size() - i - 1))
                return false;
        }
        return true;
    }
}
