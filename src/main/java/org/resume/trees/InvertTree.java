package org.resume.trees;

public class InvertTree {
    public InvertTree(TreeNode root) {

        System.out.println("Inverted tree:\n" );
        try {

            TreeNode.showTree(invertTree(root));

        } catch (Exception e) {
            System.out.println("Err, please implment your own error handling");
        }

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
