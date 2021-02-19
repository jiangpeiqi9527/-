package 热门.树;

import sun.applet.Main;

public class _108_将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode bbst = buildBBST(nums,0,nums.length);
        return bbst;
    }

    private TreeNode buildBBST(int[] nums, int begin, int end) {
        if (begin == end) return null;
        int midIndex = (end + begin) >> 1;
        TreeNode root = new TreeNode(nums[midIndex]);
        root.left = buildBBST(nums,begin,midIndex);
        root.right = buildBBST(nums,midIndex + 1,end);
        return root;
    }

    public static void main(String[] args) {
        _108_将有序数组转换为二叉搜索树 test = new _108_将有序数组转换为二叉搜索树();
        test.sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
}
