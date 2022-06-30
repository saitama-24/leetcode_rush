package common_data_structures.hash_table.x_of_a_kind_in_a_deck_of_cards;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: AC1
 * @Description: 914. 卡牌分组
 * @Author: 琦玉
 * @Date: 2022年06月30日 11:42:10
 */
public class AC1 {

    /**
     * 914. 卡牌分组
     * 给定一副牌，每张牌上都写着一个整数。
     * <p>
     * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
     * <p>
     * 每组都有 X 张牌。
     * 组内所有的牌上都写着相同的整数。
     * 仅当你可选的 X >= 2 时返回 true。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：deck = [1,2,3,4,4,3,2,1]
     * 输出：true
     * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
     * 示例 2：
     * <p>
     * 输入：deck = [1,1,1,2,2,2,3,3]
     * 输出：false
     * 解释：没有满足要求的分组。
     * <p>
     * 提示：
     * <p>
     * 1 <= deck.length <= 10^4
     * 0 <= deck[i] < 10^4
     */
    static class Solution {
        public static boolean hasGroupsSizeX(int[] deck) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : deck) {
                map.merge(i, 1, Integer::sum);
            }
            if (map.size() == 1) {
                return map.get(deck[0]) > 1;
            }
            int g = -1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (g == -1) {
                    g = entry.getValue();
                } else {
                    g = gcd(g, entry.getValue());
                }
            }
            return g >= 2;
        }

        public static void main(String[] args) {
            System.out.println(hasGroupsSizeX(new int[]{1,1,1,2,2}));
            System.out.println(gcd(20, 404));
        }

        private static int gcd(int a, int b) {
            return (b == 0) ? a : gcd(b, a % b);
        }
    }
}
