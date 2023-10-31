package org.resume.trees;

public class MergeTrees {

    public MergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode root = mergeTrees(root1,root2);
        System.out.println("Merged tree:\n");
        try {
            TreeNode.showTree(root);

        } catch (Exception e) {
            System.out.println("Err, please implment your own error handling");
        }
    }

    private TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null ) return root2;
        if(root2 == null) return root1;
        if (root1 == null && root2 == null) return null;

        root1.setVal(root1.getVal() + root2.getVal());
        root1.setLeft( mergeTrees(root1.getLeft(), root2.getLeft()) ) ;
        root1.setRight( mergeTrees(root1.getRight(), root2.getRight()) );
        return root1;



    }
}
