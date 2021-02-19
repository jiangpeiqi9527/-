package 树;

public class _面试题_04_02_最小高度树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = buildBBST(nums, 0, nums.length);
        return root;
    }

    private TreeNode buildBBST(int[] nums, int begin, int end) {
        if (begin == end) return null;
        int midIndex = (begin + end) / 2;
        TreeNode root = new TreeNode(nums[midIndex]);
        root.left = buildBBST(nums, begin, midIndex);
        root.right = buildBBST(nums, midIndex + 1, end);
        return root;
    }
}
