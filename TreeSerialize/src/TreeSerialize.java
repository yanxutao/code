import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yanxutao on 8/5/17.
 */


public class TreeSerialize {

    String Serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode tn = q.remove();

            sb.append(tn.val);

            if (tn.left != null) {
                sb.append('Y');
                q.add(tn.left);
            } else {
                sb.append('N');
            }

            if (tn.right != null) {
                sb.append('Y');
                q.add(tn.right);
            } else {
                sb.append('N');
            }
        }

        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        Queue<TreeNode> q1 = new LinkedList<>();

        int n = str.length();
        int val = 0;
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                val = val * 10 + (c - '0');
            } else {
                TreeNode tn = new TreeNode(val);
                q1.add(tn);
                val = 0;
                i++;
            }
        }

        TreeNode root = q1.remove();

        Queue<TreeNode> q2 = new LinkedList<>();
        q2.add(root);

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);

            if (c >= '0' && c <= '9') {
                continue;
            }

            TreeNode tmp = q2.remove();

            if (c == 'Y') {
                tmp.left = q1.remove();
                q2.add(tmp.left);
            }

            i++;
            c = str.charAt(i);

            if (c == 'Y') {
                tmp.right = q1.remove();
                q2.add(tmp.right);
            }
        }

        return root;
    }

    private void preTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preTraversal(root.left);
        preTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.right = n6;

        TreeSerialize ts = new TreeSerialize();
        String serialize = ts.Serialize(n1);
        System.out.println(serialize);

        TreeNode root = ts.Deserialize(serialize);
        ts.preTraversal(root);
        System.out.println();
    }

}
