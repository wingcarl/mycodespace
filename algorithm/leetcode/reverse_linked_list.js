/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {
    if(head === null || head.next ===null)
        return head;
    var preHead = new ListNode(-1);
    preHead.next = head;
    var pre = head;
    var cur = head.next;
    while(cur !== null ){
        pre.next = cur.next;
        cur.next = preHead.next;
        preHead.next = cur;
        cur = pre.next;
    }
    return preHead.next;
};