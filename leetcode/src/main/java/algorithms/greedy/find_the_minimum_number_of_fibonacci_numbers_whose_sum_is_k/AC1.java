package algorithms.greedy.find_the_minimum_number_of_fibonacci_numbers_whose_sum_is_k;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: AC1
 * @Description: 1414. 和为 K 的最少斐波那契数字数目
 * @Author: 琦玉
 * @Date: 2022年05月17日 16:01:00
 */
public class AC1 {

    /**
     * 1414. 和为 K 的最少斐波那契数字数目
     * 给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。
     * <p>
     * 斐波那契数字定义为：
     * <p>
     * F1 = 1
     * F2 = 1
     * Fn = Fn-1 + Fn-2 ， 其中 n > 2 。
     * 数据保证对于给定的 k ，一定能找到可行解。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：k = 7
     * 输出：2
     * 解释：斐波那契数字为：1，1，2，3，5，8，13，……
     * 对于 k = 7 ，我们可以得到 2 + 5 = 7 。
     * 示例 2：
     * <p>
     * 输入：k = 10
     * 输出：2
     * 解释：对于 k = 10 ，我们可以得到 2 + 8 = 10 。
     * 示例 3：
     * <p>
     * 输入：k = 19
     * 输出：3
     * 解释：对于 k = 19 ，我们可以得到 1 + 5 + 13 = 19 。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= k <= 10^9
     */
    static class Solution {
        private static Map<Integer, Integer> map;

        public static int findMinFibonacciNumbers(int k) {
            if (k <= 3) {
                return 1;
            }
            map = new HashMap<>();
            fib(k, map);
            int sum = 0;
            int idx = map.size() - 1;
            int count = 0;
            while (true) {
                if (map.get(idx) > k - sum) {
                    idx--;
                } else if (map.get(idx) == k - sum) {
                    count++;
                    break;
                } else {
                    count++;
                    sum += map.get(idx);
                }
            }
            return count;
        }

        public static void fib(int k, Map<Integer, Integer> map) {
            int f1 = 1, f2 = 1;
            int f3 = f1 + f2;
            map.put(0, f1);
            map.put(1, f2);
            map.put(2, f3);
            int count = 3;
            while (k > f3) {
                f1 = f2;
                f2 = f3;
                f3 = f1 + f2;
                map.put(count++, f3);
            }
        }

        public static void main(String[] args) {
            System.out.println(findMinFibonacciNumbers(7));
        }
    }
}
