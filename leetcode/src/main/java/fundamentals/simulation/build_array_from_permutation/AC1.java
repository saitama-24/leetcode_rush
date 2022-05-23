package fundamentals.simulation.build_array_from_permutation;

import java.util.Arrays;

/**
 * @ClassName: AC1
 * @Description: 1920. 基于排列构建数组
 * @Author: 琦玉
 * @Date: 2022年05月23日 17:58:54
 */
public class AC1 {

    /**
     * 1920. 基于排列构建数组
     * 给你一个 从 0 开始的排列 nums（下标也从 0 开始）。请你构建一个 同样长度 的数组 ans ，其中，对于每个 i（0 <= i < nums.length），都满足 ans[i] = nums[nums[i]] 。返回构建好的数组 ans 。
     *
     * 从 0 开始的排列 nums 是一个由 0 到 nums.length - 1（0 和 nums.length - 1 也包含在内）的不同整数组成的数组。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [0,2,1,5,3,4]
     * 输出：[0,1,2,4,5,3]
     * 解释：数组 ans 构建如下：
     * ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
     *     = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
     *     = [0,1,2,4,5,3]
     * 示例 2：
     *
     * 输入：nums = [5,0,1,2,3,4]
     * 输出：[4,5,0,1,2,3]
     * 解释：数组 ans 构建如下：
     * ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
     *     = [nums[5], nums[0], nums[1], nums[2], nums[3], nums[4]]
     *     = [4,5,0,1,2,3]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 1000
     * 0 <= nums[i] < nums.length
     * nums 中的元素 互不相同
     */
    static class Solution {
        public static int[] buildArray(int[] nums) {
            int len = nums.length;
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = nums[nums[i]];
            }
            return arr;
        }

        public static void main(String[] args) {
            System.out.println(Arrays.toString(buildArray(new int[]{0,2,1,5,3,4})));
        }
    }
}
