package algorithms.greedy.reduce_array_size_to_the_half;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName: AC1
 * @Description: 1338. 数组大小减半
 * @Author: 琦玉
 * @Date: 2022年05月17日 17:42:40
 */
public class AC1 {

    /**
     * 1338. 数组大小减半
     * 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
     *
     * 返回 至少 能删除数组中的一半整数的整数集合的最小大小。
     *
     *
     *
     * 示例 1：
     *
     * 输入：arr = [3,3,3,3,5,5,5,2,2,7]
     * 输出：2
     * 解释：选择 {3,7} 使得结果数组为 [5,5,5,2,2]、长度为 5（原数组长度的一半）。
     * 大小为 2 的可行集合有 {3,5},{3,2},{5,2}。
     * 选择 {2,7} 是不可行的，它的结果数组为 [3,3,3,3,5,5,5]，新数组长度大于原数组的二分之一。
     * 示例 2：
     *
     * 输入：arr = [7,7,7,7,7,7]
     * 输出：1
     * 解释：我们只能选择集合 {7}，结果数组为空。
     *
     *
     * 提示：
     *
     * 1 <= arr.length <= 10^5
     * arr.length 为偶数
     * 1 <= arr[i] <= 10^5
     */
    static class Solution {
        public static int minSetSize(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : arr) {
                map.merge(i, 1, Integer::sum);
            }
            PriorityQueue<Integer> heap = new PriorityQueue<>((Integer num1, Integer num2) -> num2 - num1);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                heap.offer(entry.getValue());
            }
            int sum = 0, rst = 0;
            while (!heap.isEmpty()) {
                sum += heap.poll();
                rst++;
                if (sum >= (arr.length >> 1)) {
                    return rst;
                }
            }
            return rst;
        }

        public static void main(String[] args) {
            System.out.println(minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7}));
        }
    }
}
