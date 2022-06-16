package algorithms.greedy.earliest_possible_day_of_full_bloom;

import java.util.*;

/**
 * @ClassName: AC1
 * @Description: 2136. 全部开花的最早一天
 * @Author: 琦玉
 * @Date: 2022年06月16日 18:04:08
 */
public class AC1 {

    /**
     * 2136. 全部开花的最早一天
     * 你有 n 枚花的种子。每枚种子必须先种下，才能开始生长、开花。播种需要时间，种子的生长也是如此。给你两个下标从 0 开始的整数数组 plantTime 和 growTime ，每个数组的长度都是 n ：
     *
     * plantTime[i] 是 播种 第 i 枚种子所需的 完整天数 。每天，你只能为播种某一枚种子而劳作。无须 连续几天都在种同一枚种子，但是种子播种必须在你工作的天数达到 plantTime[i] 之后才算完成。
     * growTime[i] 是第 i 枚种子完全种下后生长所需的 完整天数 。在它生长的最后一天 之后 ，将会开花并且永远 绽放 。
     * 从第 0 开始，你可以按 任意 顺序播种种子。
     *
     * 返回所有种子都开花的 最早 一天是第几天。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：plantTime = [1,4,3], growTime = [2,3,1]
     * 输出：9
     * 解释：灰色的花盆表示播种的日子，彩色的花盆表示生长的日子，花朵表示开花的日子。
     * 一种最优方案是：
     * 第 0 天，播种第 0 枚种子，种子生长 2 整天。并在第 3 天开花。
     * 第 1、2、3、4 天，播种第 1 枚种子。种子生长 3 整天，并在第 8 天开花。
     * 第 5、6、7 天，播种第 2 枚种子。种子生长 1 整天，并在第 9 天开花。
     * 因此，在第 9 天，所有种子都开花。
     * 示例 2：
     *
     *
     * 输入：plantTime = [1,2,3,2], growTime = [2,1,2,1]
     * 输出：9
     * 解释：灰色的花盆表示播种的日子，彩色的花盆表示生长的日子，花朵表示开花的日子。
     * 一种最优方案是：
     * 第 1 天，播种第 0 枚种子，种子生长 2 整天。并在第 4 天开花。
     * 第 0、3 天，播种第 1 枚种子。种子生长 1 整天，并在第 5 天开花。
     * 第 2、4、5 天，播种第 2 枚种子。种子生长 2 整天，并在第 8 天开花。
     * 第 6、7 天，播种第 3 枚种子。种子生长 1 整天，并在第 9 天开花。
     * 因此，在第 9 天，所有种子都开花。
     * 示例 3：
     *
     * 输入：plantTime = [1], growTime = [1]
     * 输出：2
     * 解释：第 0 天，播种第 0 枚种子。种子需要生长 1 整天，然后在第 2 天开花。
     * 因此，在第 2 天，所有种子都开花。
     *
     *
     * 提示：
     *
     * n == plantTime.length == growTime.length
     * 1 <= n <= 10^5
     * 1 <= plantTime[i], growTime[i] <= 10^4
     */
    static class Solution {
        public static int earliestFullBloom(int[] plantTime, int[] growTime) {
            // 思路就是对开花期时长进行排序，开花期越长的越先种
            Map<Integer, Deque<Integer>> map = new TreeMap<>(Comparator.reverseOrder());
            for (int i = 0; i < growTime.length; i++) {
                Deque<Integer> list;
                if (null == map.get(growTime[i])) {
                    list = new ArrayDeque<>();
                } else {
                    list = map.get(growTime[i]);
                }
                list.add(plantTime[i]);
                map.put(growTime[i], list);
            }
            int ans = 0;
            int max = 0;
            for (Map.Entry<Integer, Deque<Integer>> entry : map.entrySet()) {
                Integer key = entry.getKey();
                Deque<Integer> queue = entry.getValue();
                while (!queue.isEmpty()) {
                    Integer pop = queue.pop();
                    max = Math.max(max, ans + key + pop);
                    ans += pop;
                }
            }
            return max;
        }

        public static void main(String[] args) {
            System.out.println(earliestFullBloom(new int[]{2,6}, new int[]{5,5}));
        }
    }
}
