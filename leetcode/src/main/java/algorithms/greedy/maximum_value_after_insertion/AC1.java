package algorithms.greedy.maximum_value_after_insertion;

/**
 * @ClassName: AC1
 * @Description: 1881. 插入后的最大值
 * @Author: 琦玉
 * @Date: 2022年08月01日 17:38:51
 */
public class AC1 {

    /**
     * 1881. 插入后的最大值
     * 给你一个非常大的整数 n 和一个整数数字 x ，大整数 n 用一个字符串表示。n 中每一位数字和数字 x 都处于闭区间 [1, 9] 中，且 n 可能表示一个 负数 。
     * <p>
     * 你打算通过在 n 的十进制表示的任意位置插入 x 来 最大化 n 的 数值 ​​​​​​。但 不能 在负号的左边插入 x 。
     * <p>
     * 例如，如果 n = 73 且 x = 6 ，那么最佳方案是将 6 插入 7 和 3 之间，使 n = 763 。
     * 如果 n = -55 且 x = 2 ，那么最佳方案是将 2 插在第一个 5 之前，使 n = -255 。
     * 返回插入操作后，用字符串表示的 n 的最大值。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = "99", x = 9
     * 输出："999"
     * 解释：不管在哪里插入 9 ，结果都是相同的。
     * 示例 2：
     * <p>
     * 输入：n = "-13", x = 2
     * 输出："-123"
     * 解释：向 n 中插入 x 可以得到 -213、-123 或者 -132 ，三者中最大的是 -123 。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= n.length <= 10^5
     * 1 <= x <= 9
     * n​​​ 中每一位的数字都在闭区间 [1, 9] 中。
     * n 代表一个有效的整数。
     * 当 n 表示负数时，将会以字符 '-' 开始。
     */
    static class Solution {
        public static String maxValue(String n, int x) {
            int p = 0;
            StringBuilder ans = new StringBuilder(n);
            int X = x + '0';
            int len = n.length();
            if (n.charAt(0) == '-') {
                p++;
                while (p < len) {
                    if (ans.charAt(p) > X) {
                        break;
                    }
                    p++;
                }
            } else {
                while (p < len) {
                    if (ans.charAt(p) < X) {
                        break;
                    }
                    p++;
                }
            }
            return ans.insert(p, x).toString();
        }

        public static void main(String[] args) {
            System.out.println("4699757879438632651173569913153377".equals(maxValue("469975787943862651173569913153377", 3)));
        }
    }
}
