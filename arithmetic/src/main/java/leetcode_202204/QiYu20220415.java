package leetcode_202204;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: QiYu20220415
 * @Description: QiYu20220415
 * @Author: 琦玉
 * @Date: 2022年04月15日 10:37:15
 */
public class QiYu20220415 {

    /**
     * 217. 存在重复元素
     * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3,1]
     * 输出：true
     * 示例 2：
     *
     * 输入：nums = [1,2,3,4]
     * 输出：false
     * 示例 3：
     *
     * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
     * 输出：true
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 10^5
     * -10^9 <= nums[i] <= 10^9
     */
    static class Solution {
        public static boolean containsDuplicate(int[] nums) {
            if (nums.length == 1) {
                return false;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.get(num) != null) {
                    return true;
                }
                map.put(num, -1);
            }
            return false;
        }
    }

    /**
     * 53. 最大子数组和
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 子数组 是数组中的一个连续部分。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * 示例 2：
     *
     * 输入：nums = [1]
     * 输出：1
     * 示例 3：
     *
     * 输入：nums = [5,4,-1,7,8]
     * 输出：23
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 10^5
     * -10^4 <= nums[i] <= 10^4
     *
     *
     * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
     */
    static class Solution1 {
        public static int maxSubArray(int[] nums) {
            int ans = nums[0];
            int pre = 0;
            for (int num : nums) {
                pre = Math.max(num, pre + num);
                ans = Math.max(pre, ans);
            }
            return ans;
        }
    }

    /**
     * 1. 两数之和
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     *
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     *
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     *
     *
     * 提示：
     *
     * 2 <= nums.length <= 10^4
     * -10^9 <= nums[i] <= 10^9
     * -10^9 <= target <= 10^9
     * 只会存在一个有效答案
     * 进阶：你可以想出一个时间复杂度小于 O(n^2) 的算法吗？
     */
    static class Solution2 {
        public static int[] twoSum(int[] nums, int target) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                List<Integer> list = map.get(nums[i]);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(i);
                map.put(nums[i], list);
            }
            int[] arr = new int[2];
            for (int i = 0; i < nums.length; i++) {
                List<Integer> list = map.get(target - nums[i]);
                if (null == list) {
                    continue;
                }
                if (list.size() > 1) {
                    int idx = -1;
                    for (Integer integer : list) {
                        if (integer != i) {
                            idx = integer;
                            break;
                        }
                    }
                    arr[0] = idx;
                    arr[1] = i;
                    break;
                }
                if (list.get(0) != i) {
                    arr[0] = list.get(0);
                    arr[1] = i;
                    break;
                }
            }
            return arr;
        }
    }

    /**
     * 88. 合并两个有序数组
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     *
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     *
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
     * 示例 2：
     *
     * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
     * 输出：[1]
     * 解释：需要合并 [1] 和 [] 。
     * 合并结果是 [1] 。
     * 示例 3：
     *
     * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
     * 输出：[1]
     * 解释：需要合并的数组是 [] 和 [1] 。
     * 合并结果是 [1] 。
     * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
     *
     *
     * 提示：
     *
     * nums1.length == m + n
     * nums2.length == n
     * 0 <= m, n <= 200
     * 1 <= m + n <= 200
     * -10^9 <= nums1[i], nums2[j] <= 10^9
     */
    static class Solution3 {
        // 双指针 时间复杂度O(m+n)  空间复杂度O(1)
        public static void merge(int[] nums1, int m, int[] nums2, int n) {
            // 分别指向nums1 和 nums2 最后一个数
            int tail1 = m - 1;
            int tail2 = n - 1;
            int pos = m + n - 1;

            while (tail1 >= 0 && tail2 >= 0) {
                if (nums1[tail1] >= nums2[tail2]) {
                    nums1[pos--] = nums1[tail1];
                    tail1--;
                } else {
                    nums1[pos--] = nums2[tail2];
                    tail2--;
                }
            }
            if (tail1 < 0) {
                // 如果nums2遍历完不需要处理，反之把nums2剩余所有数一次插入nums1剩余位置
                for (int i = tail2; i >= 0; i--) {
                    nums1[pos--] = nums2[i];
                }
            }
        }

        public static void main(String[] args) {
            merge(new int[]{0}, 0, new int[]{1}, 1);
        }
    }
}
