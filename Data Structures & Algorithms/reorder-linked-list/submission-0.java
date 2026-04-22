/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null, current=head,next;

        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode slow=head, fast=head;

        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast= slow.next;
        slow.next=null;
        fast=reverseList(fast);
        slow=head;

        while(slow!=null&&fast!=null){
            ListNode sn=slow.next;
            ListNode fn=fast.next;

            slow.next=fast;
            slow.next.next=sn;
            fast=fn;
            slow=sn;
        }
    }
}