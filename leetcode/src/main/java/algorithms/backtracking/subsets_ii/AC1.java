package algorithms.backtracking.subsets_ii;

import java.util.*;

/**
 * @ClassName: AC1
 * @Description: 90. 子集 II
 * @Author: 琦玉
 * @Date: 2022年06月06日 17:45:02
 */
public class AC1 {

    /**
     * 90. 子集 II
     * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
     * <p>
     * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,2]
     * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
     * 示例 2：
     * <p>
     * 输入：nums = [0]
     * 输出：[[],[0]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     */
    static class Solution {
        public static List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            Deque<Integer> path = new ArrayDeque<>();
            Arrays.sort(nums);
            dfs(lists, path, nums, 0);
            return lists;
        }

        private static void dfs(List<List<Integer>> lists, Deque<Integer> path, int[] nums, int begin) {
            lists.add(new ArrayList<>(path));
            for (int i = begin; i < nums.length; i++) {
                if (i > begin && nums[i] == nums[i - 1]) {
                    continue;
                }
                path.add(nums[i]);
                dfs(lists, path, nums, i + 1);
                path.removeLast();
            }
        }

        public static void main(String[] args) {
            System.out.println(subsetsWithDup(new int[]{4,4,4,1,4}));
        }
    }
}
