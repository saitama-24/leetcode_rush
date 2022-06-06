package algorithms.backtracking.VvJkup;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: AC1
 * @Description: 剑指 Offer II 083. 没有重复元素集合的全排列
 * @Author: 琦玉
 * @Date: 2022年06月06日 11:02:54
 */
public class AC1 {

    /**
     * 剑指 Offer II 083. 没有重复元素集合的全排列
     * 给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     * <p>
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     * <p>
     * 输入：nums = [1]
     * 输出：[[1]]
     * <p>
     * <p>
     * 提示：
     * <p>
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
            dfs(deque, lists, used, nums);
            return lists;
        }

        private static void dfs(Deque<Integer> deque, List<List<Integer>> lists, boolean[] used, int[] nums) {
            if (deque.size() == nums.length) {
                lists.add(new ArrayList<>(deque));
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                deque.add(nums[i]);
                dfs(deque, lists, used, nums);
                used[i] = false;
                deque.removeLast();
            }
        }

        public static void main(String[] args) {
            System.out.println(permute(new int[]{1, 2, 3}));
        }
    }
}
