package 其他;

class Solution {
    private int depth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        preorder(0,root);
        return depth;
    }

    private void preorder(int cengshu,TreeNode root) {
        if(root ==null) {
            depth = Math.min(depth,cengshu);
        }
        preorder(cengshu + 1,root.left);
        preorder(cengshu + 1, root.right);
    }
}
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }