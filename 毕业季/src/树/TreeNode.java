package 树;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      TreeNode(int x) { val = x; }

      public static TreeNode string2Tree(Integer[] nums) {
            if (nums.length == 0) {
                  return null;
            }
            TreeNode head = new TreeNode(nums[0]);
            LinkedList<TreeNode> subTree = new LinkedList<>();
            subTree.push(head);
            for (int i = 1; i < nums.length; i++) {
                  if (!subTree.isEmpty()) {
                        TreeNode cur = subTree.pop();
                        if (nums[i] != null) {
                              cur.left = new TreeNode(nums[i]);
                              subTree.add(cur.left);
                        }
                        i++;
                        if (i >= nums.length) {
                              break;
                        }
                        if (nums[i] != null) {
                              cur.right = new TreeNode(nums[i]);
                              subTree.add(cur.right);
                        }

                  } else {
                        break;
                  }
            }
            return head;
      }
}
