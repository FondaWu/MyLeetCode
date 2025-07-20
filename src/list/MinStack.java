package list;

import java.util.Stack;
import java.util.TreeMap;

public class MinStack {

    private Stack<Integer> dataStack;
    private TreeMap<Integer, Integer> dataMap;

    public MinStack() {
        dataStack = new Stack<>();
        dataMap = new TreeMap<>();
    }

    public void push(int val) {
        dataStack.push(val);
        int count = 1;
        if (dataMap.containsKey(val)) {
            count += dataMap.get(val);
        }
        dataMap.put(val, count);
    }

    public void pop() {
        int data = dataStack.pop();
        int count = dataMap.get(data) - 1;
        if (count > 0) {
            dataMap.put(data, count);
        } else
            dataMap.remove(data);
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return dataMap.firstKey().intValue();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
