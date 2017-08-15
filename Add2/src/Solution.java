/**
 * Created by yanxutao on 2/12/17.
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode cur = head;

        int carry = 0;
        while (t1 != null || t2 != null) {
            int x = (t1 != null) ? t1.val : 0;
            int y = (t2 != null) ? t2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (t1 != null) {
                t1 = t1.next;
            }
            if (t2 != null) {
                t2 = t2.next;
            }
        }

        if (carry > 0) {
            cur.next = new ListNode(carry);
        }

        return head.next;
    }

}
