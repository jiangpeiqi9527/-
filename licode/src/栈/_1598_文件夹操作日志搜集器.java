package 栈;

import java.util.Stack;

public class _1598_文件夹操作日志搜集器 {
    public int minOperations(String[] logs) {
        int minStep = 0;
        int cdStep = 0;
//        Stack<String> stack = new Stack<>();
        for (int i = 0; i < logs.length; i++) {
            if ("../".equals(logs[i])) {
                if (cdStep != 0) {
                    cdStep--;
                    minStep--;
                }
//                if (!stack.isEmpty()){
//                    stack.pop();
//                    minStep--;
//                }
            } else if ("./".equals(logs[i])) {

            } else {
//                stack.push(logs[i]);
                cdStep++;
                minStep++;
            }
        }
        return minStep;
    }
}
