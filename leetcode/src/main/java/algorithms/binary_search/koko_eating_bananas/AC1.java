package algorithms.binary_search.koko_eating_bananas;

/**
 * @ClassName: AC1
 * @Description: 875. 爱吃香蕉的珂珂
 * @Author: 琦玉
 * @Date: 2022年06月07日 15:06:29
 */
public class AC1 {

    /**
     * 875. 爱吃香蕉的珂珂
     * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
     * <p>
     * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
     * <p>
     * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
     * <p>
     * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：piles = [3,6,7,11], h = 8
     * 输出：4
     * 示例 2：
     * <p>
     * 输入：piles = [30,11,23,4,20], h = 5
     * 输出：30
     * 示例 3：
     * <p>
     * 输入：piles = [30,11,23,4,20], h = 6
     * 输出：23
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= piles.length <= 10^4
     * piles.length <= h <= 10^9
     * 1 <= piles[i] <= 10^9
     */
    static class Solution {
        public static int minEatingSpeed(int[] piles, int h) {
            int low = 1;
            int high = piles[0];
            for (int pile : piles) {
                high = Math.max(high, pile);
            }
            int k = high;
            while (low < high) {
                int speed = (high - low) / 2 + low;
                int time = getTime(piles, speed);
                if (time > h) {
                    low = speed + 1;
                } else {
                    k = speed;
                    high = speed;
                }
            }
            return k;
        }

        private static int getTime(int[] piles, int speed) {
            int time = 0;
            for (int pile : piles) {
                if (speed >= pile) {
                    time++;
                } else {
                    time += pile / speed;
                    if (pile % speed > 0) {
                        time++;
                    }
                }
            }
            return time;
        }

        public static void main(String[] args) {
            System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        }
    }
}
