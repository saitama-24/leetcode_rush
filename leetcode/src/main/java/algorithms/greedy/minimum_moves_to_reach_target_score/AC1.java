package algorithms.greedy.minimum_moves_to_reach_target_score;

/**
 * @ClassName: AC1
 * @Description: 2139. 得到目标值的最少行动次数
 * @Author: 琦玉
 * @Date: 2022年08月01日 17:21:02
 */
public class AC1 {

    /**
     * 2139. 得到目标值的最少行动次数
     * 你正在玩一个整数游戏。从整数 1 开始，期望得到整数 target 。
     * <p>
     * 在一次行动中，你可以做下述两种操作之一：
     * <p>
     * 递增，将当前整数的值加 1（即， x = x + 1）。
     * 加倍，使当前整数的值翻倍（即，x = 2 * x）。
     * 在整个游戏过程中，你可以使用 递增 操作 任意 次数。但是只能使用 加倍 操作 至多 maxDoubles 次。
     * <p>
     * 给你两个整数 target 和 maxDoubles ，返回从 1 开始得到 target 需要的最少行动次数。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：target = 5, maxDoubles = 0
     * 输出：4
     * 解释：一直递增 1 直到得到 target 。
     * 示例 2：
     * <p>
     * 输入：target = 19, maxDoubles = 2
     * 输出：7
     * 解释：最初，x = 1 。
     * 递增 3 次，x = 4 。
     * 加倍 1 次，x = 8 。
     * 递增 1 次，x = 9 。
     * 加倍 1 次，x = 18 。
     * 递增 1 次，x = 19 。
     * 示例 3：
     * <p>
     * 输入：target = 10, maxDoubles = 4
     * 输出：4
     * 解释：
     * 最初，x = 1 。
     * 递增 1 次，x = 2 。
     * 加倍 1 次，x = 4 。
     * 递增 1 次，x = 5 。
     * 加倍 1 次，x = 10 。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= target <= 10^9
     * 0 <= maxDoubles <= 100
     */
    static class Solution {
        public static int minMoves(int target, int maxDoubles) {
            int res = 0;
            while (maxDoubles > 0 && target != 1) {
                if ((target & 1) == 1) {
                    target -= 1;
                } else {
                    target /= 2;
                    maxDoubles--;
                }
                res++;
            }
            res += target - 1;
            return res;
        }

        public static void main(String[] args) {
            System.out.println(minMoves(2, 0));
        }
    }
}
