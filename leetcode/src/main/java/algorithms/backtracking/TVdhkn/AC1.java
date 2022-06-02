package algorithms.backtracking.TVdhkn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: AC1
 * @Description: 剑指 Offer II 079. 所有子集
 * @Author: 琦玉
 * @Date: 2022年06月02日 16:47:35
 */
public class AC1 {

    /**
     * 剑指 Offer II 079. 所有子集
     * 给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     *
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     *
     * 输入：nums = [0]
     * 输出：[[],[0]]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * nums 中的所有元素 互不相同
     */
    static class Solution {
        public static List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            Deque<Integer> deque = new ArrayDeque<>();
            dfs(0, lists, deque, nums);
            return lists;
        }

        public static void dfs(int begin, List<List<Integer>> lists, Deque<Integer> path, int[] nums) {
            lists.add(new ArrayList<>(path));
            for (int i = begin; i < nums.length; i++) {
                path.add(nums[i]);
                dfs(i + 1, lists, path, nums);
                path.removeLast();
            }
        }

        public static void main(String[] args) {
            System.out.println(subsets(new int[]{1,2,3}));
        }
    }
}
