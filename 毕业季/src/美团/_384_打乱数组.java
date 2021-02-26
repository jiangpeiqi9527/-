package 美团;

public class _384_打乱数组 {

    private int[] original = null;

    private int[] clone = null;

    public _384_打乱数组(int[] nums) {
        if (nums == null || nums.length == 0) return;
        this.original = nums;
        this.clone = new int[nums.length];
        for (int i = 0; i < clone.length; i++) {
            clone[i] = nums[i];
        }
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (clone == null) return null;
        int[] used = new int[original.length];
        int index = 0;
        int[] res = new int[clone.length];
        while (index < clone.length) {
            int random = (int) (Math.random() * clone.length);
            if (used[random] == 0) {
                used[random] = 1;
                res[random] = clone[index];
                index++;
            }
        }
        return res;
    }
}
