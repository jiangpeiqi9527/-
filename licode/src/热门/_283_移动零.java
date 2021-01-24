package 热门;

public class _283_移动零 {
    // 扫描数组，一个指针i记录0元素的位置，另一个指针j负责交换索引位置大于指针i非零元素
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) continue;
            while (i < nums.length && nums[i] != 0) {
                i++;
            }
            if (j > i) {
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }
    }
}
