package leetcode_202204;

/**
 * @ClassName: QiYu20220408
 * @Description: QiYu20220408
 * @Author: wangzhenjie
 * @Date: 2022年04月08日 11:44:58
 */
public class QiYu20220408 {
    /**
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 示例 2:
     *
     * 输入: nums = [0]
     * 输出: [0]
     *
     *
     * 提示:
     *
     * 1 <= nums.length <= 104
     * -2^31 <= nums[i] <= 2^31 - 1
     *
     *
     * 进阶：你能尽量减少完成的操作次数吗？
     */
    static class Solution {
        public static void moveZeroes(int[] nums) {
            int pos = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[pos++] = nums[i];
                }
            }
            for (int i = pos; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }

    /**
     * 167. 两数之和 II - 输入有序数组
     * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
     *
     * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
     *
     * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
     *
     * 你所设计的解决方案必须只使用常量级的额外空间。
     *
     *
     * 示例 1：
     *
     * 输入：numbers = [2,7,11,15], target = 9
     * 输出：[1,2]
     * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
     * 示例 2：
     *
     * 输入：numbers = [2,3,4], target = 6
     * 输出：[1,3]
     * 解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
     * 示例 3：
     *
     * 输入：numbers = [-1,0], target = -1
     * 输出：[1,2]
     * 解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
     *
     *
     * 提示：
     *
     * 2 <= numbers.length <= 3 * 104
     * -1000 <= numbers[i] <= 1000
     * numbers 按 非递减顺序 排列
     * -1000 <= target <= 1000
     * 仅存在一个有效答案
     */
    static class Solution1 {
        public static int[] twoSum(int[] numbers, int target) {
            return numbers;
        }
    }
}
