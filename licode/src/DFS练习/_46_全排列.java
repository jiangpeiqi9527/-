package DFS练习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _46_全排列 {

    private List<List<Integer>> results;

    private int[] nums;
    /** 用来保存每一层选择的数字 */
    private int[] result;
    /** 用来标记nums中的数字是否被使用过了 */
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        results = new ArrayList<>();
        if (nums.length == 0) return results;
        this.nums = nums;
        used = new boolean[nums.length];
        result = new int[nums.length];
        dfs(0);
        return results;
    }

    private void dfs(int i) {
        if (i == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int value : result) {
                list.add(value);
            }
            results.add(list);
            return;
        }

        for (int j = 0; j < used.length; j++) {
            if (used[j]) continue;
            used[j] = true;
            result[i] = nums[j];
            dfs(i + 1);
            used[j] =false;
        }
    }
}
