/* https://leetcode.com/problems/palindrome-linked-list/ */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = head;
        ListNode end = head;
        while(end.next != null && end.next.next != null){
            mid = mid.next;
            end = end.next.next;
        }
        mid = mid.next;
        ListNode prev = null;
        ListNode next;
        while(mid != null){
            next = mid.next;
            mid.next = prev;
            if(next != null){
                prev = mid;
                mid = next;
            }
            else{
                break;
            }
        }
        while(mid != null){
            if(head.val != mid.val){
                return false;
            }
            head = head.next;
            mid = mid.next;
        }
        return true;
    }
}