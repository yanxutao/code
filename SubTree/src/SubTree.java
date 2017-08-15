/**
 * Created by yanxutao on 7/29/17.
 */

public class SubTree {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean IsSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.val == root2.val) {
            if (IsSubtree(root1.left, root2.left)
                    && IsSubtree(root1.right, root2.right)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return false;
        }

        return IsSubtree(root1, root2)
                || HasSubtree(root1.left, root2)
                || HasSubtree(root1.right, root2);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);

        TreeNode tmp = new TreeNode(8);
        root1.left = tmp;
        tmp = new TreeNode(7);
        root1.right = tmp;

        tmp = new TreeNode(9);
        root1.left.left = tmp;
        tmp = new TreeNode(2);
        root1.left.right = tmp;

        tmp = new TreeNode(4);
        root1.left.right.left = tmp;
        tmp = new TreeNode(7);
        root1.left.right.right = tmp;

        TreeNode root2 = new TreeNode(8);

        tmp = new TreeNode(9);
        root1.left = tmp;
        tmp = new TreeNode(2);
        root1.right = tmp;

        SubTree st = new SubTree();
        System.out.println(st.HasSubtree(root1, root2));
    }

}
