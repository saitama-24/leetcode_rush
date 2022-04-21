package algorithms.dynamic_programming.triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: AC1
 * @Description: AC1
 * @Author: 琦玉
 * @Date: 2022年04月21日 14:10:41
 */
public class AC1 {

    /**
     * 120. 三角形最小路径和
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     *
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     * 输出：11
     * 解释：如下面简图所示：
     *    2
     *   3 4
     *  6 5 7
     * 4 1 8 3
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     * 示例 2：
     *
     * 输入：triangle = [[-10]]
     * 输出：-10
     *
     *
     * 提示：
     *
     * 1 <= triangle.length <= 200
     * triangle[0].length == 1
     * triangle[i].length == triangle[i - 1].length + 1
     * -10^4 <= triangle[i][j] <= 10^4
     *
     *
     * 进阶：
     *
     * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
     */
    static class Solution {
        public static int minimumTotal(List<List<Integer>> triangle) {
            int len = triangle.size();
            int[][] f = new int[len][len];

            f[0][0] = triangle.get(0).get(0);
            for (int i = 1; i < len; i++) {
                // 0索引等于自身值+上层的0索引值
                f[i][0] = f[i-1][0] + triangle.get(i).get(0);
                for (int j = 1; j < i; j++) {
                    f[i][j] = triangle.get(i).get(j) + Math.min(f[i-1][j-1], f[i-1][j]);
                }
                // 最有一个点等于自身值+上层最有点值
                f[i][i] = f[i-1][i-1] + triangle.get(i).get(i);
            }

            int min = f[len - 1][0];
            for (int i = 0; i < len; i++) {
                min = Math.min(f[len - 1][i], min);
            }
            return min;
        }

        public static void main(String[] args) {
            List<List<Integer>> lists = new ArrayList<>();
            lists.add(Collections.singletonList(2));
            lists.add(Arrays.asList(3, 4));
            lists.add(Arrays.asList(6, 5, -7000));
            lists.add(Arrays.asList(3000, 1, 2, 5));
            lists.add(Arrays.asList(1000, 2, 5, 6, 7));
            lists.add(Arrays.asList(4, 1, 8, 3, 2, 6));
            System.out.println(minimumTotal(lists));
        }
    }
}
