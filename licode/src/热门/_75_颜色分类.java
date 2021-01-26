package 热门;

public class _75_颜色分类 {
    public void sortColors(int[] nums) {
        // 三个指针 一个指针控制0的存放，一个指针用来从左到右遍历，遇到1不用管。一个指针用于控制2的存放
        int left = 0; // 控制0
        int mid = 0;
        int right = nums.length - 1; // 控制2
        // mid 如果只想的是 0，就交换left和mid指向的元素，并且left++  mid++
        // mid 如果只想的是 1，就直接mid++
        // mid 如果只想的是 2 ，就交换left和mid指向的元素，并且right--
        while (mid <= right) {
            int v = nums[mid];
            if (v == 0) {
                swap(nums, left++, mid++);
            } else if (v == 1) {
                mid++;
            } else {
                swap(nums,mid,right--);
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
