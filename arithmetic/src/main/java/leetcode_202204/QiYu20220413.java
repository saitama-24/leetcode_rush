package leetcode_202204;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: QiYu20220413
 * @Description: QiYu20220413
 * @Author: 琦玉
 * @Date: 2022年04月13日 11:39:23
 */
public class QiYu20220413 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 876. 链表的中间结点
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     *
     * 如果有两个中间结点，则返回第二个中间结点。
     *
     *
     *
     * 示例 1：
     *
     * 输入：[1,2,3,4,5]
     * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
     * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
     * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
     * 示例 2：
     *
     * 输入：[1,2,3,4,5,6]
     * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
     * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
     *
     *
     * 提示：
     *
     * 给定链表的结点数介于 1 和 100 之间。
     */
    static class Solution {
        public static ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }

    /**
     * 19. 删除链表的倒数第 N 个结点
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * 示例 2：
     *
     * 输入：head = [1], n = 1
     * 输出：[]
     * 示例 3：
     *
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     *
     *
     * 提示：
     *
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     *
     *
     * 进阶：你能尝试使用一趟扫描实现吗？
     */
    static class Solution1 {
        public static ListNode removeNthFromEnd(ListNode head, int n) {
            if (null == head || null == head.next) {
                return null;
            }
            ListNode fast = head;
            for (int i = 0; i < n; i++) {
                // fast 步进n个节点
                fast = fast.next;
            }

            if (fast == null) {
                // 说明要删除的是头节点
                head = head.next;
                return head;
            }
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return head;
        }
    }

    /**
     * 3. 无重复字符的最长子串
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     *
     *
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     *
     * 提示：
     *
     * 0 <= s.length <= 5 * 10^4
     * s 由英文字母、数字、符号和空格组成
     */
    static class Solution2 {
        // 指针滑动
        public static int lengthOfLongestSubstring(String s) {
            if (null == s) {
                return 0;
            }
            if (s.length() <= 1) {
                return s.length();
            }
            int slow = 0;
            int fast = 1;
            char[] chars = s.toCharArray();
            Set<Character> set = new HashSet<>();
            // 存储当前序列段字符
            set.add(chars[slow]);
            // 记录最大不重复次数
            int max = 0;
            while (fast < s.length()) {
                if (set.contains(chars[fast])) {
                    max = Math.max(max, set.size());
                    // 碰到重复的需要重新清空
                    set.clear();
                    slow++;
                    set.add(chars[slow]);
                    fast = slow + 1;
                } else {
                    set.add(chars[fast]);
                    fast++;
                }

            }
            max = Math.max(max, set.size());
            return max;
        }

        public static void main(String[] args) {
            System.out.println(lengthOfLongestSubstring("abcabcbb"));
        }
    }
}
