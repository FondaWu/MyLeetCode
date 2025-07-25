package application;

/**
 * 1670. 设计前中后队列（中等）
 *
 * 【描述】
 * 请你设计一个队列，支持在前，中，后三个位置的 push 和 pop 操作。
 * 请你完成 FrontMiddleBack 类：
 * FrontMiddleBack() 初始化队列。
 * void pushFront(int val) 将 val 添加到队列的 最前面 。
 * void pushMiddle(int val) 将 val 添加到队列的 正中间 。
 * void pushBack(int val) 将 val 添加到队里的 最后面 。
 * int popFront() 将 最前面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * int popMiddle() 将 正中间 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * int popBack() 将 最后面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * 请注意当有 两个 中间位置的时候，选择靠前面的位置进行操作。比方说：
 *
 * 将 6 添加到 [1, 2, 3, 4, 5] 的中间位置，结果数组为 [1, 2, 6, 3, 4, 5] 。
 * 从 [1, 2, 3, 4, 5, 6] 的中间位置弹出元素，返回 3 ，数组变为 [1, 2, 4, 5, 6] 。
 *
 *
 * 【示例】
 * 示例 1：
 * 输入：
 * ["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", "popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
 * [[], [1], [2], [3], [4], [], [], [], [], []]
 * 输出：
 * [null, null, null, null, null, 1, 3, 4, 2, -1]
 * 解释：
 * FrontMiddleBackQueue q = new FrontMiddleBackQueue();
 * q.pushFront(1);   // [1]
 * q.pushBack(2);    // [1, 2]
 * q.pushMiddle(3);  // [1, 3, 2]
 * q.pushMiddle(4);  // [1, 4, 3, 2]
 * q.popFront();     // 返回 1 -> [4, 3, 2]
 * q.popMiddle();    // 返回 3 -> [4, 2]
 * q.popMiddle();    // 返回 4 -> [2]
 * q.popBack();      // 返回 2 -> []
 * q.popFront();     // 返回 -1 -> [] （队列为空）
 *
 * 【提示】
 * 1）1 <= val <= 109
 * 2）最多调用 1000 次 pushFront， pushMiddle， pushBack， popFront， popMiddle 和 popBack 。
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrontMiddleBackQueue {
    private List<Integer> headList;
    private List<Integer> tailList;

    public FrontMiddleBackQueue() {
        headList = new ArrayList<>();
        tailList = new ArrayList<>();
    }

    public void print() {
        System.out.println(Arrays.toString(headList.toArray()) + Arrays.toString(tailList.toArray()));
    }

    public void pushFront(int val) {
        headList.add(0, val);
        adjustQueue();
    }

    public void pushMiddle(int val) {
        if (headList.size() > tailList.size()) {
            int val2 = headList.remove(headList.size() - 1);
            tailList.add(0, val2);
            headList.add(val);
        } else {
            headList.add(val);
        }
    }

    public void pushBack(int val) {
        tailList.add(val);
        adjustQueue();
    }

    public int popFront() {
        if (headList.isEmpty()) return -1;
        int val = headList.remove(0);
        adjustQueue();
        return val;
    }

    public int popMiddle() {
        if (headList.isEmpty()) return -1;

        int val;
        if (headList.size() >= tailList.size()) {
            val = headList.remove(headList.size() - 1);
        } else {
            val = tailList.remove(0);
        }
        adjustQueue();
        return val;
    }

    public int popBack() {
        if (tailList.isEmpty()) {
            if (headList.isEmpty()) return -1;
            return headList.remove(headList.size() - 1);
        } else {
            int val = tailList.remove(tailList.size() - 1);
            adjustQueue();
            return val;
        }
    }

    private void adjustQueue() {
        if (headList.size() - tailList.size() > 1) {
            tailList.add(0, headList.remove(headList.size() - 1));
        } else if (tailList.size() > headList.size()) {
            headList.add(tailList.remove(0));
        }
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushMiddle(1);   // [1]
        q.pushMiddle(2);    // [1, 2]
        q.pushMiddle(3);  // [1, 3, 2]
        q.print();
        int val = q.popMiddle();     // 返回 1 -> [4, 3, 2]
        System.out.print(val + " ");
        q.print();
        val = q.popMiddle();    // 返回 3 -> [4, 2]
        System.out.print(val + " ");
        q.print();
        val = q.popMiddle();    // 返回 4 -> [2]
        System.out.print(val + " ");
        q.print();
    }
}
