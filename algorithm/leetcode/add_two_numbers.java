/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode preHead = new ListNode(-1);
    	ListNode pre = preHead;
    	int carry = 0;
    	int value,a,b;
    	while(l1!=null || l2!=null){
    		a = l1==null?0:l1.val;
    		b = l2==null?0:l2.val;
    		value = a+b+carry;
    		carry = value / 10;
    		value %= 10;
    		pre.next = new ListNode(value);
    		l1 = l1==null?null:l1.next;
    		l2 = l2==null?null:l2.next;
    		pre = pre.next;
    	}
    	if(carry == 1)
    		pre.next = new ListNode(1);
    	return preHead.next;
    }
}