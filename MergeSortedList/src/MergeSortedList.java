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

public class MergeSortedList {

     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
          ListNode head = new ListNode(0);
          ListNode t = head;
          while (l1 != null && l2 != null) {
               if (l1.val < l2.val) {
                    t.next = l1;
                    l1 = l1.next;
               } else {
                    t.next = l2;
                    l2 = l2.next;
               }
               t = t.next;
          }
          if (l1 != null) {
               t.next = l1;
          } else if (l2 != null) {
               t.next = l2;
          }
          return head.next;
     }

}
