package 树;

public class _108_将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length);
    }

    private TreeNode helper(int[] nums, int begin, int end) {
        if (begin >= end) return null;
        int mid = (begin + end) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,begin,mid);
        root.right = helper(nums,mid + 1,end);
        return root;
    }
}
