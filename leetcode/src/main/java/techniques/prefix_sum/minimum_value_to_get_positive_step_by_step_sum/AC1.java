package techniques.prefix_sum.minimum_value_to_get_positive_step_by_step_sum;

/**
 * @ClassName: AC1
 * @Description: 1413. 逐步求和得到正数的最小值
 * @Author: 琦玉
 * @Date: 2022年08月09日 17:15:48
 */
public class AC1 {

    /**
     * 1413. 逐步求和得到正数的最小值
     * 给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。
     * <p>
     * 你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。
     * <p>
     * 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-3,2,-3,4,2]
     * 输出：5
     * 解释：如果你选择 startValue = 4，在第三次累加时，和小于 1 。
     * 累加求和
     * startValue = 4 | startValue = 5 | nums
     * (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
     * (1 +2 ) = 3  | (2 +2 ) = 4    |   2
     * (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
     * (0 +4 ) = 4  | (1 +4 ) = 5    |   4
     * (4 +2 ) = 6  | (5 +2 ) = 7    |   2
     * 示例 2：
     * <p>
     * 输入：nums = [1,2]
     * 输出：1
     * 解释：最小的 startValue 需要是正数。
     * 示例 3：
     * <p>
     * 输入：nums = [1,-2,-3]
     * 输出：5
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 100
     * -100 <= nums[i] <= 100
     */
    static class Solution {
        public static int minStartValue(int[] nums) {
            int sum = 0;
            int res = 1;
            for (int num : nums) {
                if (num < 0) {
                    res = Math.max(1 - (sum + num), res);
                }
                sum += num;
            }
            return res;
        }

        public static void main(String[] args) {
            System.out.println(minStartValue(new int[]{1, -2, -3}));
        }
    }
}
