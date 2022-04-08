package leetcode_202204;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: QiYu20220408
 * @Description: QiYu20220408
 * @Author: 琦玉
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
            int len = numbers.length;
            int head = 0;
            int tail = len - 1;
            int[] arr = new int[2];
            while (head < tail) {
                int sum = numbers[head] + numbers[tail];
                if (sum == target) {
                    arr[0] = head + 1;
                    arr[1] = tail + 1;
                    return arr;
                } else if (sum < target) {
                    head ++;
                } else {
                    tail --;
                }
            }
            return arr;
        }

        public static void main(String[] args) {
            System.out.println(Arrays.toString(twoSum(new int[]{-1, 0}, -1)));
        }
    }

    /**
     * 15. 三数之和
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 示例 2：
     *
     * 输入：nums = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：nums = [0]
     * 输出：[]
     *
     *
     * 提示：
     *
     * 0 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     */
    static class Solution2 {
        public static List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) {
                return new ArrayList<>();
            }
            Arrays.sort(nums);
            if (nums[0] >= 0) {
                return new ArrayList<>();
            }

            int head = 0;
            int tail = nums.length -1;
            int prev = nums.length -2;
            List<List<Integer>> lists = new ArrayList<>();
            // todo 不全
            while (head < prev) {
                int sum = nums[head] + nums[tail] + nums[prev];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[head]);
                    list.add(nums[tail]);
                    list.add(nums[prev]);
                    lists.add(list);
                    head ++;
                    tail = nums.length -1;
                    prev = nums.length -2;
                } else if (sum > 0) {
                    tail = prev;
                    prev --;
                } else {
                    head ++;
                }
            }
            return lists;
        }

        public static void main(String[] args) {
            System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        }
    }
}
