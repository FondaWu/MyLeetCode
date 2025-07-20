package string;

public class MinExtraChar {

    public static void main(String[] args) {
        String s = "dwmodizxvvbosxxw";
        String[] dictionary = new String[]{"ox","lb","diz","gu","v","ksv","o","nuq","r","txhe","e","wmo","cehy","tskz","ds","kzbu"};
        System.out.println("运行结果：" + minExtraChar(s, dictionary));
    }

    public static int minExtraChar(String s, String[] dictionary) {
        int count;
        while (true) {
            count = 0;
            for (int i = 0; i < dictionary.length; i++) {
                int j = s.indexOf(dictionary[i]);
                if (j != -1) {
                    s = s.substring(0, j) + s.substring(j + dictionary[i].length());
                    count++;
                }
            }
            if (count == 0) break;
        }
        return s.length();
    }
}
