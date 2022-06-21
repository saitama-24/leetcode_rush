package algorithms.greedy.candy;

/**
 * @ClassName: AC1
 * @Description: 135. 分发糖果
 * @Author: 琦玉
 * @Date: 2022年06月21日 10:44:02
 */
public class AC1 {

    /**
     * 135. 分发糖果
     * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
     * <p>
     * 你需要按照以下要求，给这些孩子分发糖果：
     * <p>
     * 每个孩子至少分配到 1 个糖果。
     * 相邻两个孩子评分更高的孩子会获得更多的糖果。
     * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：ratings = [1,0,2]
     * 输出：5
     * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
     * 示例 2：
     * <p>
     * 输入：ratings = [1,2,2]
     * 输出：4
     * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
     * 第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
     * <p>
     * <p>
     * 提示：
     * <p>
     * n == ratings.length
     * 1 <= n <= 2 * 10^4
     * 0 <= ratings[i] <= 2 * 10^4
     */
    static class Solution {
        public static int candy(int[] ratings) {
            int[] count = new int[ratings.length];
            for (int i = 0; i < ratings.length; i++) {
                if (i > 0 && ratings[i] > ratings[i - 1]) {
                    count[i] = count[i - 1] + 1;
                } else {
                    count[i] = 1;
                }
            }
            int ans = 0;
            ans += count[ratings.length - 1];
            for (int i = ratings.length - 2; i >= 0; i--) {
                int now = count[i];
                if (ratings[i] > ratings[i + 1]) {
                    now = Math.max(count[i + 1] + 1, now);
                }
                count[i] = now;
                ans += count[i];
            }
            return ans;
        }

        public static void main(String[] args) {
            System.out.println(candy(new int[]{1, 3, 4, 5, 2}));
        }
    }
}
