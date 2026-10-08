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
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;

        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = dummy;

        while(right != null && right.next != null){
            left = left.next;
            right = right.next.next;
        }

        ListNode prev = null;
        ListNode curr = left.next;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode list1 = dummy.next;
        ListNode list2 = prev;

        while(list2 != null){
            if(list1.val != list2.val) return false;
            list1 = list1.next;
            list2 = list2.next;
        }

        return true;
    }
}