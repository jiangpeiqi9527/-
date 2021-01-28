package 热门.字符串;

import java.util.HashMap;
import java.util.Map;

public class _242_有效的字母异位词 {
    // nb方法
    public boolean isAnagram1(String s, String t) {
        if (s == null) return t != null ? false : true;
        if (t == null) return false;
        if (s.length() != t.length()) return false;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 97]++;
            arr[t.charAt(i) - 97]--;
        }
        for (int i : arr) {
            if (i != 0) return false;
        }
        return true;
    }

    // lj方法
    public boolean isAnagram2(String s, String t) {
        if (s == null) return t != null ? false : true;
        if (t == null) return s != null ? false : true;
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
                if (map.get(c) < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
