package 热门;

import java.beans.BeanInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        quickSort(nums, 0, nums.length);
        int begin = 0;
        for (; begin < nums.length - 2; begin++) {


            if (begin == 0 || (begin > 0 && nums[begin] != nums[begin - 1])){
                int left = begin + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int total = nums[begin] + nums[left] + nums[right];
                    if (total > 0) {
                        while (left < right) {
                            if (nums[right] == nums[right - 1]) {
                                right--;
                            } else {
                                right--;
                                break;
                            }
                        }
                    } else if (total < 0) {
                        while (left < right) {
                            if (nums[left] == nums[left + 1]) {
                                left++;
                            } else {
                                left++;
                                break;
                            }
                        }
                    } else {
                        result.add(Arrays.asList(nums[begin],nums[left],nums[right]));
                        while (left < right) {
                            if (nums[left] == nums[left + 1]) {
                                left++;
                            } else {
                                left++;
                                break;
                            }
                        }
                        while (left < right) {
                            if (nums[right] == nums[right - 1]) {
                                right--;
                            } else {
                                right--;
                                break;
                            }
                        }
                    }}

            }
        }
        return result;
    }

    // [begin,end)
    private void quickSort(int[] nums, int begin, int end) {
        if (end - begin < 2) return;
        int mid = pivotIndex(nums, begin, end);
        quickSort(nums, begin, mid);
        quickSort(nums, mid + 1, end);
    }

    private int pivotIndex(int[] nums, int begin, int end) {
        int temp = nums[begin];
        end = end - 1;

        while (begin < end) {
            // <--
            while (begin < end) {
                if (nums[end] > temp) {
                    end--;
                } else {
                    nums[begin++] = nums[end];
                    break;
                }
            }

            // -->
            while (begin < end) {
                if (nums[begin] < temp) {
                    begin++;
                } else {
                    nums[end--] = nums[begin];
                    break;
                }
            }
        }
        nums[begin] = temp;
        return begin;
    }
}
