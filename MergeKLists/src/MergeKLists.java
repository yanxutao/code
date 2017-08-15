/**
 * Created by yanxutao on 7/16/17.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class MergeKLists {

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }

        if (l1 != null) {
            tmp.next = l1;
        } else {
            tmp.next = l2;
        }

        return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        int count = lists.length;

        if (count == 0) {
            return null;
        }

        while (count > 1) {
            for (int i = 0; i < count / 2; i++) {
                lists[i] = merge2Lists(lists[i], lists[count - 1 - i]);
            }
            count = count / 2 + count % 2;
        }

        return lists[0];
    }

}
