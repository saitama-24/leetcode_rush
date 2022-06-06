package algorithms.backtracking.combinations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: AC1
 * @Description: 77. 组合
 * @Author: 琦玉
 * @Date: 2022年06月06日 11:19:42
 */
public class AC1 {

    /**
     * 77. 组合
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * <p>
     * 你可以按 任何顺序 返回答案。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 4, k = 2
     * 输出：
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     * 示例 2：
     * <p>
     * 输入：n = 1, k = 1
     * 输出：[[1]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 20
     * 1 <= k <= n
     */
    static class Solution {
        public static List<List<Integer>> combine(int n, int k) {
            int[] nums = new int[n];
            int num = 1;
            for (int i = 0; i < nums.length; i++) {
                nums[i] = num++;
            }
            List<List<Integer>> lists = new ArrayList<>();
            Deque<Integer> deque = new ArrayDeque<>();
            dfs(lists, deque, 0, nums, k);
            return lists;
        }

        private static void dfs(List<List<Integer>> lists, Deque<Integer> deque, int begin, int[] nums, int k) {
            if (deque.size() == k) {
                lists.add(new ArrayList<>(deque));
            }
            for (int i = begin; i < nums.length; i++) {
                deque.add(nums[i]);
                dfs(lists, deque, i + 1, nums, k);
                deque.removeLast();
            }
        }

        public static void main(String[] args) {
            System.out.println(combine(4, 2));
        }
    }
}
