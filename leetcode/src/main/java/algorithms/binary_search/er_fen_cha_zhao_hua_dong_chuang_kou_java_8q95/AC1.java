package algorithms.binary_search.er_fen_cha_zhao_hua_dong_chuang_kou_java_8q95;

import java.util.Arrays;

/**
 * @ClassName: AC1
 * @Description: 719. 找出第 K 小的数对距离
 * @Author: 琦玉
 * @Date: 2022年06月15日 17:37:38
 */
public class AC1 {

    /**
     * 719. 找出第 K 小的数对距离
     * 数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
     *
     * 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。返回 所有数对距离中 第 k 小的数对距离。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,3,1], k = 1
     * 输出：0
     * 解释：数对和对应的距离如下：
     * (1,3) -> 2
     * (1,1) -> 0
     * (3,1) -> 2
     * 距离第 1 小的数对是 (1,1) ，距离为 0 。
     * 示例 2：
     *
     * 输入：nums = [1,1,1], k = 2
     * 输出：0
     * 示例 3：
     *
     * 输入：nums = [1,6,1], k = 3
     * 输出：5
     *
     *
     * 提示：
     *
     * n == nums.length
     * 2 <= n <= 10^4
     * 0 <= nums[i] <= 10^6
     * 1 <= k <= n * (n - 1) / 2
     */
    static class Solution {
        public static int smallestDistancePair(int[] nums, int k) {
            int len = nums.length;
            Arrays.sort(nums);
            // 第k小的数对距离一定在区间[0, nums[max] - nums[min]]内
            int left = 0;
            int right = nums[len - 1] - nums[0];
            while (left < right) {
                int mid = (left + right) / 2;
                int count = getCount(nums, mid);
                if (count < k) {
                    // 这里的意思是，如果小于等于mid的数对只有count个，count小于k，说明要遍历的区间[0,mid]上限小了，应该提高上限
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }

        private static int getCount(int[] nums, int target) {
            int count = 0;
            int len = nums.length;
            for (int left = 0, right = 0; right < len; right++) {
                while (nums[right] - nums[left] > target) {
                    left++;
                }
                // 此时满足 nums[right] - nums[left] <= threshold
                // right 与 [left..right - 1] 里的每一个元素的「距离」都小于等于 threshold
                // [left..right - 1] 里元素的个数为 right - left
                count += right - left;
            }
            return count;
        }

        public static void main(String[] args) {
            System.out.println(smallestDistancePair(new int[]{1,6,1}, 3));
        }
    }
}
