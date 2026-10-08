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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();

        // Add all nodes from listA to the set
        ListNode currA = headA;
        while (currA != null) {
            visited.add(currA);
            currA = currA.next;
        }

        // Find the first node in listB that exists in the set
        ListNode currB = headB;
        while (currB != null) {
            if (visited.contains(currB)) {
                return currB;
            }
            currB = currB.next;
        }

        return null;
    }
}