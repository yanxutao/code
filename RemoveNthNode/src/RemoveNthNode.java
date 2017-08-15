/**
 * Created by yanxutao on 7/11/17.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class RemoveNthNode {

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        int length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        if (n == length) {
            return head.next;
        }
        int i = 1;
        ListNode n1 = head;
        ListNode n2 = head.next;
        while (n2 != null) {
            if (n + i == length + 1) {
                n1.next = n2.next;
                break;
            }
            i++;
            n1 = n2;
            n2 = n2.next;
        }

        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode fast = start;
        ListNode slow = start;
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }

}
