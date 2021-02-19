package 树;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class _1022_从根到叶的二进制数之和 {
    private int res = 0;

    public int sumRootToLeaf1(TreeNode root) {
        preorder(root, 0);
        return res;
    }

    private void preorder(TreeNode root, int val) {
        if (root == null) {
            res += val;
            return;
        }
        int temp = (val << 1) + root.val;
        preorder(root.left, temp);
        preorder(root.right, temp);
    }


    List<Integer> list = new LinkedList<>();

    public int sumRootToLeaf2(TreeNode root) {
        dfs(root, 0, 0);
        int sum = 0;
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            sum += iterator.next();
//        }
        Integer[] arr = list.toArray(new Integer[]{});
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private void dfs(TreeNode root, int val, int cengshu) {
        if (root == null) {
            list.add(val);
            return;
        }
        int value = (int) (root.val * Math.pow(2, cengshu));
        dfs(root.left, val + value, cengshu + 1);
        dfs(root.right, val + value, cengshu + 1);
    }
}
