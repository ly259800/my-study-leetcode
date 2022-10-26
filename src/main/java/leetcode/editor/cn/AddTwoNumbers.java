package leetcode.editor.cn;
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 👍 7489 👎 0

import java.util.Objects;

/**
 * @author [leiyong]
 * 2022-02-16 15:36:18
 */
public class AddTwoNumbers{
  public static void main(String[] args) {
      int[] x = {2,4,3};
      ListNode listNode1 = new ListNode().createLinkedList(x);
      int[] y = {5,6,4};
      ListNode listNode2 = new ListNode().createLinkedList(y);
      Solution solution = new Solution();
      ListNode listNode = solution.addTwoNumbers(listNode1, listNode2);
      listNode.printLinkedList(listNode);
  }
}
//leetcode submit region begin(Prohibit modification and deletion)
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1,l2,0);
    }

    public ListNode add(ListNode l1, ListNode l2 ,int childVal) {
        ListNode child = new ListNode(childVal);
        if(l1 == null && l2 == null){
            if(childVal == 0){
                return null;
            } else {
                return child;
            }
        }
        int val = 0;
        if (l1 != null && l2 != null) {
            val = l1.val+l2.val+childVal;
        } else if(l1 == null){
            val = l2.val+childVal;
        } else if(l2 == null ){
            val = l1.val+childVal;
        }
        if(val>9){
            child.val = val%10;
            child.next = add(Objects.isNull(l1)?null:l1.next,Objects.isNull(l2)?null:l2.next,val/10);
        } else {
            child.val = val;
            child.next = add(Objects.isNull(l1)?null:l1.next,Objects.isNull(l2)?null:l2.next,0);
        }
        return child;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    static ListNode createLinkedList(int[] arr) {//将输入的数组输入到链表中
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {//过程
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    static void printLinkedList(ListNode head){//将链表结果打印
        ListNode current =  head;
        while (current!=null){
            System.out.printf("%d -> ",current.val);
            current = current.next;
        }
        System.out.println("NULL");
    }
 }