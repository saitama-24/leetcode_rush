package techniques.sliding_window.subarray_product_less_than_k;

/**
 * @ClassName: AC1
 * @Description: 713. 乘积小于 K 的子数组
 * @Author: 琦玉
 * @Date: 2022年05月05日 10:11:26
 */
public class AC1 {

    /**
     * 713. 乘积小于 K 的子数组
     * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
     *
     *
     * 示例 1：
     *
     * 输入：nums = [10,5,2,6], k = 100
     * 输出：8
     * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
     * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
     * 示例 2：
     *
     * 输入：nums = [1,2,3], k = 0
     * 输出：0
     *
     *
     * 提示:
     *
     * 1 <= nums.length <= 3 * 10^4
     * 1 <= nums[i] <= 1000
     * 0 <= k <= 106
     */
    static class Solution {
        public static int numSubarrayProductLessThanK(int[] nums, int k) {
            int len = nums.length;
            int slow = 0;
            int fast = 0;
            int count = 0;
            int prev = -1;
            while (slow < len) {
                int multiply;
                if (slow == fast) {
                    multiply = nums[slow];
                } else {
                    multiply = prev * nums[fast];
                }
                prev = multiply;
                if (multiply >= k) {
                    slow++;
                    fast = slow;
                } else {
                    count++;
                    fast++;
                    if (fast == len) {
                        slow++;
                        fast = slow;
                    }
                }
            }
            return count;
        }

        public static void main(String[] args) {
            System.out.println(numSubarrayProductLessThanK(new int[]{1,2,3}, 0));
        }
    }
}
