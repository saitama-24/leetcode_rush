package algorithms.dynamic_programming.JEj789;

/**
 * @ClassName: AC1
 * @Description: 剑指 Offer II 091. 粉刷房子
 * @Author: 琦玉
 * @Date: 2022年04月29日 17:36:58
 */
public class AC1 {

    /**
     * 剑指 Offer II 091. 粉刷房子
     * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
     *
     * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的。
     *
     * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
     *
     * 请计算出粉刷完所有房子最少的花费成本。
     *
     *
     *
     * 示例 1：
     *
     * 输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
     * 输出: 10
     * 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
     *      最少花费: 2 + 5 + 3 = 10。
     * 示例 2：
     *
     * 输入: costs = [[7,6,2]]
     * 输出: 2
     *
     *
     * 提示:
     *
     * costs.length == n
     * costs[i].length == 3
     * 1 <= n <= 100
     * 1 <= costs[i][j] <= 20
     */
    static class Solution {
        // todo 题解不正确
        public static int minCost(int[][] costs) {
            int len = costs.length;
            int[] dp = new int[len];
            int headMin = Integer.MAX_VALUE;
            for (int cost : costs[0]) {
                headMin = Math.min(headMin, cost);
            }
            dp[0] = headMin;
            if (len == 1) {
                return dp[0];
            }
            dp[1] = minAdjoin(costs, 1);
            for (int i = 2; i < costs.length; i++) {
                dp[i] = minAdjoin(costs, i) + dp[i-2];
            }
            return dp[len-1];
        }

        public static int minAdjoin(int[][] costs, int idx) {
            int nextMin = Integer.MAX_VALUE;
            for (int i = 0; i < costs[idx].length; i++) {
                for (int j = 0; j < costs[idx - 1].length; j++) {
                    if (i != j) {
                        nextMin = Math.min(nextMin, costs[idx][i] + costs[idx-1][j]);
                    }
                }
            }
            return nextMin;
        }


        public static void main(String[] args) {
            int[][] arr = new int[2][3];
            arr[0] = new int[]{20, 18, 4};
            arr[1] = new int[]{9, 9, 10};
            System.out.println(minCost(arr));
        }
    }
}
