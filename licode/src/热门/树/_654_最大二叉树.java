package 热门.树;

public class _654_最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = maxTree(nums,0,nums.length);
        return root;
    }

    private TreeNode maxTree(int[] nums,int begin, int end) {
        if (begin == end) return null;
        int maxIndex = getMaxIndex(nums, begin, end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = maxTree(nums, begin, maxIndex);
        root.right = maxTree(nums, maxIndex + 1, end);
        return root;
    }

    private int getMaxIndex(int[] nums, int begin, int end) {
        int maxIndex = begin;
        for (int i = begin; i < end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
