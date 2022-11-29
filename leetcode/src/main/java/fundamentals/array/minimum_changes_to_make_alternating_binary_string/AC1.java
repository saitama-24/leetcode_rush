package fundamentals.array.minimum_changes_to_make_alternating_binary_string;

/**
 * @author wangzhenjie
 * @version 1.0
 * @date 2022/11/29 20:49
 * @className: AC1
 * @description: // 1758. 生成交替二进制字符串的最少操作数
 */
public class AC1 {

    /**
     * 1758. 生成交替二进制字符串的最少操作数
     * 简单
     * 86
     * 相关企业
     * 给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
     *
     * 交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
     *
     * 返回使 s 变成 交替字符串 所需的 最少 操作数。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "0100"
     * 输出：1
     * 解释：如果将最后一个字符变为 '1' ，s 就变成 "0101" ，即符合交替字符串定义。
     * 示例 2：
     *
     * 输入：s = "10"
     * 输出：0
     * 解释：s 已经是交替字符串。
     * 示例 3：
     *
     * 输入：s = "1111"
     * 输出：2
     * 解释：需要 2 步操作得到 "0101" 或 "1010" 。
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 10^4
     * s[i] 是 '0' 或 '1'
     */
    static class Solution {
        public static int minOperations(String s) {
            int res = 0;
            // 这道题的思路主要是，以 0 开头交替的变更次数加上以 1 开头交替的变更次数等于字符串的长度。
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if ((i & 1) == 1) {
                    if (c == '0') {
                        res++;
                    }
                } else {
                    if (c == '1') {
                        res++;
                    }
                }
            }
            return Math.min(res, s.length() - res);
        }
    }
}
