package dp;

import java.util.Arrays;

/**
 * @ClassName: dp_20220420
 * @Description: dp_20220420
 * @Author: 琦玉
 * @Date: 2022年04月20日 9:58:55
 */
public class dp_20220420 {

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
    static class Solution {
        public static int climbStairs(int n) {
            int p, q = 0, r = 1;

            for (int i = 1; i <= n; i++) {
                p = q;
                q = r;
                r = p + q;
            }
            return r;
        }
    }

    /**
     * 746. 使用最小花费爬楼梯
     * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
     *
     * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
     *
     * 请你计算并返回达到楼梯顶部的最低花费。
     *
     *
     *
     * 示例 1：
     *
     * 输入：cost = [10,15,20]
     * 输出：15
     * 解释：你将从下标为 1 的台阶开始。
     * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
     * 总花费为 15 。
     * 示例 2：
     *
     * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
     * 输出：6
     * 解释：你将从下标为 0 的台阶开始。
     * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
     * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
     * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
     * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
     * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
     * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
     * 总花费为 6 。
     *
     *
     * 提示：
     *
     * 2 <= cost.length <= 1000
     * 0 <= cost[i] <= 999
     */
    static class Solution1 {
        public static int minCostClimbingStairs(int[] cost) {
            int len = cost.length;
            int[] f = new int[len+1];
            f[0] = cost[0];
            f[1] = cost[1];
            for (int i = 2; i < cost.length; i++) {
                f[i] = Math.min(f[i-1], f[i-2]) + cost[i];
            }
            return Math.min(f[len-2], f[len-1]);
        }

        public static void main(String[] args) {
            System.out.println(minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
        }
    }

    /**
     * 338. 比特位计数
     * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：[0,1,1]
     * 解释：
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     * 示例 2：
     *
     * 输入：n = 5
     * 输出：[0,1,1,2,1,2]
     * 解释：
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     * 3 --> 11
     * 4 --> 100
     * 5 --> 101
     *
     *
     * 提示：
     *
     * 0 <= n <= 10^5
     *
     *
     * 进阶：
     *
     * 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
     * 你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ）
     */
    static class Solution3 {
        public static int[] countBits(int n) {
            int[] dp = new int[n+1];
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                int num = i;
                int count = 0;
                while (num > 0) {
                    int d = num % 2;
                    if (d == 1) {
                        count ++;
                    }
                    num /= 2;
                }
                dp[i] = count;
            }
            return dp;
        }

        public static void main(String[] args) {
            System.out.println(Arrays.toString(countBits(5)));
        }
    }

    /**
     * 392. 判断子序列
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     *
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     *
     * 进阶：
     *
     * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
     *
     * 致谢：
     *
     * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "abc", t = "ahbgdc"
     * 输出：true
     * 示例 2：
     *
     * 输入：s = "axc", t = "ahbgdc"
     * 输出：false
     *
     *
     * 提示：
     *
     * 0 <= s.length <= 100
     * 0 <= t.length <= 10^4
     * 两个字符串都只由小写字符组成。
     */
    static class Solution4 {
        public static boolean isSubsequence(String s, String t) {
            if (s.length() == 0) {
                return true;
            }
            int count = 0;
            for (char aChar : t.toCharArray()) {
                if (s.charAt(count) == aChar) {
                    // 匹配到相同的就移位
                    count++;
                }
                if (count == s.length()) {
                    return true;
                }
            }
            return false;
        }

        public static void main(String[] args) {
            System.out.println(isSubsequence("b", "abc"));
        }
    }

    /**
     * 1025. 除数博弈
     * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
     *
     * 最初，黑板上有一个数字 n 。在每个玩家的回合，玩家需要执行以下操作：
     *
     * 选出任一 x，满足 0 < x < n 且 n % x == 0 。
     * 用 n - x 替换黑板上的数字 n 。
     * 如果玩家无法执行这些操作，就会输掉游戏。
     *
     * 只有在爱丽丝在游戏中取得胜利时才返回 true 。假设两个玩家都以最佳状态参与游戏。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：true
     * 解释：爱丽丝选择 1，鲍勃无法进行操作。
     * 示例 2：
     *
     * 输入：n = 3
     * 输出：false
     * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
     *
     *
     * 提示：
     *
     * 1 <= n <= 1000
     */
    static class Solution5 {
        public static boolean divisorGame(int n) {
            return n % 2 == 0;
        }
    }

    /**
     * 1646. 获取生成数组中的最大值
     * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
     *
     * nums[0] = 0
     * nums[1] = 1
     * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
     * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
     * 返回生成数组 nums 中的 最大 值。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 7
     * 输出：3
     * 解释：根据规则：
     *   nums[0] = 0
     *   nums[1] = 1
     *   nums[(1 * 2) = 2] = nums[1] = 1
     *   nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
     *   nums[(2 * 2) = 4] = nums[2] = 1
     *   nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
     *   nums[(3 * 2) = 6] = nums[3] = 2
     *   nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
     * 因此，nums = [0,1,1,2,1,3,2,3]，最大值 3
     * 示例 2：
     *
     * 输入：n = 2
     * 输出：1
     * 解释：根据规则，nums[0]、nums[1] 和 nums[2] 之中的最大值是 1
     * 示例 3：
     *
     * 输入：n = 3
     * 输出：2
     * 解释：根据规则，nums[0]、nums[1]、nums[2] 和 nums[3] 之中的最大值是 2
     *
     *
     * 提示：
     *
     * 0 <= n <= 100
     */
    static class Solution6 {
        public static int getMaximumGenerated(int n) {
            if (n == 0) {
                return 0;
            }
            int[] dp = new int[n+1];
            dp[0] = 0;
            dp[1] = 1;
            int max = dp[1];
            for (int i = 2; i <= n; i++) {
                int j = i / 2;
                if (i % 2 > 0) {
                    dp[i] = dp[j] + dp[j+1];
                } else {
                    dp[i] = dp[j];
                }
                max = Math.max(dp[i], max);
            }
            return max;
        }

        public static void main(String[] args) {
            System.out.println(getMaximumGenerated(0));
        }
    }
}
