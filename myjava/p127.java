class Node {
    int key;
    Node left, right;
    
    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    void print_Postorder(Node node) {
        if (node == null) {
            return;
        }
        print_Postorder(node.right);
        System.out.print(node.key + " ");
        print_Postorder(node.left);
    }

    // 引数なしで呼び出すとrootから全巡回
    void print_Postorder() {
        print_Postorder(root);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(55);
        tree.root.left = new Node(21);
        tree.root.right = new Node(80);
        tree.root.left.left = new Node(9);
        tree.root.left.right = new Node(29);
        tree.root.right.left = new Node(76);
        tree.root.right.right = new Node(91);

        // 予測される出力 91,80,76,55,29,21,9 
        System.out.println("\nPostorder traversal of binary tree is: ");
        tree.print_Postorder();
    }
}