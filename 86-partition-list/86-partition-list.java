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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        while(head != null){
            if(head.val < x){
                dummy1.next = new ListNode(head.val);
                dummy1 = dummy1.next;
            }else{
                dummy2.next = new ListNode(head.val);
                dummy2 = dummy2.next;
            }
            head = head.next;
        }
        dummy1.next = p2.next;
        return p1.next;
    }
}