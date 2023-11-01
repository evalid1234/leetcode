package org.resume.trees;

public class SameTree {
    public SameTree(TreeNode p , TreeNode q) {
        System.out.println(isSameTree(p, q));
    }

    //    if you want to use in leetcode paste this code instead:
    /*
    * public boolean isSameTree(TreeNode p, TreeNode q) {
             //check the structure
        if (p == null && q != null ) return false;
        if (q == null && p != null ) return false;
        if (p == null ) return true;

        boolean leftSubtreesEqual = isSameTree(p.left,q.left);
        boolean equal = p.val == q.val;
        boolean rightSubtreesEqual = isSameTree(p.right,q.right);
        return equal && leftSubtreesEqual && rightSubtreesEqual;
    }
    * */

    private boolean isSameTree(TreeNode root1, TreeNode root2){
            //check the structure
        if (root1 == null && root2 != null ) return false;
        if (root2 == null && root1 != null ) return false;
        if (root1 == null ) return true;

        //check value
        boolean leftSubtreesEqual = isSameTree(root1.getLeft(),root2.getLeft());
        boolean equal = root1.getVal() == root2.getVal();
        boolean rightSubtreesEqual = isSameTree(root1.getRight(),root2.getRight());
        return equal && leftSubtreesEqual && rightSubtreesEqual;

    }
}
