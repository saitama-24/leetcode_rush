package algorithms.greedy.minimize_maximum_pair_sum_in_array;

import java.util.Arrays;

/**
 * @ClassName: AC1
 * @Description: 1877. 数组中最大数对和的最小值
 * @Author: 琦玉
 * @Date: 2022年05月11日 16:55:17
 */
public class AC1 {

    /**
     * 1877. 数组中最大数对和的最小值
     * 一个数对 (a,b) 的 数对和 等于 a + b 。最大数对和 是一个数对数组中最大的 数对和 。
     *
     * 比方说，如果我们有数对 (1,5) ，(2,3) 和 (4,4)，最大数对和 为 max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8 。
     * 给你一个长度为 偶数 n 的数组 nums ，请你将 nums 中的元素分成 n / 2 个数对，使得：
     *
     * nums 中每个元素 恰好 在 一个 数对中，且
     * 最大数对和 的值 最小 。
     * 请你在最优数对划分的方案下，返回最小的 最大数对和 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [3,5,2,3]
     * 输出：7
     * 解释：数组中的元素可以分为数对 (3,3) 和 (5,2) 。
     * 最大数对和为 max(3+3, 5+2) = max(6, 7) = 7 。
     * 示例 2：
     *
     * 输入：nums = [3,5,4,2,4,6]
     * 输出：8
     * 解释：数组中的元素可以分为数对 (3,5)，(4,4) 和 (6,2) 。
     * 最大数对和为 max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8 。
     *
     *
     * 提示：
     *
     * n == nums.length
     * 2 <= n <= 10^5
     * n 是 偶数 。
     * 1 <= nums[i] <= 10^5
     */
    static class Solution {
        public static int minPairSum(int[] nums) {
            // 由于要获得最小最大数对和，对每个数，应该和剩余数中最小的数结合。所以对使数组进行从到到小排列
            Arrays.sort(nums);
            int max = -1;
            // 定义头尾指针，向中间遍历，
            int head = 0;
            int tail = nums.length - 1;
            while (head < tail) {
                int sum = nums[head] + nums[tail];
                max = Math.max(sum, max);
                head ++;
                tail --;
            }
            return max;
        }

        public static void main(String[] args) {
            System.out.println(minPairSum(new int[]{5,3,5,2,1,5,5,2,3,1}));
        }
    }
}
