package algorithms.greedy.maximum_bags_with_full_capacity_of_rocks;

import java.util.Arrays;

/**
 * @ClassName: AC1
 * @Description: 2279. 装满石头的背包的最大数量
 * @Author: 琦玉
 * @Date: 2022年06月17日 17:08:52
 */
public class AC1 {

    /**
     * 2279. 装满石头的背包的最大数量
     * 现有编号从 0 到 n - 1 的 n 个背包。给你两个下标从 0 开始的整数数组 capacity 和 rocks 。第 i 个背包最大可以装 capacity[i] 块石头，当前已经装了 rocks[i] 块石头。另给你一个整数 additionalRocks ，表示你可以放置的额外石头数量，石头可以往 任意 背包中放置。
     * <p>
     * 请你将额外的石头放入一些背包中，并返回放置后装满石头的背包的 最大 数量。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：capacity = [2,3,4,5], rocks = [1,2,4,4], additionalRocks = 2
     * 输出：3
     * 解释：
     * 1 块石头放入背包 0 ，1 块石头放入背包 1 。
     * 每个背包中的石头总数是 [2,3,4,4] 。
     * 背包 0 、背包 1 和 背包 2 都装满石头。
     * 总计 3 个背包装满石头，所以返回 3 。
     * 可以证明不存在超过 3 个背包装满石头的情况。
     * 注意，可能存在其他放置石头的方案同样能够得到 3 这个结果。
     * 示例 2：
     * <p>
     * 输入：capacity = [10,2,2], rocks = [2,2,0], additionalRocks = 100
     * 输出：3
     * 解释：
     * 8 块石头放入背包 0 ，2 块石头放入背包 2 。
     * 每个背包中的石头总数是 [10,2,2] 。
     * 背包 0 、背包 1 和背包 2 都装满石头。
     * 总计 3 个背包装满石头，所以返回 3 。
     * 可以证明不存在超过 3 个背包装满石头的情况。
     * 注意，不必用完所有的额外石头。
     * <p>
     * <p>
     * 提示：
     * <p>
     * n == capacity.length == rocks.length
     * 1 <= n <= 5 * 10^4
     * 1 <= capacity[i] <= 10^9
     * 0 <= rocks[i] <= capacity[i]
     * 1 <= additionalRocks <= 10^9
     */
    static class Solution {
        public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
            int[] arr = new int[capacity.length];
            for (int i = 0; i < capacity.length; i++) {
                arr[i] = capacity[i] - rocks[i];
            }
            Arrays.sort(arr);
            int ans = 0;
            for (int diff : arr) {
                if (diff == 0) {
                    ans++;
                } else {
                    if (additionalRocks >= diff) {
                        additionalRocks -= diff;
                        ans++;
                    }
                }
            }
            return ans;
        }

        public static void main(String[] args) {
            System.out.println(maximumBags(new int[]{2, 3, 4, 5}, new int[]{1, 2, 4, 4}, 2));
        }
    }
}
