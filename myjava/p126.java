class Node {
    int key;
    Node left,right;
    // コンストラクタ
    public Node(int item){
        key = item;
        left = right= null;
    }
}

class BinaryTree {
    Node root;

    void BinaryTrre() {
        root = null;
    }

    void print_Inorder(Node node){
        if ( node == null) {
            return;
        }
        // 再帰的に左端まで行ってそっから表示
        print_Inorder(node.left);
        System.out.print(node.key + " ");
        print_Inorder(node.right);
    }

    // inorderで全巡回するヘルパーメソッド
    void print_Inorder() {
        print_Inorder(root);
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

        System.out.println("\nInorder trabersal of binary tree is: ");
        tree.print_Inorder();
    }    
}