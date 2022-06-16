package common_data_structures.hash_table.k_diff_pairs_in_an_array;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: AC1
 * @Description: 532. 数组中的 k-diff 数对
 * @Author: 琦玉
 * @Date: 2022年06月16日 14:04:47
 */
public class AC1 {

    /**
     * 532. 数组中的 k-diff 数对
     * 给定一个整数数组和一个整数 k，你需要在数组里找到 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
     * <p>
     * 这里将 k-diff 数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件：
     * <p>
     * 0 <= i < j < nums.length
     * |nums[i] - nums[j]| == k
     * 注意，|val| 表示 val 的绝对值。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3, 1, 4, 1, 5], k = 2
     * 输出：2
     * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
     * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
     * 示例 2：
     * <p>
     * 输入：nums = [1, 2, 3, 4, 5], k = 1
     * 输出：4
     * 解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
     * 示例 3：
     * <p>
     * 输入：nums = [1, 3, 1, 5, 4], k = 0
     * 输出：1
     * 解释：数组中只有一个 0-diff 数对，(1, 1)。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 10^4
     * -10^7 <= nums[i] <= 10^7
     * 0 <= k <= 10^7
     */
    static class Solution {
        public static int findPairs(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.merge(num, 1, Integer::sum);
            }
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer key = entry.getKey();
                if (k == 0) {
                    if (entry.getValue() > 1) {
                        count++;
                    }
                } else {
                    if (map.get(key + k) != null) {
                        count++;
                    }
                }
            }
            return count;
        }

        public static void main(String[] args) {
            System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        }
    }
}
