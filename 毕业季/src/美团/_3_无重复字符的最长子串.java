package 美团;

import java.util.HashMap;
import java.util.Map;

public class _3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        map.put(arr[0], 0);
        int len = 1;
        int maxLen = 1;

        for (int i = 1; i < arr.length; i++) {
            int prevIndex = map.getOrDefault(arr[i], -1);
            if (prevIndex >= (i - 1 - len + 1)) {
                len = i - (prevIndex + 1) + 1;
            } else {
                len++;
            }
            map.put(arr[i],i);
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
