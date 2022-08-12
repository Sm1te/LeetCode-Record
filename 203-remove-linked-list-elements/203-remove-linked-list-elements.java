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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;
        
        ListNode p = new ListNode(-1, head);
        ListNode prev = p, cur = head;
        while(cur != null){
            if(cur.val == val){
               prev.next = cur.next;
            }else{
                //精髓
                prev = cur;
            }
            cur = cur.next;
        }
        return p.next;
    }
}