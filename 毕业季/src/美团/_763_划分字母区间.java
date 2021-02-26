package 美团;

import java.util.*;

public class _763_划分字母区间 {
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) return null;
        // 先得到每个字母最后出现的位置
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = S.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        List<Integer> res = new ArrayList<>();
        int begin = 0;
        int end = 0;
        while (begin < arr.length) {
            int temp = begin;
            end = map.get(arr[begin]);
            while (begin <= end) {
                end = Math.max(end, map.get(arr[begin]));
                begin++;
            }
            res.add(end - temp + 1);
        }

        return res;
    }
}
