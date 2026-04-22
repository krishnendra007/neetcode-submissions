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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next==null) return null;
        ListNode p1=head;

        for(int i=1;i<=n;i++){
            p1=p1.next;
        }

        if(p1==null) {
            return head.next;
        }

        ListNode p2=head;

        while(p1.next!=null){
            p1=p1.next;
            p2=p2.next;
        }

        p2.next=p2.next.next;
        return head;
    }
}
