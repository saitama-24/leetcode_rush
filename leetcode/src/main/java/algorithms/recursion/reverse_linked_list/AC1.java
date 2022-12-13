package algorithms.recursion.reverse_linked_list;

/**
 * @author wangzhenjie
 * @version 1.0
 * @date 2022/12/13 14:31
 * @className: AC1
 * @description: // 206. 反转链表
 */
public class AC1 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    /**
     * 206. 反转链表
     * 简单
     * 2.9K
     * 相关企业
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     *
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     * 示例 2：
     *
     *
     * 输入：head = [1,2]
     * 输出：[2,1]
     * 示例 3：
     *
     * 输入：head = []
     * 输出：[]
     *
     *
     * 提示：
     *
     * 链表中节点的数目范围是 [0, 5000]
     * -5000 <= Node.val <= 5000
     *
     *
     * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
     */
    static class Solution {
        public static ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode node = reverseList(head.next);
            // head节点的next节点的next指向head节点
            head.next.next = head;
            // head节点的next节点指向null
            head.next = null;
            return node;
        }
    }
}
