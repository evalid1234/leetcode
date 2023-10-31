package org.resume.trees;


import java.util.HashSet;

//given a binary tree determine if its height is balanced.
//a tree is balanced if the left and right subtrees of every node differ in height by no more than 1;.
public class BalancedBinaryTree {
    /*
    * another solution:
    * public int getHeight(TreeNode node) {
        if (node == null) return 0;

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        if (left ==-1 || right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) +1;
    }
      public boolean isBalanced (TreeNode root) {
        int res = getHeight(root);
        if (res == -1 ) return false;
        return true;

      }}
      * */
    private class ResultPair {
        private boolean isBalanced;
        private int height;
        public ResultPair(){

        }
        public ResultPair(boolean isBalanced, int height) {
            this.isBalanced= isBalanced;
            this.height = height;
        }
        public int getHeight() {
            return height;
        }
         public boolean getIsBalanced(){
            return isBalanced;
         }
        public void setHeight(int height) {
            this.height =  height;
        }
        public void setIsBalanced(boolean isBalanced){
            this.isBalanced = isBalanced;
        }
    }
    private ResultPair getHeightOfSubTree(TreeNode node) {
        if (node  == null) { return new ResultPair(true, 0);}

        //height of left
        ResultPair left = getHeightOfSubTree(node.getLeft())  ;

        //height of right
        ResultPair right = getHeightOfSubTree(node.getRight() );

        boolean isBalanced = (left.getIsBalanced() &&
                right.getIsBalanced() &&
                Math.abs(left.getHeight() - right.getHeight() ) <= 1);
        int height = (1+Math.max(left.getHeight(), right.getHeight()));

        return new ResultPair(isBalanced, height);

    }
    private boolean isBalanced(TreeNode root) {


        return getHeightOfSubTree(root).getIsBalanced();

    }

}
