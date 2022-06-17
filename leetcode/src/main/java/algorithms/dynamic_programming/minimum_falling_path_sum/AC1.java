package algorithms.dynamic_programming.minimum_falling_path_sum;

/**
 * @ClassName: AC1
 * @Description: 931. 下降路径最小和
 * @Author: 琦玉
 * @Date: 2022年06月17日 11:40:00
 */
public class AC1 {

    /**
     * 931. 下降路径最小和
     * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
     * <p>
     * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
     * 输出：13
     * 解释：如图所示，为和最小的两条下降路径
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：matrix = [[-19,57],[-40,-5]]
     * 输出：-59
     * 解释：如图所示，为和最小的下降路径
     * <p>
     * <p>
     * 提示：
     * <p>
     * n == matrix.length == matrix[i].length
     * 1 <= n <= 100
     * -100 <= matrix[i][j] <= 100
     */
    static class Solution {
        public static int minFallingPathSum(int[][] matrix) {
            int[][] dp = new int[matrix.length][matrix.length];
            for (int i = 0; i < matrix[0].length; i++) {
                dp[0][i] = matrix[0][i];
            }
            for (int i = 1; i < matrix.length; i++) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + matrix[i][0];
                for (int j = 1; j < matrix[i].length - 1; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1])) + matrix[i][j];
                }
                dp[i][matrix[i].length - 1] = Math.min(dp[i - 1][matrix[i].length - 1], dp[i - 1][matrix[i].length - 2]) + matrix[i][matrix[i].length - 1];
            }
            int min = dp[matrix.length - 1][0];
            for (int i = 1; i < dp[matrix.length - 1].length; i++) {
                min = Math.min(min, dp[matrix.length - 1][i]);
            }
            return min;
        }

        public static void main(String[] args) {
            System.out.println(minFallingPathSum(new int[][]{
                    {2, 1, 3},
                    {6, 5, 4},
                    {7, 8, 9}
            }));
        }
    }
}
