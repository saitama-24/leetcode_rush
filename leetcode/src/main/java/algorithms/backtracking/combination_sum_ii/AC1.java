package algorithms.backtracking.combination_sum_ii;

import java.util.*;

/**
 * @ClassName: AC1
 * @Description: 40. 组合总和 II
 * @Author: 琦玉
 * @Date: 2022年06月06日 17:14:19
 */
public class AC1 {


    /**
     * 40. 组合总和 II
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     * <p>
     * 注意：解集不能包含重复的组合。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 输出:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     * 示例 2:
     * <p>
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 输出:
     * [
     * [1,2,2],
     * [5]
     * ]
     * <p>
     * <p>
     * 提示:
     * <p>
     * 1 <= candidates.length <= 100
     * 1 <= candidates[i] <= 50
     * 1 <= target <= 30
     */
    static class Solution {
        public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> lists = new ArrayList<>();
            Arrays.sort(candidates);
            if (candidates[0] > target) {
                return lists;
            }
            Deque<Integer> path = new ArrayDeque<>();
            dfs(lists, candidates, path, target, 0);
            return lists;
        }

        private static void dfs(List<List<Integer>> lists, int[] candidates, Deque<Integer> path, int target, int begin) {
            if (target < 0) {
                return;
            }
            if (target == 0) {
                lists.add(new ArrayList<>(path));
                return;
            }
            for (int i = begin; i < candidates.length; i++) {
                if (i > begin && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                path.add(candidates[i]);
                dfs(lists, candidates, path, target - candidates[i], i + 1);
                path.removeLast();
            }
        }

        public static void main(String[] args) {
            System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        }
    }
}
