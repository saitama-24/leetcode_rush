package algorithms.dynamic_programming.minimum_path_sum;

/**
 * @ClassName: AC1
 * @Description: 64. 最小路径和
 * @Author: 琦玉
 * @Date: 2022年05月07日 17:41:06
 */
public class AC1 {

    /**
     * 64. 最小路径和
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     * 输出：7
     * 解释：因为路径 1→3→1→1→1 的总和最小。
     * 示例 2：
     *
     * 输入：grid = [[1,2,3],[4,5,6]]
     * 输出：12
     *
     *
     * 提示：
     *
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 200
     * 0 <= grid[i][j] <= 100
     */
    static class Solution {
        public static int minPathSum(int[][] grid) {
            int col = grid.length;
            int row = grid[0].length;
            int[][] dp = new int[col][row];
            dp[0][0] = grid[0][0];
            for (int i = 1; i < col; i++) {
                // 求出 i,0 最短路径
                dp[i][0] = dp[i-1][0] + grid[i][0];
            }
            for (int j = 1; j < row; j++) {
                // 求出 0,j 最短路径
                dp[0][j] = dp[0][j-1] + grid[0][j];
            }
            for (int i = 1; i < col; i++) {
                for (int j = 1; j < row; j++) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }
            return dp[col-1][row-1];
        }

        public static void main(String[] args) {
            int[] arr1 = new int[]{1,2,3};
            int[] arr2 = new int[]{4,5,6};
            int[] arr3 = new int[]{4,2,1};
            System.out.println(minPathSum(new int[][]{arr1, arr2, arr3}));
        }
    }
}
