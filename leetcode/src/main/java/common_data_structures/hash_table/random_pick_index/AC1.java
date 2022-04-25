package common_data_structures.hash_table.random_pick_index;

import java.util.*;

/**
 * @ClassName: AC1
 * @Description: 398. 随机数索引
 * @Author: 琦玉
 * @Date: 2022年04月25日 11:44:28
 */
public class AC1 {

    /**
     * 398. 随机数索引
     * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
     *
     * 注意：
     * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
     *
     * 示例:
     *
     * int[] nums = new int[] {1,2,3,3,3};
     * Solution solution = new Solution(nums);
     *
     * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
     * solution.pick(3);
     *
     * // pick(1) 应该返回 0。因为只有nums[0]等于1。
     * solution.pick(1);
     */
    static class Solution {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Random random;
        public Solution(int[] nums) {
            random = new Random();
            for (int i = 0; i < nums.length; i++) {
                List<Integer> idxs;
                if (null != map.get(nums[i])) {
                    idxs = map.get(nums[i]);
                } else {
                    idxs = new ArrayList<>();
                }
                idxs.add(i);
                map.put(nums[i], idxs);
            }
        }

        public int pick(int target) {
            List<Integer> indices = map.get(target);
            // 随机获取 概率要相等
            return indices.get(random.nextInt(indices.size()));
        }
    }
}
