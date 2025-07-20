package list.base;

/**
 * @author: FondaWu
 * @create: 2021-03-29 16:30
 * @description: ${description}
 **/
public class Node {
    public int val;

    public Node next;

    public Node random;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public static Node makeList(Integer[][] dataArray) {
        Node[] nodeArray = new Node[dataArray.length];
        Node head = null, last = null;
        for (int i = 0; i < dataArray.length; i++) {
            Node node = new Node(dataArray[i][0]);
            nodeArray[i] = node;
            if (head == null) {
                head = node;
            } else {
                last.next = node;

            }
            last = node;
        }
        Node node = head;
        for (int i = 0; i < dataArray.length; i++) {
            node.random = dataArray[i][1] == null ? null : nodeArray[dataArray[i][1]];
            node = node.next;
        }
        return head;
    }

    public static void printList(Node head) {
        Node node = head;
        while (node != null) {
            System.out.print(node.val + "-");
            if (node.random != null) {
                System.out.print(node.random.val + " ");
            } else {
                System.out.print("null ");
            }
            node = node.next;
        }
    }
}
