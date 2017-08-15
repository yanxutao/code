/**
 * Created by yanxutao on 7/17/17.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode first = head;
        if (first == null) {
            return first;
        }

        ListNode second = first.next;
        if (second == null) {
            return first;
        }

        first.next = swapPairs(second.next);
        second.next = first;

        return second;
    }

}
