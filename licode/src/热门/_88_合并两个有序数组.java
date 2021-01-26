package 热门;

import java.util.Arrays;

public class _88_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 从后往前合并两个数组
        for (int i = m + n - 1; i >= 0 && m >= 1 && n >= 1; i--) {
            if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[i] = nums1[m - 1];
                m--;
            }else {
                nums1[i] = nums2[n - 1];
                n--;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            nums1[i] = nums2[i];
        }
    }
}
