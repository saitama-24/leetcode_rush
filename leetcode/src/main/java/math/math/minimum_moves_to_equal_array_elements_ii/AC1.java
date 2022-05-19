package math.math.minimum_moves_to_equal_array_elements_ii;

import java.util.Arrays;

/**
 * @ClassName: AC1
 * @Description: 462. 最少移动次数使数组元素相等 II
 * @Author: 琦玉
 * @Date: 2022年05月19日 15:32:03
 */
public class AC1 {

    /**
     * 462. 最少移动次数使数组元素相等 II
     * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
     *
     * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：2
     * 解释：
     * 只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
     * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
     * 示例 2：
     *
     * 输入：nums = [1,10,2,9]
     * 输出：16
     *
     *
     * 提示：
     *
     * n == nums.length
     * 1 <= nums.length <= 10^5
     * -10^9 <= nums[i] <= 10^9
     */
    static class Solution {
        public static int minMoves2(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int ret = 0;
            int x = nums[n / 2];
            for (int num : nums) {
                ret += Math.abs(num - x);
            }
            return ret;
        }

        public static void main(String[] args) {
            System.out.println(minMoves2(new int[]{1,10,2,9}));
        }
    }
}
