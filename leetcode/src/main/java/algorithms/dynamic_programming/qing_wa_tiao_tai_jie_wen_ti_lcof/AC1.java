package algorithms.dynamic_programming.qing_wa_tiao_tai_jie_wen_ti_lcof;

/**
 * @ClassName: AC1
 * @Description: 剑指 Offer 10- II. 青蛙跳台阶问题
 * @Author: 琦玉
 * @Date: 2022年04月27日 17:00:21
 */
public class AC1 {

    /**
     * 剑指 Offer 10- II. 青蛙跳台阶问题
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：2
     * 示例 2：
     *
     * 输入：n = 7
     * 输出：21
     * 示例 3：
     *
     * 输入：n = 0
     * 输出：1
     * 提示：
     *
     * 0 <= n <= 100
     */
    static class Solution {
        public static int numWays(int n) {
            if (n < 2) {
                return 1;
            }
            int p, q = 1, r = 1;
            int mod = 1000000007;
            for (int i = 2; i <= n; i++) {
                p = q;
                q = r;
                r = (p + q) % mod;
            }
            return r;
        }

        public static void main(String[] args) {
            System.out.println(numWays(44));
        }
    }
}
