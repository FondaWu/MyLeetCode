package string;

public class AddBinary {

    public static void main(String[] args) {
        String a = "11";
        String b = "1";

        String result = addBinary3(a, b);
        System.out.println(result);
    }

    private static String addBinary(String a, String b) {
        if (a.length() > b.length()) {
            StringBuilder sb = new StringBuilder();
            sb.append(b);
            for (int i = 0; i < a.length() - b.length(); i++) {
                sb.insert(0, '0');
            }
            b = sb.toString();
        } else if (a.length() < b.length()) {
            StringBuilder sb = new StringBuilder();
            sb.append(a);
            for (int i = 0; i < b.length() - a.length(); i++) {
                sb.insert(0, '0');
            }
            a = sb.toString();
        }

        int carry = 0;
        int c;
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            c = a.charAt(i) + b.charAt(i) - 96 + carry;
            if (c > 1) {
                c -= 2;
                carry = 1;
            } else
                carry = 0;
            sb.insert(0, c);
        }
        if (carry > 0)
            sb.insert(0, 1);
        return sb.toString();
    }

    private static String addBinary2(String a, String b) {
        long n1 = Long.parseUnsignedLong(a, 2);
        Long n2 = Long.parseUnsignedLong(b, 2);
        return Long.toBinaryString(n1 + n2);
    }

    private static String addBinary3(String a, String b) {
        int carry = 0;
        int c;
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            c = carry;
            c += i < 0 ? 0 : a.charAt(i) - 48;
            c += j < 0 ? 0 : b.charAt(j) - 48;

            if (c > 1) {
                c -= 2;
                carry = 1;
            } else
                carry = 0;
            sb.append(c);
        }
        if (carry > 0)
            sb.append(1);

        return sb.reverse().toString();
    }
}
