package 树;

public class _114_二叉树展开为链表 {
    public void flatten(TreeNode root) {
        TreeNode temp = root;
        while (temp != null) {
            // 如果左子树为null，则直接进入右子树环节
            if (temp.left == null) {
                temp = temp.right;
            }else {
                TreeNode pre =  temp.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = temp.right;
                temp.right = temp.left;
                temp.left = null;
                temp = temp.right;
            }
        }
    }
//    public void flatten(TreeNode root) {
//        while (root != null) {
//            //左子树为 null，直接考虑下一个节点
//            if (root.left == null) {
//                root = root.right;
//            } else {
//                // 找左子树最右边的节点
//                TreeNode pre = root.left;
//                while (pre.right != null) {
//                    pre = pre.right;
//                }
//                //将原来的右子树接到左子树的最右边节点
//                pre.right = root.right;
//                // 将左子树插入到右子树的地方
//                root.right = root.left;
//                root.left = null;
//                // 考虑下一个节点
//                root = root.right;
//            }
//        }
//    }

}
