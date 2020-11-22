package com.jxz;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main02 {
    public String removeDuplicatedChars (String str) {
        // write code here
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (Character ch : set) {
            sb.append(ch);
        }
        return sb.toString();

    }
}
