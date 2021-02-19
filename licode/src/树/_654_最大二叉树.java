package 树;

public class _654_最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = maxTree(nums, 0, nums.length);
        return root;
    }

    private TreeNode maxTree(int[] nums, int left, int right) {
        if (left > right) return null;
        int maxIndex = getMaxIndex(nums, left, right);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = maxTree(nums, left, maxIndex);
        root.right = maxTree(nums, maxIndex + 1, right);
        return root;
    }

    private int getMaxIndex(int[] nums, int left, int right) {
        int maxIndex = 0;
        for (int i = left; i < right; i++) {
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }
        return maxIndex;
    }
}
