package 热门;

import java.util.HashMap;
import java.util.Map;

public class _1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    // [begin,end)
//    private void quickSort(int[] nums, int begin, int end) {
//        if (end - begin < 2) return;
//        int mid = pivotIndex(nums, begin, end);
//        quickSort(nums, begin, mid);
//        quickSort(nums, mid + 1, end);
//    }
//
//    private int pivotIndex(int[] nums, int begin, int end) {
//        int temp = nums[begin];
//        end = end - 1;
//
//        while (begin < end) {
//            // <--
//            while (begin < end) {
//                if (nums[end] > temp) {
//                    end--;
//                } else {
//                    nums[begin++] = nums[end];
//                    break;
//                }
//            }
//
//            // -->
//            while (begin < end) {
//                if (nums[begin] < temp) {
//                    begin++;
//                } else {
//                    nums[end--] = nums[begin];
//                    break;
//                }
//            }
//        }
//        nums[begin] = temp;
//        return begin;
//    }
}
