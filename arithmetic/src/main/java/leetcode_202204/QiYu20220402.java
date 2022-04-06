package leetcode_202204;

/**
 * @ClassName: QiYu20220402
 * @Description: 20220402力扣刷题记录
 * @Author: wangzhenjie
 * @Date: 2022年04月02日 10:58:49
 */
public class QiYu20220402 {

    /**
     * 70. 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
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
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/climbing-stairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        // ========== 记忆化递归 ============
        public static long climbStairsRecursive(int n) {
            int [] memory = new int[n+1];
            return calcRecursive(n, memory);
        }

        public static int calcRecursive(int n, int [] memory) {
            if (memory[n] > 0) {
                return memory[n];
            }
            if (n == 1) {
                memory[n] = 1;
            } else if (n == 2) {
                memory[n] = 2;
            } else {
                memory[n] = calcRecursive(n-1, memory) + calcRecursive(n-2, memory);
            }
            return memory[n];
        }
        // ========== 记忆化递归 ============

        // ========== 动态规划dp ============
        public static int climbStairsDP(int n) {
            return calcDP(n);
        }

        public static int calcDP(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            int [] dp = new int[n+1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n];
        }
        // ========== 动态规划dp ============
        public static void main(String[] args) {
            long recursiveStartTime = System.currentTimeMillis();
            System.out.println(climbStairsRecursive(45));
            long recursiveEndTime = System.currentTimeMillis();

            long dpStartTime = System.currentTimeMillis();
            System.out.println(climbStairsDP(45));
            long dpEndTime = System.currentTimeMillis();
            System.out.println("recursive consume" + (recursiveEndTime - recursiveStartTime));
            System.out.println("dp consume" + (dpEndTime - dpStartTime));
        }
    }

}
