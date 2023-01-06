package fundamentals.simulation.count_integers_with_even_digit_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: AC1
 * @Description: 2180. 统计各位数字之和为偶数的整数个数
 * @Author: 琦玉
 * @Date: 2023年01月06日 16:55:54
 */
public class AC1 {

    /**
     * 2180. 统计各位数字之和为偶数的整数个数
     * 简单
     * 47
     * 相关企业
     * 给你一个正整数 num ，请你统计并返回 小于或等于 num 且各位数字之和为 偶数 的正整数的数目。
     *
     * 正整数的 各位数字之和 是其所有位上的对应数字相加的结果。
     *
     *
     *
     * 示例 1：
     *
     * 输入：num = 4
     * 输出：2
     * 解释：
     * 只有 2 和 4 满足小于等于 4 且各位数字之和为偶数。
     * 示例 2：
     *
     * 输入：num = 30
     * 输出：14
     * 解释：
     * 只有 14 个整数满足小于等于 30 且各位数字之和为偶数，分别是：
     * 2、4、6、8、11、13、15、17、19、20、22、24、26 和 28 。
     *
     *
     * 提示：
     *
     * 1 <= num <= 1000
     */
    static class Solution {
        public static int countEven(int num) {
            Map<Integer, Boolean> map = new HashMap<>(num);
            int count = 0;
            for (int i = 1; i <= num; i++) {
                int temp = i;
                int sum = 0;
                while (temp > 0) {
                    if (null != map.get(temp)) {
                        sum = ((sum & 1) == 1 ? !map.get(temp) : map.get(temp)) ? 0 : 1;
                        break;
                    }
                    int n = temp % 10;
                    temp /= 10;
                    sum += n;
                }
                if ((sum & 1) == 0) {
                    map.put(i, true);
                    count++;
                } else {
                    map.put(i, false);
                }
            }
            return count;
        }

        public static void main(String[] args) {
            System.out.println(countEven(1000));
        }
    }

}
