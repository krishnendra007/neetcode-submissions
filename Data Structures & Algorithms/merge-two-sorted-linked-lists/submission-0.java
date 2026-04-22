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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1=list1,head2=list2;
        ListNode value= new ListNode(-1);
        ListNode headval=value;

        while(head1!=null&&head2!=null){
            if(head1.val<=head2.val){
                value.next=head1;
                head1=head1.next;
              
            } else{
                value.next=head2;
                head2=head2.next;
            }
            value=value.next;
        }

            if(head1!=null){
                value.next=head1;
            }
            if(head2!=null){
                value.next=head2;
            }

        return headval.next;
        
    }
}