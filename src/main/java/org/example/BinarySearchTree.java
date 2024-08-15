package org.example;

class BSTNode {
    int val;
    BSTNode left, right;

    BSTNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class BinarySearchTree {
    BSTNode root;

    public void insert(int val) {
        root = insertRec(root, val);
    }

    private BSTNode insertRec(BSTNode root, int val) {
        if (root == null) {
            root = new BSTNode(val);
            return root;
        }

        if (val < root.val)
            root.left = insertRec(root.left, val);
        else if (val > root.val)
            root.right = insertRec(root.right, val);

        return root;
    }

    public boolean search(int val) {
        return searchRec(root, val);
    }

    private boolean searchRec(BSTNode root, int val) {
        if (root == null) return false;
        if (root.val == val) return true;

        if (val < root.val)
            return searchRec(root.left, val);
        else
            return searchRec(root.right, val);
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.val + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        bst.inorder();
        System.out.println("\nSearch 40: " + bst.search(40));
    }
}
