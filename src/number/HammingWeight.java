package number;

public class HammingWeight {

    public static void main(String[] args) {
        int result = hammingWeight2(1111101);
        System.out.println("intersection node is:" + result);
    }

    private static int hammingWeight(int n) {
        int count = 0;
        for (char i = 0; i < 32; i++) {
            if (((n >> i) & 0x01) > 0) count++;
        }
        return count;
    }

    private static int hammingWeight2(int n) {
        int count = 0;
        while (n > 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }

}
