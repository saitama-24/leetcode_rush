package algorithms.backtracking.permutations_ii;

import java.util.*;

/**
 * @ClassName: AC1
 * @Description: 47. 全排列 II
 * @Author: 琦玉
 * @Date: 2022年06月06日 14:08:24
 */
public class AC1 {

    /**
     * 47. 全排列 II
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     * [1,2,1],
     * [2,1,1]]
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 8
     * -10 <= nums[i] <= 10
     */
    static class Solution {
        public static List<List<Integer>> permuteUnique(int[] nums) {
            int len = nums.length;
            List<List<Integer>> lists = new ArrayList<>();
            Deque<Integer> path = new ArrayDeque<>();
            boolean[] used = new boolean[len];
            Arrays.sort(nums);
            dfs(lists, path, used, nums);
            return lists;
        }

        private static void dfs(List<List<Integer>> lists, Deque<Integer> path, boolean[] used, int[] nums) {
            if (path.size() == nums.length) {
                lists.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                    continue;
                }
                used[i] = true;
                path.add(nums[i]);
                dfs(lists, path, used, nums);
                used[i] = false;
                path.removeLast();
            }
        }

        public static void main(String[] args) {
            System.out.println(permuteUnique(new int[]{1, 2, 3, 3}));
        }
    }
}
