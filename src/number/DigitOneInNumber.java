package number;

public class DigitOneInNumber {

    public static void main(String[] args) {
        int result = new DigitOneInNumber().digitOneInNumber(113);
        System.out.println("The result is:" + result);
    }

    public int digitOneInNumber(int num) {
        int result = 0;
        int n1 = num % 10, n2;
        if (n1 > 0) result = 1;
        num = num / 10;
        while (num > 0) {
            n2 = num % 10;
            result++;
            if (n2 == 1) {
                result += n1 + 1;
            }
            n1 = n2;
            num = num / 10;
        }

        return result;
    }


}
