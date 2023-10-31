package org.resume.trees;

public class InvertTree {
    public InvertTree(TreeNode root) {

        System.out.println("Inverted tree:\n" + invertTree(root));

    }

    private TreeNode invertTree(TreeNode root) {

        if(root == null) return null;
        TreeNode temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);
        invertTree(root.getLeft());
        invertTree(root.getRight());
        return root;

    }
}
