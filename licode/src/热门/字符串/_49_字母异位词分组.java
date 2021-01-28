package 热门.字符串;

import java.util.*;

public class _49_字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] arr = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                arr[strs[i].charAt(j) - 97]++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (arr[j] != 0) {
                    sb.append(j + 97).append(arr[j]);
                }
            }
            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(strs[i]);
            map.put(sb.toString(),list);
        }
        return new ArrayList<>(map.values());
    }
}
