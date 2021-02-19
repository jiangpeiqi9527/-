package 栈;

import java.util.ArrayList;
import java.util.List;

public class _1441_用栈操作构建数组 {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int hasComplete = 0;
        int lastNum = target[target.length - 1];
        for (int i = 0; i <= lastNum; i++) {
            if (i == target[hasComplete]) {
                res.add("Push");
                hasComplete++;
            } else {
                res.add("Push");
                res.add("Pop");
            }
        }
        return res;
    }
}
