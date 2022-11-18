package common_data_structures.monotonic_stack.daily_temperatures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author wangzhenjie
 * @version 1.0
 * @date 2022/11/18 21:17
 * @className: AC1
 * @description: // 739. 每日温度
 */
public class AC1 {

    /**
     * 739. 每日温度
     * 中等
     * 1.3K
     * 相关企业
     * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     *
     *
     *
     * 示例 1:
     *
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     * 示例 2:
     *
     * 输入: temperatures = [30,40,50,60]
     * 输出: [1,1,1,0]
     * 示例 3:
     *
     * 输入: temperatures = [30,60,90]
     * 输出: [1,1,0]
     *
     *
     * 提示：
     *
     * 1 <= temperatures.length <= 10^5
     * 30 <= temperatures[i] <= 100
     */
    static class Solution {
        public static int[] dailyTemperatures(int[] temperatures) {
            int len = temperatures.length;
            int[] res = new int[len];
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < temperatures.length; i++) {
                while (!stack.isEmpty() && temperatures[stack.peekLast()] < temperatures[i]) {
                    Integer idx = stack.pollLast();
                    res[idx] = i - idx;
                }
                stack.addLast(i);
            }
            return res;
        }

        public static void main(String[] args) {
            System.out.println(Arrays.toString(dailyTemperatures(new int[]{
                    73, 74, 75, 71, 69, 72, 76, 73
            })));
        }
    }
}
