package org.example;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinaryTree {
    TreeNode root;

    public TreeNode findLCA(TreeNode node, int n1, int n2) {
        if (node == null) return null;

        if (node.val == n1 || node.val == n2) return node;

        TreeNode leftLCA = findLCA(node.left, n1, n2);
        TreeNode rightLCA = findLCA(node.right, n1, n2);

        if (leftLCA != null && rightLCA != null) return node;

        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(1);
        tree.root.left.left = new TreeNode(6);
        tree.root.left.right = new TreeNode(2);
        tree.root.right.left = new TreeNode(0);
        tree.root.right.right = new TreeNode(8);

        TreeNode lca = tree.findLCA(tree.root, 5, 1);
        System.out.println("LCA(5, 1): " + (lca != null ? lca.val : "Not found"));
    }
}
