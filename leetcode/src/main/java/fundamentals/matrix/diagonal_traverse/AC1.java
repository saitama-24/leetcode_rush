package fundamentals.matrix.diagonal_traverse;

import java.util.Arrays;

/**
 * @ClassName: AC1
 * @Description: 498. 对角线遍历
 * @Author: 琦玉
 * @Date: 2022年06月14日 10:53:21
 */
public class AC1 {

    /**
     * 498. 对角线遍历
     * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,4,7,5,3,6,8,9]
     * 示例 2：
     *
     * 输入：mat = [[1,2],[3,4]]
     * 输出：[1,2,3,4]
     *
     *
     * 提示：
     *
     * m == mat.length
     * n == mat[i].length
     * 1 <= m, n <= 10^4
     * 1 <= m * n <= 10^4
     * -10^5 <= mat[i][j] <= 10^5
     */
    static class Solution {
        public static int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int[] arr = new int[m * n];
            int count = 0;
            for (int i = 0; i < m + n - 1; i++) {
                if ((i & 1) == 0) {
                    int x = Math.min(i, m - 1);
                    int y = i - x;
                    while (y < n && x >= 0) {
                        arr[count++] = mat[x][y];
                        x--;
                        y++;
                    }
                } else {
                    int y = Math.min(i, n - 1);
                    int x = i - y;
                    while (x < m && y >= 0) {
                        arr[count++] = mat[x][y];
                        x++;
                        y--;
                    }
                }
            }
            return arr;
        }

        public static void main(String[] args) {
            System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            })));
        }
    }
}
