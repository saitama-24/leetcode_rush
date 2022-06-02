package algorithms.backtracking.sum_of_all_subset_xor_totals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: AC3
 * @Description: AC3
 * @Author: 琦玉
 * @Date: 2022年06月02日 15:25:10
 */
public class AC3 {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(0, nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int i, int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int j = i; j < len; j++) {
//            if (!used[i]) {
                path.addLast(nums[j]);
//                used[i] = true;

                System.out.println("  递归之前 => " + path);
                dfs(j + 1, nums, len, depth + 1, path, used, res);

//                used[i] = false;
                path.removeLast();
                System.out.println("递归之后 => " + path);
//            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        AC3 solution = new AC3();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }
}
