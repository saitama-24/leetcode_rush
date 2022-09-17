package common_data_structures.hash_table.largest_substring_between_two_equal_characters;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangzhenjie
 * @description 1624. 两个相同字符之间的最长子字符串
 * @date 2022-09-17 19:26:20
 */
public class AC1 {

    /**
     * 1624. 两个相同字符之间的最长子字符串
     * 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
     *
     * 子字符串 是字符串中的一个连续字符序列。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "aa"
     * 输出：0
     * 解释：最优的子字符串是两个 'a' 之间的空子字符串。
     * 示例 2：
     *
     * 输入：s = "abca"
     * 输出：2
     * 解释：最优的子字符串是 "bc" 。
     * 示例 3：
     *
     * 输入：s = "cbzxy"
     * 输出：-1
     * 解释：s 中不存在出现出现两次的字符，所以返回 -1 。
     * 示例 4：
     *
     * 输入：s = "cabbac"
     * 输出：4
     * 解释：最优的子字符串是 "abba" ，其他的非最优解包括 "bb" 和 "" 。
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 300
     * s 只含小写英文字母
     */
    static class Solution {
        public static int maxLengthBetweenEqualCharacters(String s) {
            Map<Character, Deque<Integer>> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                Deque<Integer> deque = map.get(s.charAt(i));
                if (deque == null) {
                    deque = new ArrayDeque<>();
                }
                deque.addLast(i);
                map.put(s.charAt(i), deque);
            }
            int max = -1;
            for (Map.Entry<Character, Deque<Integer>> entry : map.entrySet()) {
                Deque<Integer> deque = entry.getValue();
                if (deque.size() > 1) {
                    max = Math.max(max, deque.pollLast() - deque.pollFirst() - 1);
                }
            }
            return max;
        }

        public static void main(String[] args) {
            System.out.println(maxLengthBetweenEqualCharacters("cabbac"));
        }
    }
}
