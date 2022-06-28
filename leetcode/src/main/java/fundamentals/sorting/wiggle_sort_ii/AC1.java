package fundamentals.sorting.wiggle_sort_ii;

import java.util.Arrays;

/**
 * @ClassName: AC1
 * @Description: 324. 摆动排序 II
 * @Author: 琦玉
 * @Date: 2022年06月28日 17:55:37
 */
public class AC1 {

    /**
     * 324. 摆动排序 II
     * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
     * <p>
     * 你可以假设所有输入数组都可以得到满足题目要求的结果。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,5,1,1,6,4]
     * 输出：[1,6,1,5,1,4]
     * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
     * 示例 2：
     * <p>
     * 输入：nums = [1,3,2,2,3,1]
     * 输出：[2,3,1,3,1,2]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 5 * 10^4
     * 0 <= nums[i] <= 5000
     * 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
     * <p>
     * <p>
     * 进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
     */
    static class Solution {
        public static void wiggleSort(int[] nums) {
            Arrays.sort(nums);
            int len = nums.length;
            int[] arr1 = new int[(len + 1) / 2];
            int[] arr2 = new int[len - arr1.length];
            int idx = 0;
            for (int i = arr1.length - 1; i >= 0; i--) {
                arr1[idx++] = nums[i];
            }
            idx = 0;
            for (int i = len - 1; i >= arr1.length; i--) {
                arr2[idx++] = nums[i];
            }
            int idx1 = 0, idx2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if ((i & 1) == 0 && idx1 < arr1.length) {
                    nums[i] = arr1[idx1++];
                } else {
                    nums[i] = arr2[idx2++];
                }
            }
        }

        public static void main(String[] args) {
            wiggleSort(new int[]{1,4,3,4,1,2,1,3,1,3,2,3,3});
        }
    }
}
