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

public class ReverseNodesInK {

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode n1 = head;
        ListNode n2 = n1.next;
        while (n2 != null) {
            ListNode tmp = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = tmp;
        }

        head.next = null;
        return n1;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode lastTail = new ListNode(0);

        boolean flag = false;

        ListNode first = head;
        ListNode last;

        int count = 0;
        ListNode tmp = head;
        while (tmp != null) {
            count++;
            if (count == k) {
                last = tmp;
                tmp = tmp.next;
                last.next = null;
                lastTail.next = reverseList(first);
                if (flag == false) {
                    head = lastTail.next;
                    flag = true;
                }
                lastTail = first;
                first = tmp;
                count = 0;
            } else {
                tmp = tmp.next;
            }
        }

        if (count < k) {
            lastTail.next = first;
        }

        if (flag == true) {
            return head;
        } else {
            return lastTail.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        for (int i = 0; i < 5; i++) {
            tmp.next = new ListNode(i + 1);
            tmp = tmp.next;
        }
        ReverseNodesInK rnik = new ReverseNodesInK();
//        head.next = rnik.reverseList(head.next);
        head.next = rnik.reverseKGroup(head.next, 2);
        tmp = head.next;
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

}
