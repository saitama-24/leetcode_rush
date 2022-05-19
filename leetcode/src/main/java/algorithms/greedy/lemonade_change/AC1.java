package algorithms.greedy.lemonade_change;

/**
 * @ClassName: AC1
 * @Description: 860. 柠檬水找零
 * @Author: 琦玉
 * @Date: 2022年05月19日 17:17:29
 */
public class AC1 {

    /**
     * 860. 柠檬水找零
     * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
     *
     * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
     *
     * 注意，一开始你手头没有任何零钱。
     *
     * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：bills = [5,5,5,10,20]
     * 输出：true
     * 解释：
     * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
     * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
     * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
     * 由于所有客户都得到了正确的找零，所以我们输出 true。
     * 示例 2：
     *
     * 输入：bills = [5,5,10,10,20]
     * 输出：false
     * 解释：
     * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
     * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
     * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
     * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
     *
     *
     * 提示：
     *
     * 1 <= bills.length <= 10^5
     * bills[i] 不是 5 就是 10 或是 20
     */
    static class Solution {
        public static boolean lemonadeChange(int[] bills) {
            if (bills[0] != 5) {
                return false;
            }
            // 用于存储5和10元零钱的数组
            int[] arr = new int[2];
            for (int bill : bills) {
                if (bill == 5) {
                    arr[0]++;
                } else if (bill == 10) {
                    // 10块需要找5块零，并收10块零
                    arr[0]--;
                    arr[1]++;
                } else {
                    // 20的如果有10块的，就找10+5，否则需要找3张5元
                    if (arr[1] > 0) {
                        arr[1]--;
                        arr[0]--;
                    } else {
                        arr[0] -= 3;
                    }
                }
                // 最后需要判断是否超出零钱剩余限制
                if (arr[0] < 0 || arr[1] < 0) {
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            System.out.println(lemonadeChange(new int[]{5,5,5,10,20}));
        }
    }
}
