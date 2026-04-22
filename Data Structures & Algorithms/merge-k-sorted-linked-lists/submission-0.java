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
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode h1=l1;
        ListNode h2=l2;

        ListNode temp= new ListNode(-1);
        ListNode thead=temp;

        while(h1!=null&&h2!=null){
            if(h1.val<=h2.val){
                temp.next=h1;
                h1=h1.next;
            } else{
                temp.next=h2;
                h2=h2.next;
            }

            temp=temp.next;
        }

        if(h1!=null){
            temp.next=h1;
        }

        if(h2!=null){
            temp.next=h2;
        }

        return thead.next;


    }
    public ListNode mergeKLists(ListNode[] li) {
        int n=li.length;
        if(n==0) return null;
        if(n==1) return li[0];

        for(int i=1;i<n;i++){
            li[0]=merge(li[0],li[i]);
        }
        return li[0]; 
    }
}