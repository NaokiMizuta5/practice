import java.util.*;

class LinkedList {
    static Node head;
    static class Node {
        int data;
        Node next_node;

        Node(int d) {
            data = d;
            next_node = null;
        }
    }
    Node reverse(Node node) {
        Node prev_node = null;
        Node current_node = node;
        Node next_node = null;
        while(current_node != null) {
            // 現在のノードのポインタを次のノードに格納
            next_node = current_node.next_node;
            // previousのノードの値を現在のポインタに格納
            current_node.next_node = prev_node;
            // 現在のノードの値をpreviousのノードに格納
            prev_node = current_node;
            // 次のノードに移動
            current_node = next_node;
        }
        node = prev_node;
        return node;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            // ポインタの値を代入
            node = node.next_node;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // 連結リスト作り
        list.head = new Node(20);
        list.head.next_node = new Node(40);
        list.head.next_node.next_node = new Node(60);
        list.head.next_node.next_node.next_node = new Node(60);

        System.out.println("Origina Linked list:");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("Reversed Linked list:");
        list.printList(head);
    }
}

