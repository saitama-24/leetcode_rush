package algorithms.backtracking.subsets;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: AC1
 * @Description: 78. 子集
 * @Author: 琦玉
 * @Date: 2022年06月06日 17:31:17
 */
public class AC1 {

    /**
     * 78. 子集
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * <p>
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
     * nums 中的所有元素 互不相同
     */
    static class Solution {
        public static List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            Deque<Integer> path = new ArrayDeque<>();
            dfs(lists, path, 0, nums);
            return lists;
        }

        private static void dfs(List<List<Integer>> lists, Deque<Integer> path, int begin, int[] nums) {
            lists.add(new ArrayList<>(path));
            for (int i = begin; i < nums.length; i++) {
                path.add(nums[i]);
                dfs(lists, path, i + 1, nums);
                path.removeLast();
            }
        }

        public static void main(String[] args) {
            System.out.println(subsets(new int[]{1, 2, 3}));
        }
    }
}
