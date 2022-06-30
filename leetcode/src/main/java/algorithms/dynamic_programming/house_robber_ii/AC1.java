package algorithms.dynamic_programming.house_robber_ii;

/**
 * @ClassName: AC1
 * @Description: 213. 打家劫舍 II
 * @Author: 琦玉
 * @Date: 2022年04月28日 11:01:54
 */
public class AC1 {

    /**
     * 213. 打家劫舍 II
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,3,2]
     * 输出：3
     * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3,1]
     * 输出：4
     * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     * 偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 3：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：3
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 1000
     */
    static class Solution {
        public static int rob(int[] nums) {
            int len = nums.length;
            if (len == 1) {
                return nums[0];
            }
            return Math.max(rob(nums, 0, len - 1), rob(nums, 1, len));
        }

        public static int rob(int[] nums, int begin, int end) {
            if (end - begin == 1) {
                return nums[end - 1];
            }
            int[] dp = new int[nums.length];
            dp[begin] = nums[begin];
            dp[begin + 1] = Math.max(nums[begin + 1], dp[begin]);
            for (int i = begin + 2; i < end; i++) {
                dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
            }
            return dp[end - 1];
        }

        public static void main(String[] args) {
            System.out.println(rob(new int[]{0,0}));
        }
    }
}
