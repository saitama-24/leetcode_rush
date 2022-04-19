package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: dp20220419
 * @Description: dp20220419
 * @Author: 琦玉
 * @Date: 2022年04月19日 15:48:49
 */
public class dp20220419 {

    /**
     * 1137. 第 N 个泰波那契数
     * 泰波那契序列 Tn 定义如下：
     *
     * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
     *
     * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 4
     * 输出：4
     * 解释：
     * T_3 = 0 + 1 + 1 = 2
     * T_4 = 1 + 1 + 2 = 4
     * 示例 2：
     *
     * 输入：n = 25
     * 输出：1389537
     *
     *
     * 提示：
     *
     * 0 <= n <= 37
     * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
     */
    static class Solution1 {
        // dp 时间复杂度O(n) 空间复杂度O(1)
        public static int tribonacci(int n) {
            if (n < 2) {
                return n;
            }
            if (n == 2) {
                return 1;
            }
            int p, q = 1, r = 1, s = 2;
            for (int i = 4; i <= n; i++) {
                p = q;
                q = r;
                r = s;
                s = p + q + r;
            }
            return s;
        }

        public static void main(String[] args) {
            System.out.println(tribonacci(20));
        }
    }

    /**
     * 70. 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     * 示例 2：
     *
     * 输入：n = 3
     * 输出：3
     * 解释：有三种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶 + 1 阶
     * 2. 1 阶 + 2 阶
     * 3. 2 阶 + 1 阶
     *
     *
     * 提示：
     *
     * 1 <= n <= 45
     */
    static class Solution2 {
        public static int climbStairs(int n) {
            int p, q = 0, r = 1;

            for (int i = 1; i <= n; i++) {
                p = q;
                q = r;
                r = p + q;
            }
            return r;
        }

        public static void main(String[] args) {
            System.out.println(climbStairs(6));
        }
    }

    /**
     * 120. 三角形最小路径和
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     *
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     * 输出：11
     * 解释：如下面简图所示：
     *    2
     *   3 4
     *  6 5 7
     * 4 1 8 3
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     * 示例 2：
     *
     * 输入：triangle = [[-10]]
     * 输出：-10
     *
     *
     * 提示：
     *
     * 1 <= triangle.length <= 200
     * triangle[0].length == 1
     * triangle[i].length == triangle[i - 1].length + 1
     * -10^4 <= triangle[i][j] <= 10^4
     *
     *
     * 进阶：
     *
     * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
     */
    static class Solution3 {
        public static int minimumTotal(List<List<Integer>> triangle) {
            int len = triangle.size();
            int[][] f = new int[len][len];

            f[0][0] = triangle.get(0).get(0);
            for (int i = 1; i < len; i++) {
                // 0索引等于自身值+上层的0索引值
                f[i][0] = f[i-1][0] + triangle.get(i).get(0);
                for (int j = 1; j < i; j++) {
                    f[i][j] = triangle.get(i).get(j) + Math.min(f[i-1][j-1], f[i-1][j]);
                }
                // 最有一个点等于自身值+上层最有点值
                f[i][i] = f[i-1][i-1] + triangle.get(i).get(i);
            }

            int min = f[len - 1][0];
            for (int i = 0; i < len; i++) {
                min = Math.min(f[len - 1][i], min);
            }
            return min;
        }

        public static void main(String[] args) {
            List<List<Integer>> lists = new ArrayList<>();
            lists.add(Collections.singletonList(2));
            lists.add(Arrays.asList(3, 4));
            lists.add(Arrays.asList(6, 5, -7000));
            lists.add(Arrays.asList(3000, 1, 2, 5));
            lists.add(Arrays.asList(1000, 2, 5, 6, 7));
            lists.add(Arrays.asList(4, 1, 8, 3, 2, 6));
            System.out.println(minimumTotal(lists));
        }
    }
}
