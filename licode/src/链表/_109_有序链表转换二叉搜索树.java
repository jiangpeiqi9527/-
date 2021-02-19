package 链表;

import java.util.ArrayList;
import java.util.List;

public class _109_有序链表转换二叉搜索树 {
    private List<Integer> list = new ArrayList<>();
    public TreeNode sortedListToBST(ListNode head) {
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Integer[] arr = list.toArray(new Integer[]{});
        TreeNode BBST = buildBBST(arr,0,arr.length);
        return BBST;
    }

    private TreeNode buildBBST(Integer[] arr, int begin, int end) {
        if (begin == end) return null;
        int midIndex = (begin + end) >> 1;
        TreeNode root = new TreeNode(arr[midIndex]);
        root.left = buildBBST(arr,begin,midIndex);
        root.right = buildBBST(arr,midIndex + 1,end);
        return root;
    }


}





   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }