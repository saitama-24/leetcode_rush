package algorithms.greedy.least_number_of_unique_integers_after_k_removals;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName: AC1
 * @Description: 1481. 不同整数的最少数目
 * @Author: 琦玉
 * @Date: 2022年06月20日 15:25:32
 */
public class AC1 {

    /**
     * 1481. 不同整数的最少数目
     * 给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [5,5,4], k = 1
     * 输出：1
     * 解释：移除 1 个 4 ，数组中只剩下 5 一种整数。
     * 示例 2：
     * <p>
     * 输入：arr = [4,3,1,1,3,3,2], k = 3
     * 输出：2
     * 解释：先移除 4、2 ，然后再移除两个 1 中的任意 1 个或者三个 3 中的任意 1 个，最后剩下 1 和 3 两种整数。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= arr.length <= 10^5
     * 1 <= arr[i] <= 10^9
     * 0 <= k <= arr.length
     */
    static class Solution {
        public static int findLeastNumOfUniqueInts(int[] arr, int k) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : arr) {
                if (freq.get(num) == null) {
                    freq.put(num, 1);
                } else {
                    Integer count = freq.get(num);
                    freq.put(num, count + 1);
                }
            }
            LinkedList<Map.Entry<Integer, Integer>> linkedList = new LinkedList<>(freq.entrySet());
            linkedList.sort(Comparator.comparingInt(Map.Entry::getValue));
            boolean flag = true;
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : linkedList) {
                if (flag) {
                    Integer value = entry.getValue();
                    k -= value;
                    if (k <= 0) {
                        flag = false;
                        if (k < 0) {
                            count++;
                        }
                    }
                } else {
                    count++;
                }
            }
            return count;
        }

        public static void main(String[] args) {
            System.out.println(findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1));
        }
    }
}
