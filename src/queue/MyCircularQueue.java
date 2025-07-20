package queue;

public class MyCircularQueue {

    public class Node {
        public int val;
        public Node next;
    }

    private Node front;
    private Node end;

    public MyCircularQueue(int k) {

    }

    public boolean enQueue(int value) {
        return true;
    }

    public boolean deQueue() {
        return true;
    }

    public int Front() {
        return 0;
    }

    public int Rear() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean isFull() {
        return true;
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        circularQueue.enQueue(1);  // 返回 true
        circularQueue.enQueue(2);  // 返回 true
        circularQueue.enQueue(3);  // 返回 true
        circularQueue.enQueue(4);  // 返回 false，队列已满
        circularQueue.Rear();  // 返回 3
        circularQueue.isFull();  // 返回 true
        circularQueue.deQueue();  // 返回 true
        circularQueue.enQueue(4);  // 返回 true
        circularQueue.Rear();  // 返回 4
    }
}
