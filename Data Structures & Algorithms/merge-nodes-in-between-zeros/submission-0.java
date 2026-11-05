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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode resHead = dummy;

        while(head != null){
            if(head.val != 0){
                int sum = head.val;
                head = head.next;
                while(head.val != 0){
                    sum += head.val;
                    head = head.next;
                }
                resHead.next = new ListNode(sum);
                resHead = resHead.next;
            }else{
                head = head.next;
            }
        }

        return dummy.next;
    }
}
