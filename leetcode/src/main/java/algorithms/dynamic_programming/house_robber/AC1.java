package algorithms.dynamic_programming.house_robber;

/**
 * @ClassName: AC1
 * @Description: 198. 打家劫舍
 * @Author: 琦玉
 * @Date: 2022年04月21日 14:11:26
 */
public class AC1 {

    /**
     * 198. 打家劫舍
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     *
     *
     * 示例 1：
     *
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 2：
     *
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 400
     */
    static class Solution {
        public static int rob(int[] nums) {
            int len = nums.length;
            if (len == 1) {
                return nums[0];
            }

            int[] f = new int[nums.length];
            f[0] = nums[0];
            // 第二间房最大收益
            f[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < f.length; i++) {
                // 第i+1间房最大收益
                f[i] = Math.max(f[i - 1], nums[i] + f[i - 2]);
            }
            return f[len - 1];
        }

        public static void main(String[] args) {
            System.out.println(rob(new int[]{2,7,9,3,1}));
        }
    }
}
