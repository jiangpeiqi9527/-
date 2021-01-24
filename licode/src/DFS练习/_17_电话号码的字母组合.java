package DFS练习;

import java.util.ArrayList;
import java.util.List;

public class _17_电话号码的字母组合 {

    private static final char[][] letterArray = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    // 用来存储digits的字符数组
    private char[] chars;

    // 存储每一种情况
    private char[] example;

    // 最终结果
    private List<String> result;

    public List<String> letterCombinations(String digits) {
        if (digits == null) return null;
        result = new ArrayList<>();
        chars = digits.toCharArray();
        if (chars.length == 0) return result;
        example = new char[chars.length];
        dfs(0);
        return result;
    }

    private void dfs(int i) {
        // 如果已经到了最后一层
        if (i == chars.length) {
            result.add(new String(example));
            return;
        }
        // 列举这一层可以选择的所有字母
        char[] letters = letterArray[chars[i] - '2'];
        for (char letter : letters) {
            example[i] = letter;
            dfs(i + 1);
        }
    }


}
