package algorithms.dynamic_programming.burst_balloons;

/**
 * @ClassName: AC1
 * @Description: 312. 戳气球
 * @Author: 琦玉
 * @Date: 2022年06月21日 15:29:45
 */
public class AC1 {

    /**
     * 312. 戳气球
     * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
     * <p>
     * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
     * <p>
     * 求所能获得硬币的最大数量。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * 输入：nums = [3,1,5,8]
     * 输出：167
     * 解释：
     * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
     * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
     * 示例 2：
     * <p>
     * 输入：nums = [1,5]
     * 输出：10
     * <p>
     * <p>
     * 提示：
     * <p>
     * n == nums.length
     * 1 <= n <= 300
     * 0 <= nums[i] <= 100
     */
    static class Solution {
        public static int maxCoins(int[] nums) {
            int len = nums.length;
            int[] val = new int[len + 2];
            val[0] = val[len + 1] = 1;
            for (int i = 1; i < len + 1; i++) {
                val[i] = nums[i - 1];
            }
            int[][] dp = new int[len + 2][len + 2];
            // len表示开区间长度
            for (int j = 3; j <= len + 2; j++) {
                // i表示开区间左端点
                for (int i = 0; i <= len + 2 - j; i++) {
                    int res = 0;
                    // k为开区间内的索引
                    for (int k = i + 1; k < i + j - 1; k++) {
                        int left = dp[i][k];
                        int right = dp[k][i + j - 1];
                        res = Math.max(res, left + val[i] * val[k] * val[i + j - 1] + right);
                    }
                    dp[i][i + j - 1] = res;
                }
            }
            return dp[0][len + 1];
        }

        public static void main(String[] args) {
            System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
        }
    }
}
