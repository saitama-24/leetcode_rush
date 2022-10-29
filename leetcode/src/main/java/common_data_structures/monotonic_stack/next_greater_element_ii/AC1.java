package common_data_structures.monotonic_stack.next_greater_element_ii;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author wangzhenjie
 * @version 1.0
 * @date 2022/10/29 20:29
 * @className: AC1
 * @description: // 503. 下一个更大元素 II
 */
public class AC1 {

    /**
     * 503. 下一个更大元素 II
     * 中等
     * 729
     * 相关企业
     * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
     * <p>
     * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,2,1]
     * 输出: [2,-1,2]
     * 解释: 第一个 1 的下一个更大的数是 2；
     * 数字 2 找不到下一个更大的数；
     * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
     * 示例 2:
     * <p>
     * 输入: nums = [1,2,3,4,3]
     * 输出: [2,3,4,-1,4]
     * <p>
     * <p>
     * 提示:
     * <p>
     * 1 <= nums.length <= 10^4
     * -10^9 <= nums[i] <= 10^9
     */
    static class Solution {
        public static int[] nextGreaterElements(int[] nums) {
            int len = nums.length;
            Deque<Integer> stack = new ArrayDeque<>();
            int[] doubleNums = new int[len * 2];
            for (int i = 0; i < doubleNums.length; i++) {
                doubleNums[i] = nums[i < len ? i : i - len];
            }
            int[] arr = new int[len * 2];
            for (int i = 0; i < len * 2; i++) {
                while (!stack.isEmpty() && doubleNums[stack.peek()] < doubleNums[i]) {
                    Integer pop = stack.pop();
                    arr[pop] = doubleNums[i];
                }
                stack.push(i);
                arr[i] = -1;
            }
            int[] res = new int[len];
            System.arraycopy(arr, 0, res, 0, res.length);
            return res;
        }

        public static void main(String[] args) {
            System.out.println(Arrays.toString(nextGreaterElements(new int[]{1,2,1})));
        }
    }
}
