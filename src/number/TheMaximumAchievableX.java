package number;

public class TheMaximumAchievableX {

    public static void main(String[] args) {
        int num = 4, t = 1;
        System.out.println("计算结果：" + new TheMaximumAchievableX().theMaximumAchievableX(num, t));
    }

    public int theMaximumAchievableX(int num, int t) {
        return num + 2 * t;
    }

}
