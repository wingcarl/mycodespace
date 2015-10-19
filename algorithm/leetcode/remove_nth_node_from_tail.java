/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode pre = preHead;
        
        while(n > 0){
            head = head.next;
            n--;
        }
        while(head != null){
            pre = pre.next;
            head = head.next;
        }
        pre.next = pre.next.next;
        return preHead.next;
    }
}