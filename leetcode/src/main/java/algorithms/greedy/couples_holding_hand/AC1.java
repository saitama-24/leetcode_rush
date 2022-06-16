package algorithms.greedy.couples_holding_hand;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: AC1
 * @Description: 765. 情侣牵手
 * @Author: 琦玉
 * @Date: 2022年06月16日 14:27:19
 */
public class AC1 {

    /**
     * 765. 情侣牵手
     * n 对情侣坐在连续排列的 2n 个座位上，想要牵到对方的手。
     * <p>
     * 人和座位由一个整数数组 row 表示，其中 row[i] 是坐在第 i 个座位上的人的 ID。情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2n-2, 2n-1)。
     * <p>
     * 返回 最少交换座位的次数，以便每对情侣可以并肩坐在一起。 每次交换可选择任意两人，让他们站起来交换座位。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: row = [0,2,1,3]
     * 输出: 1
     * 解释: 只需要交换row[1]和row[2]的位置即可。
     * 示例 2:
     * <p>
     * 输入: row = [3,2,0,1]
     * 输出: 0
     * 解释: 无需交换座位，所有的情侣都已经可以手牵手了。
     * <p>
     * <p>
     * 提示:
     * <p>
     * 2n == row.length
     * 2 <= n <= 30
     * n 是偶数
     * 0 <= row[i] < 2n
     * row 中所有元素均无重复
     */
    static class Solution {
        public static int minSwapsCouples(int[] row) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < row.length; i++) {
                map.put(row[i], i);
            }
            int ans = 0;
            for (int i = 0; i < row.length; i += 2) {
                int j = (row[i] & 1) == 0 ? row[i] + 1 : row[i] - 1;
                if (row[i + 1] != j) {
                    Integer idx = map.get(j);
                    int temp = row[i + 1];
                    row[i + 1] = j;
                    row[idx] = temp;
                    // 需要交换map里情侣的索引
                    map.put(temp, idx);
                    map.put(j, i + 1);
                    ans++;
                }
            }
            return ans;
        }

        public static void main(String[] args) {
            System.out.println(minSwapsCouples(new int[]{0,2,4,6,7,1,3,5}));
        }
    }
}
