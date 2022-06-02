package algorithms.backtracking.permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: AC1
 * @Description: 46. 全排列
 * @Author: 琦玉
 * @Date: 2022年06月02日 17:37:23
 */
public class AC1 {

    /**
     * 46. 全排列
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     *
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     *
     * 输入：nums = [1]
     * 输出：[[1]]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * nums 中的所有整数 互不相同
     */
    static class Solution {
        public static List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            List<List<Integer>> lists = new ArrayList<>();
            Deque<Integer> deque = new ArrayDeque<>();
            boolean[] used = new boolean[len];
            dfs(0, lists, deque, nums, len, used);
            return lists;
        }

        public static void dfs(int depth, List<List<Integer>> lists, Deque<Integer> deque, int[] nums, int len, boolean[] used) {
            if (deque.size() == len) {
                lists.add(new ArrayList<>(deque));
            }
            for (int i = 0; i < len; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                deque.add(nums[i]);
                dfs(depth + 1, lists, deque, nums, len, used);
                used[i] = false;
                deque.removeLast();
            }
        }

        public static void main(String[] args) {
            System.out.println(permute(new int[]{1,2,3}));
        }
    }
}
