//https://leetcode.com/problems/add-two-numbers/
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        
        ListNode *head, *tempNode, *cur;
        int carry=0;
        int sum = 0;
        int flag = 1;
        while(l1!=NULL && l2!=NULL) {
            tempNode = new ListNode();
            if (flag) {
                head = tempNode;
                cur = tempNode;
                flag = 0;
            } else {
                cur->next = tempNode;
                cur = cur->next;
            }
            sum = l1->val + l2->val + carry;
            if( sum > 9){
                sum = sum%10;
                carry =1;
            } else {
                carry = 0;
            }
            tempNode->val = sum;

            l1 = l1->next;
            l2 = l2->next;
        }
        
        while(l1!=NULL) {
            tempNode = new ListNode();
            if (flag) {
                head = tempNode;
                cur = tempNode;
                flag = 0;
            } else {
                cur->next = tempNode;
                cur = cur->next;
            }
            sum = l1->val + carry;
            if( sum > 9){
                sum = sum%10;
                carry =1;
            } else {
                carry = 0;
            }
            tempNode->val = sum;
             l1 = l1->next;
        }
        
        while(l2!=NULL) {
            tempNode = new ListNode();
            if (flag) {
                head = tempNode;
                cur = tempNode;
                flag = 0;
            } else {
                cur->next = tempNode;
                cur = cur->next;
            }
            sum = l2->val + carry;
            if( sum > 9){
                sum = sum%10;
                carry =1;
            } else {
                carry = 0;
            }
            tempNode->val = sum;
             l2 = l2->next;
        }
        
        if(carry){
            tempNode = new ListNode();
            cur->next = tempNode;
            cur = cur->next;
            tempNode->val = carry;
        }
        
        return head;
        
    }
};