package common_data_structures.hash_table.find_majority_element_lcci;

import java.util.Arrays;

/**
 * @ClassName: AC2
 * @Description: 面试题 17.10. 主要元素
 * @Author: 琦玉
 * @Date: 2022年06月30日 15:45:09
 */
public class AC2 {

    /**
     * 面试题 17.10. 主要元素
     * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：[1,2,5,9,5,9,5,5,5]
     * 输出：5
     * 示例 2：
     * <p>
     * 输入：[3,2]
     * 输出：-1
     * 示例 3：
     * <p>
     * 输入：[2,2,1,1,1,2,2]
     * 输出：2
     */
    static class Solution {
        public static int majorityElement(int[] nums) {
            Arrays.sort(nums);
            int prev = nums[0];
            int count = 1;
            int max = 1;
            int maxNum = prev;
            for (int i = 1; i < nums.length; i++) {
                if (prev == nums[i]) {
                    count++;
                } else {
                    if (max < count) {
                        max = count;
                        maxNum = prev;
                    }
                    prev = nums[i];
                    count = 1;
                }
            }
            if (max < count) {
                max = count;
                maxNum = prev;
            }
            return max > nums.length / 2 ? maxNum : -1;
        }

        public static void main(String[] args) {
            System.out.println(majorityElement(new int[]{3, 2, 3}));
        }
    }
}
