package 美团;

public class _33_搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        // 思路：先从左往右排，一直排到 !(nums[i] < nums[i + 1]) 这里，没有找到target，返回-1
        // 如果nums[0] > target 则从右往左排，一直排到 !(nums[i] > nums[i - 1]) 这里，没有找到target，返回-1
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        if (nums[0] < target) {
            int index = 0;
            while (index < nums.length) {
                if (nums[index] == target) return index;
                if (nums[index] > nums[index + 1]) return -1;
                index++;
            }
        } else {
            int index = nums.length - 1;
            while (index >= 0) {
                if (nums[index] == target) return index;
                if (nums[index] < nums[index - 1]) return -1;
                index--;
            }
        }
        return -1;
    }
}
