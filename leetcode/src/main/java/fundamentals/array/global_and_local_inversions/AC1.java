package fundamentals.array.global_and_local_inversions;

/**
 * @author wangzhenjie
 * @version 1.0
 * @date 2022/11/16 22:15
 * @className: AC1
 * @description: // 775. 全局倒置与局部倒置
 */
public class AC1 {

    /**
     * 775. 全局倒置与局部倒置
     * 中等
     * 180
     * 相关企业
     * 给你一个长度为 n 的整数数组 nums ，表示由范围 [0, n - 1] 内所有整数组成的一个排列。
     * <p>
     * 全局倒置 的数目等于满足下述条件不同下标对 (i, j) 的数目：
     * <p>
     * 0 <= i < j < n
     * nums[i] > nums[j]
     * 局部倒置 的数目等于满足下述条件的下标 i 的数目：
     * <p>
     * 0 <= i < n - 1
     * nums[i] > nums[i + 1]
     * 当数组 nums 中 全局倒置 的数量等于 局部倒置 的数量时，返回 true ；否则，返回 false 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,0,2]
     * 输出：true
     * 解释：有 1 个全局倒置，和 1 个局部倒置。
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,0]
     * 输出：false
     * 解释：有 2 个全局倒置，和 1 个局部倒置。
     * <p>
     * 提示：
     * <p>
     * n == nums.length
     * 1 <= n <= 10^5
     * 0 <= nums[i] < n
     * nums 中的所有整数 互不相同
     * nums 是范围 [0, n - 1] 内所有数字组成的一个排列
     */
    static class Solution {
        // 因为局部倒置必然是全局倒置，所以只要找出一个非局部倒置就证明不满足
        // 也就是nums[i] > nums[j] 0 <= i < j-1
        public static boolean isIdealPermutation(int[] nums) {
            int len = nums.length;
            int min = nums[len - 1];
            for (int i = len - 3; i >= 0; i--) {
                if (nums[i] > min) {
                    return false;
                }
                min = Math.min(min, nums[i + 1]);
            }
            return true;
        }
    }
}
