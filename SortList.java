// https://leetcode.com/problems/sort-list/

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
    ListNode middleFind(ListNode start){
        ListNode fast=start, slow=start, prev=null;
        while(fast!= null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next=null;
        return slow;
    }
    ListNode merge(ListNode start1, ListNode start2){
        ListNode cur= null, start=null, end=null;
        
        if(start1.val<start2.val) {
            cur = start1;
            start1 = start1.next;
        } else {
            cur =  start2;
            start2 = start2.next;
        }
        
        start = cur;            
        
        while(start1 != null && start2!=null) {
            if(start1.val<start2.val) {
                cur.next = start1;
                start1= start1.next;
            } else {
                cur.next =  start2;
                start2 = start2.next;
            }
            cur = cur.next;
        }
        
        while(start1!=null)  {
            cur.next= start1;
            start1 = start1.next;
            cur = cur.next;
        }
        while(start2!=null) {
            cur.next = start2;
            start2 = start2.next;
            cur = cur.next;
        }
        
        return start;
    }
    ListNode MergeSort(ListNode start) {
        if (start == null || start.next == null)
            return start;
        ListNode middle = middleFind(start);
        ListNode L1 = MergeSort(start);
        ListNode L2 = MergeSort(middle);
        return merge(L1, L2);
    }
    
    public ListNode sortList(ListNode head) {
        return MergeSort(head);        
    }
}