package common_data_structures.hash_table.make_array_zero_by_subtracting_equal_amounts;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: AC1
 * @Description: 532. 数组中的 k-diff 数对
 * @Author: 琦玉
 * @Date: 2023年02月24日 14:04:47
 */
public class AC1 {

    /**
     * 2357. 使数组中所有元素都等于零
     * 提示
     * 简单
     * 72
     * 相关企业
     * 给你一个非负整数数组 nums 。在一步操作中，你必须：
     *
     * 选出一个正整数 x ，x 需要小于或等于 nums 中 最小 的 非零 元素。
     * nums 中的每个正整数都减去 x。
     * 返回使 nums 中所有元素都等于 0 需要的 最少 操作数。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,5,0,3,5]
     * 输出：3
     * 解释：
     * 第一步操作：选出 x = 1 ，之后 nums = [0,4,0,2,4] 。
     * 第二步操作：选出 x = 2 ，之后 nums = [0,2,0,0,2] 。
     * 第三步操作：选出 x = 2 ，之后 nums = [0,0,0,0,0] 。
     * 示例 2：
     *
     * 输入：nums = [0]
     * 输出：0
     * 解释：nums 中的每个元素都已经是 0 ，所以不需要执行任何操作。
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 100
     */
    static class Solution {
        public static int minimumOperations(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (num != 0) {
                    map.put(num, 1);
                }
            }
            return map.size();
        }
    }
}
