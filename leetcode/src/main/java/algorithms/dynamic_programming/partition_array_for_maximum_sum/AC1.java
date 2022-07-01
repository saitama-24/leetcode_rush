package algorithms.dynamic_programming.partition_array_for_maximum_sum;

/**
 * @ClassName: AC1
 * @Description: 1043. 分隔数组以得到最大和
 * @Author: 琦玉
 * @Date: 2022年07月01日 15:58:38
 */
public class AC1 {

    /**
     * 1043. 分隔数组以得到最大和
     * 给你一个整数数组 arr，请你将该数组分隔为长度最多为 k 的一些（连续）子数组。分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。
     * <p>
     * 返回将数组分隔变换后能够得到的元素最大和。
     * <p>
     * <p>
     * <p>
     * 注意，原数组和分隔后的数组对应顺序应当一致，也就是说，你只能选择分隔数组的位置而不能调整数组中的顺序。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [1,15,7,9,2,5,10], k = 3
     * 输出：84
     * 解释：
     * 因为 k=3 可以分隔成 [1,15,7] [9] [2,5,10]，结果为 [15,15,15,9,10,10,10]，和为 84，是该数组所有分隔变换后元素总和最大的。
     * 若是分隔成 [1] [15,7,9] [2,5,10]，结果就是 [1, 15, 15, 15, 10, 10, 10] 但这种分隔方式的元素总和（76）小于上一种。
     * 示例 2：
     * <p>
     * 输入：arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
     * 输出：83
     * 示例 3：
     * <p>
     * 输入：arr = [1], k = 1
     * 输出：1
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= arr.length <= 500
     * 0 <= arr[i] <= 10^9
     * 1 <= k <= arr.length
     */
    static class Solution {
        public static int maxSumAfterPartitioning(int[] arr, int k) {
            int len = arr.length;
            int[] dp = new int[len];
            dp[0] = arr[0];
            for (int i = 1; i < k; i++) {
                dp[i] = getMaxNum(arr, 0, i + 1) * (i + 1);
            }
            for (int i = k; i < len; i++) {
                dp[i] = arr[i] + dp[i - 1];
                for (int j = 1; j < k; j++) {
                    dp[i] = Math.max(dp[i], (j + 1) * getMaxNum(arr, i - j, i + 1) + dp[i - j - 1]);
                }
            }
            return dp[len - 1];
        }

        private static int getMaxNum(int[] arr, int begin, int end) {
            int max = -1;
            for (int i = begin; i < end; i++) {
                max = Math.max(max, arr[i]);
            }
            return max;
        }

        public static void main(String[] args) {
            System.out.println(maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
        }
    }
}
