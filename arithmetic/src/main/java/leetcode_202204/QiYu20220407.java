package leetcode_202204;

import java.util.Arrays;

/**
 * @ClassName: QiYu20220407
 * @Description: QiYu20220407
 * @Author: wangzhenjie
 * @Date: 2022年04月07日 10:00:57
 */
public class QiYu20220407 {
    /**
     * 977. 有序数组的平方
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     * 示例 2：
     *
     * 输入：nums = [-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 已按 非递减顺序 排序
     *
     *
     * 进阶：
     *
     * 请你设计时间复杂度为 O(n) 的算法解决本问题
     */
    static class Solution1 {
        // 解法1 最简单的借助api排序，复杂度取决于算法底层实现
        public static int[] sortedSquares(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] *= nums[i];
            }
            Arrays.sort(nums);
            return nums;
        }

        public static void main(String[] args) {
            System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        }
    }

    static class Solution2 {
        // 解法2 双指针
        public static int[] sortedSquares(int[] nums) {
            if (nums.length == 1) {
                nums[0] *= nums[0];
                return nums;
            }

            int head = 0;
            int tail = nums.length-1;
            int[] arr = new int[nums.length];
            // 定义新数组浮标，倒插
            int pos = nums.length - 1;
            while (head <= tail) {
                if (nums[head] * nums[head] >= nums[tail] * nums[tail]) {
                    arr[pos] = nums[head] * nums[head];
                    head ++;
                } else {
                    arr[pos] = nums[tail] * nums[tail];
                    tail --;
                }
                pos --;
            }
            return arr;
        }

        public static void main(String[] args) {
            System.out.println(Arrays.toString(sortedSquares(new int[]{-7,-3,2,3,11})));
        }
    }

    /**
     * 189. 轮转数组
     * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右轮转 1 步: [7,1,2,3,4,5,6]
     * 向右轮转 2 步: [6,7,1,2,3,4,5]
     * 向右轮转 3 步: [5,6,7,1,2,3,4]
     * 示例 2:
     *
     * 输入：nums = [-1,-100,3,99], k = 2
     * 输出：[3,99,-1,-100]
     * 解释:
     * 向右轮转 1 步: [99,-1,-100,3]
     * 向右轮转 2 步: [3,99,-1,-100]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 105
     * -231 <= nums[i] <= 231 - 1
     * 0 <= k <= 105
     *
     *
     * 进阶：
     *
     * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
     * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
     */
    static class Solution3 {
        // 解法1：定义新数组存储，时间复杂度O(n), 空间复杂度O(n)
        public static void rotate(int[] nums, int k) {
            int len = nums.length;
            if (k % len == 0) {
                return;
            }
            int realK = k % len;
            int[] arr = new int[len];
            // 定义起始位置
            int pos = len - realK;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = nums[pos];
                pos ++;
                if (pos == len) {
                    // 如果当前索引已经等于数组长度，说明已经超出索引范围，需从头遍历
                    pos = 0;
                }
            }
            System.arraycopy(arr, 0, nums, 0, len);
        }

        public static void main(String[] args) {
            rotate(new int[]{1,2,3,4,5,6,7}, 3);
        }
    }
}
