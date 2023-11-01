package org.resume.trees;

import com.sun.source.tree.Tree;

public class ValidateBinarySearchTree {

    public ValidateBinarySearchTree(TreeNode root) {
        System.out.println("Is valid BST: " + isValidBST(root));
    }

    private boolean helper(TreeNode root, long leftBounds, long rightBounds) {
        if (root == null) return true;

        long rootValue = (long) root.getVal();
        if (!(rootValue > leftBounds && rootValue < rightBounds)) return false;


        //recursive  step.
        return (
                helper(root.getLeft(), leftBounds, rootValue)
                        && helper(root.getRight(), rootValue , rightBounds )
        );
    }

    private boolean isValidBST(TreeNode root){
        if (root == null  ) return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE );
    }
}
