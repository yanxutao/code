
import java.util.ArrayList;

/**
 * Created by yanxutao on 8/7/17.
 */

public class PrintBinaryTree {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (pRoot == null) {
            return ans;
        }

        ArrayList<TreeNode> cur = new ArrayList<>();
        cur.add(pRoot);

        boolean ltr = true;

        while (!cur.isEmpty()) {
            ArrayList<Integer> vals = new ArrayList<>();
            ArrayList<TreeNode> next = new ArrayList<>();

            for (int i = cur.size() - 1; i >= 0; i--) {
                TreeNode tmp = cur.get(i);

                vals.add(tmp.val);

                if (ltr == true) {
                    if (tmp.left != null) {
                        next.add(tmp.left);
                    }
                    if (tmp.right != null) {
                        next.add(tmp.right);
                    }
                } else {
                    if (tmp.right != null) {
                        next.add(tmp.right);
                    }
                    if (tmp.left != null) {
                        next.add(tmp.left);
                    }
                }
            }

            ltr = !ltr;
            ans.add(vals);
            cur = next;
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n7;
        n3.right = n6;

        PrintBinaryTree pbt = new PrintBinaryTree();
        ArrayList<ArrayList<Integer>> ans = pbt.Print(n1);

        for (int i = 0; i < ans.size(); i++) {
            ArrayList<Integer> list = ans.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
        }
    }
}
