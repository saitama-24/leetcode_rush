package algorithms.greedy.minimum_time_to_make_rope_colorful;

/**
 * @ClassName: AC1
 * @Description: 1578. 使绳子变成彩色的最短时间
 * @Author: 琦玉
 * @Date: 2022年06月09日 10:47:44
 */
public class AC1 {

    /**
     * 1578. 使绳子变成彩色的最短时间
     * Alice 把 n 个气球排列在一根绳子上。给你一个下标从 0 开始的字符串 colors ，其中 colors[i] 是第 i 个气球的颜色。
     *
     * Alice 想要把绳子装扮成 彩色 ，且她不希望两个连续的气球涂着相同的颜色，所以她喊来 Bob 帮忙。Bob 可以从绳子上移除一些气球使绳子变成 彩色 。给你一个下标从 0 开始的整数数组 neededTime ，其中 neededTime[i] 是 Bob 从绳子上移除第 i 个气球需要的时间（以秒为单位）。
     *
     * 返回 Bob 使绳子变成 彩色 需要的 最少时间 。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：colors = "abaac", neededTime = [1,2,3,4,5]
     * 输出：3
     * 解释：在上图中，'a' 是蓝色，'b' 是红色且 'c' 是绿色。
     * Bob 可以移除下标 2 的蓝色气球。这将花费 3 秒。
     * 移除后，不存在两个连续的气球涂着相同的颜色。总时间 = 3 。
     * 示例 2：
     *
     *
     * 输入：colors = "abc", neededTime = [1,2,3]
     * 输出：0
     * 解释：绳子已经是彩色的，Bob 不需要从绳子上移除任何气球。
     * 示例 3：
     *
     *
     * 输入：colors = "aabaa", neededTime = [1,2,3,4,1]
     * 输出：2
     * 解释：Bob 会移除下标 0 和下标 4 处的气球。这两个气球各需要 1 秒来移除。
     * 移除后，不存在两个连续的气球涂着相同的颜色。总时间 = 1 + 1 = 2 。
     *
     *
     * 提示：
     *
     * n == colors.length == neededTime.length
     * 1 <= n <= 10^5
     * 1 <= neededTime[i] <= 10^4
     * colors 仅由小写英文字母组成
     */
    static class Solution {
        public static int minCost(String colors, int[] neededTime) {
            int len = colors.length();
            char prev = colors.charAt(0);
            int from = 0;
            int cost = 0;
            for (int i = 1; i < len; i++) {
                if (colors.charAt(i) != prev) {
                    if (i - from > 1) {
                        cost += removeAllTime(neededTime, from, i);
                    }
                    from = i;
                    prev = colors.charAt(i);
                }
            }
            if (from != len - 1) {
                // 最后需要判断尾部是否是相同颜色区段
                cost += removeAllTime(neededTime, from, len);
            }
            return cost;
        }

        private static int removeAllTime(int[] neededTime, int from, int end) {
            int max = neededTime[from];
            int sum = 0;
            for (int i = from; i < end; i++) {
                sum += neededTime[i];
                max = Math.max(neededTime[i], max);
            }
            return sum - max;
        }

        public static void main(String[] args) {
            System.out.println(minCost("abc", new int[]{1,2,3}));
        }
    }
}
