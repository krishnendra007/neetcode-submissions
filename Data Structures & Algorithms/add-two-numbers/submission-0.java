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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode head=node;
        int carry=0;

        while(l1!=null||l2!=null){
            int value=0;
            if(l1!=null){
                value+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                value+=l2.val;
                l2=l2.next;
            }
            value+=carry;
            carry=value/10;
            node.next=new ListNode(value%10);
            node=node.next;
        }

        if(carry>0){
            node.next=new ListNode(carry);
        }

        return head.next;
    }
}