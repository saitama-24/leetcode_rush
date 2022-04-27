package algorithms.dynamic_programming.three_steps_problem_lcci;

/**
 * @ClassName: AC1
 * @Description: 面试题 08.01. 三步问题
 * @Author: 琦玉
 * @Date: 2022年04月27日 17:53:51
 */
public class AC1 {

    /**
     * 面试题 08.01. 三步问题
     * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
     *
     * 示例1:
     *
     *  输入：n = 3
     *  输出：4
     *  说明: 有四种走法
     * 示例2:
     *
     *  输入：n = 5
     *  输出：13
     * 提示:
     *
     * n范围在[1, 1000000]之间
     */
    static class Solution {
        public static int waysToStep(int n) {
            if (n < 3) {
                return n;
            }
            // 这里需要用double 不然会溢出
            double p, q = 1, r = 2, s = 4;
            int mod = 1000000007;
            for (int i = 3; i < n; i++) {
                p = q;
                q = r;
                r = s;
                s =  (p + q + r) % mod;
            }
            return (int) s;
        }

        public static void main(String[] args) {
            System.out.println(waysToStep(61));
        }
    }
}
