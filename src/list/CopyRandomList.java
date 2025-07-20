package list;

import list.base.Node;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    public static void main(String[] args) {
        Integer[][] data = new Integer[][]{{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};
        Node head = Node.makeList(data);
        Node.printList(head);
        Node node = copyRandomList(head);
        Node.printList(node);
    }

    public static Node copyRandomList(Node head) {
        Map<Node, Integer> nodeMap = new HashMap<>();
        Node node = head;
        int count = 0;
        while (node != null) {
            nodeMap.put(node, count++);
            node = node.next;
        }

        Node[] nodeArray = new Node[count];
        node = head;
        Node newHead = null, newNode, lastNewNode = null;
        int j;
        for (int i = 0; i < count; i++) {
            newNode = nodeArray[i] == null ? new Node(node.val) : nodeArray[i];
            nodeArray[i] = newNode;
            if (node.random != null){
                j = nodeMap.get(node.random);
                if (nodeArray[j] == null)
                    nodeArray[j] = new Node(node.random.val);
                newNode.random = nodeArray[j];
            } else {
                newNode.random = null;
            }
            if (lastNewNode != null){
                lastNewNode.next = newNode;
            } else{
                newHead = newNode;
            }
            lastNewNode = newNode;
            node = node.next;
        }
        return newHead;
    }
}
