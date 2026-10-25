class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode before = dummy;

        for (int i = 1; i < left; i++) {
            before = before.next;
        }

        ListNode curr = before.next;
        ListNode tail = curr;

        for (int i = 0; i < right - left + 1; i++) {
            curr = curr.next;
        }

        ListNode prev = curr;
        curr = tail;

        for (int i = 0; i < right - left + 1; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        before.next = prev;

        return dummy.next;
    }
}