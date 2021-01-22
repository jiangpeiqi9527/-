package 字符串;

import java.util.HashMap;
import java.util.Map;

public class _3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        char[] chars = s.toCharArray();
        if (chars.length == 0) return 0;
        // 存储这个字符上一次出现的位置
        Map<Character, Integer> map = new HashMap<>();
        map.put(chars[0],0);
        int max = 1;
        int leftIndex = 0; // 从leftIndex到i-1最长的无重复连续子串
        for (int i = 1; i < chars.length; i++) {
            int shangyicichuxiandedifang = map.getOrDefault(chars[i], -1);
            if (shangyicichuxiandedifang >= leftIndex) {
                leftIndex = shangyicichuxiandedifang + 1;
            }
            map.put(chars[i],i);
            max = Math.max(max,i - leftIndex + 1);
        }
        return max;
    }

    // 如果接受的字符串只是小写字母，可以这样优化
    public int lengthOfLongestSubstring2(String s) {
        if (s == null) return 0;
        char[] chars = s.toCharArray();
        if (chars.length == 0) return 0;
        // 存储这个字符上一次出现的位置
        int[] arr = new int[26];
        arr[chars[0] - 'a'] = 0;
        int max = 1;
        int leftIndex = 0; // 从leftIndex到i-1最长的无重复连续子串
        for (int i = 1; i < chars.length; i++) {
            int shangyicichuxiandedifang = arr[chars[i] - 'a'];
            if (shangyicichuxiandedifang >= leftIndex) {
                leftIndex = shangyicichuxiandedifang + 1;
            }
            arr[chars[i] - 'a'] = i;
            max = Math.max(max,i - leftIndex + 1);
        }
        return max;
    }

    // 如果接受的字符串只是asc码表中的字符组成，可以这样优化
    public int lengthOfLongestSubstring3(String s) {
        if (s == null) return 0;
        char[] chars = s.toCharArray();
        if (chars.length == 0) return 0;
        // 存储这个字符上一次出现的位置
        int[] arr = new int[128];
        for (int i = 0; i < 128; i++) {
            arr[i] = -1;
        }
        arr[chars[0]] = 0;
        int max = 1;
        int leftIndex = 0; // 从leftIndex到i-1最长的无重复连续子串
        for (int i = 1; i < chars.length; i++) {
            int shangyicichuxiandedifang = arr[chars[i]];
            if (shangyicichuxiandedifang >= leftIndex) {
                leftIndex = shangyicichuxiandedifang + 1;
            }
            arr[chars[i]] = i;
            max = Math.max(max,i - leftIndex + 1);
        }
        return max;
    }
}
