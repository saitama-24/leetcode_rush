package fundamentals.simulation.cells_with_odd_values_in_a_matrix;

/**
 * @ClassName: AC1
 * @Description: 1252. 奇数值单元格的数目
 * @Author: 琦玉
 * @Date: 2022年07月15日 17:47:46
 */
public class AC1 {

    /**
     * 1252. 奇数值单元格的数目
     * 给你一个 m x n 的矩阵，最开始的时候，每个单元格中的值都是 0。
     * <p>
     * 另有一个二维索引数组 indices，indices[i] = [ri, ci] 指向矩阵中的某个位置，其中 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
     * <p>
     * 对 indices[i] 所指向的每个位置，应同时执行下述增量操作：
     * <p>
     * ri 行上的所有单元格，加 1 。
     * ci 列上的所有单元格，加 1 。
     * 给你 m、n 和 indices 。请你在执行完所有 indices 指定的增量操作后，返回矩阵中 奇数值单元格 的数目。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：m = 2, n = 3, indices = [[0,1],[1,1]]
     * 输出：6
     * 解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
     * 第一次增量操作后得到 [[1,2,1],[0,1,0]]。
     * 最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：m = 2, n = 2, indices = [[1,1],[0,0]]
     * 输出：0
     * 解释：最后的矩阵是 [[2,2],[2,2]]，里面没有奇数。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= m, n <= 50
     * 1 <= indices.length <= 100
     * 0 <= ri < m
     * 0 <= ci < n
     */
    static class Solution {
        public static int oddCells(int m, int n, int[][] indices) {
            int[][] matrix = new int[m][n];
            for (int[] index : indices) {
                for (int i = 0; i < n; i++) {
                    matrix[index[0]][i]++;
                }
                for (int i = 0; i < m; i++) {
                    matrix[i][index[1]]++;
                }
            }
            int ans = 0;
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    if ((anInt & 1) == 1) {
                        ans++;
                    }
                }
            }
            return ans;
        }

        public static void main(String[] args) {
            System.out.println(oddCells(2, 3, new int[][]{
                    {0, 1},
                    {1, 1}
            }));
        }
    }
}
