package algorithms.greedy.uOAnQW;

import java.util.Arrays;

/**
 * @ClassName: AC1
 * @Description: LCP 40. 心算挑战
 * @Author: 琦玉
 * @Date: 2022年08月03日 11:45:06
 */
public class AC1 {

    /**
     * LCP 40. 心算挑战
     * 「力扣挑战赛」心算项目的挑战比赛中，要求选手从 N 张卡牌中选出 cnt 张卡牌，若这 cnt 张卡牌数字总和为偶数，则选手成绩「有效」且得分为 cnt 张卡牌数字总和。
     * 给定数组 cards 和 cnt，其中 cards[i] 表示第 i 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分的卡牌方案，则返回 0。
     * <p>
     * 示例 1：
     * <p>
     * 输入：cards = [1,2,8,9], cnt = 3
     * <p>
     * 输出：18
     * <p>
     * 解释：选择数字为 1、8、9 的这三张卡牌，此时可获得最大的有效得分 1+8+9=18。
     * <p>
     * 示例 2：
     * <p>
     * 输入：cards = [3,3,1], cnt = 1
     * <p>
     * 输出：0
     * <p>
     * 解释：不存在获取有效得分的卡牌方案。
     * <p>
     * 提示：
     * <p>
     * 1 <= cnt <= cards.length <= 10^5
     * 1 <= cards[i] <= 1000
     */
    static class Solution {
        public static int maxmiumScore(int[] cards, int cnt) {
            Arrays.sort(cards);
            int res = 0;
            for (int i = cards.length - 1; i >= cards.length - cnt; i--) {
                res += cards[i];
            }
            if ((res & 1) == 0) {
                return res;
            }
            res -= cards[cards.length - cnt];
            boolean flag = false;
            for (int i = cards.length - cnt - 1; i >= 0; i--) {
                if ((cards[cards.length - cnt] & 1) == 0) {
                    if ((cards[i] & 1) == 1) {
                        res += cards[i];
                        flag = true;
                        break;
                    }
                } else {
                    if ((cards[i] & 1) == 0) {
                        res += cards[i];
                        flag = true;
                        break;
                    }
                }
            }
            return flag ? res : 0;
        }

        public static void main(String[] args) {
            System.out.println(maxmiumScore(new int[]{3,3,1}, 1));
        }
    }
}
