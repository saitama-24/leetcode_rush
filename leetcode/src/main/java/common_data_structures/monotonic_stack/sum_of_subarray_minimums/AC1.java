package common_data_structures.monotonic_stack.sum_of_subarray_minimums;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wangzhenjie
 * @version 1.0
 * @date 2022/10/28 22:42
 * @className: AC1
 * @description: // 907. 子数组的最小值之和
 */
public class AC1 {

    /**
     * 907. 子数组的最小值之和
     * 中等
     * 557
     * 相关企业
     * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
     * <p>
     * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [3,1,2,4]
     * 输出：17
     * 解释：
     * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
     * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
     * 示例 2：
     * <p>
     * 输入：arr = [11,81,94,43,3]
     * 输出：444
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= arr.length <= 3 * 10^4
     * 1 <= arr[i] <= 3 * 10^4
     */
    static class Solution {
        public static int sumSubarrayMins(int[] arr) {
            int len = arr.length;
            int[] left = new int[len];
            int[] right = new int[len];
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(-1);
            for (int i = 0; i < len; i++) {
                while (stack.size() > 1 && arr[stack.peek()] > arr[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    left[i] = stack.peek();
                }
                stack.push(i);
            }
            stack.clear();
            stack.push(len);
            for (int i = len - 1; i >= 0; i--) {
                while (stack.size() > 1 && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    right[i] = stack.peek();
                }
                stack.push(i);
            }
            long res = 0;
            int mod = 1000000007;
            for (int i = 0; i < len; i++) {
                res += (long) arr[i] * (i - left[i]) * (right[i] - i);
            }
            return (int) (res % mod);
        }

        public static void main(String[] args) {
            System.out.println(sumSubarrayMins(new int[]{3,1,2,4}));
        }
    }
}
