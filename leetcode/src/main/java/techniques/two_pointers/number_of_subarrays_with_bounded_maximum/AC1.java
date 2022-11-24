package techniques.two_pointers.number_of_subarrays_with_bounded_maximum;

/**
 * @author wangzhenjie
 * @version 1.0
 * @date 2022/11/24 20:30
 * @className: AC1
 * @description: // 795. 区间子数组个数
 */
public class AC1 {

    /**
     * 795. 区间子数组个数
     * 中等
     * 280
     * 相关企业
     * 给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组，并返回满足条件的子数组的个数。
     *
     * 生成的测试用例保证结果符合 32-bit 整数范围。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,1,4,3], left = 2, right = 3
     * 输出：3
     * 解释：满足条件的三个子数组：[2], [2, 1], [3]
     * 示例 2：
     *
     * 输入：nums = [2,9,2,5,6], left = 2, right = 8
     * 输出：7
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 10^5
     * 0 <= nums[i] <= 10^9
     * 0 <= left <= right <= 10^9
     */
    static class Solution {
        public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
            return count(nums, right) - count(nums, left - 1);
        }

        private static int count(int[] nums, int lower) {
            int res = 0;
            int count = 0;
            for (int num : nums) {
                if (num <= lower) {
                    count++;
                } else {
                    count = 0;
                }
                res += count;
            }
            return res;
        }

        public static void main(String[] args) {
            System.out.println(numSubarrayBoundedMax(new int[]{
                    2,9,2,5,6
            }, 2, 8));
        }
    }
}
