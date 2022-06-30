package common_data_structures.hash_table.find_majority_element_lcci;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: AC1
 * @Description: 面试题 17.10. 主要元素
 * @Author: 琦玉
 * @Date: 2022年06月30日 15:45:09
 */
public class AC1 {

    /**
     * 面试题 17.10. 主要元素
     * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：[1,2,5,9,5,9,5,5,5]
     * 输出：5
     * 示例 2：
     *
     * 输入：[3,2]
     * 输出：-1
     * 示例 3：
     *
     * 输入：[2,2,1,1,1,2,2]
     * 输出：2
     */
    static class Solution {
        public static int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.merge(num, 1, Integer::sum);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > nums.length / 2) {
                    return entry.getKey();
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            System.out.println(majorityElement(new int[]{1,2,5,9,5,9,5,5,5}));
        }
    }
}
