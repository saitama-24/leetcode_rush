package algorithms.greedy.monotone_increasing_digits;

/**
 * @ClassName: AC1
 * @Description: 738. 单调递增的数字
 * @Author: 琦玉
 * @Date: 2022年06月20日 16:11:27
 */
public class AC1 {

    /**
     * 738. 单调递增的数字
     * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
     * <p>
     * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: n = 10
     * 输出: 9
     * 示例 2:
     * <p>
     * 输入: n = 1234
     * 输出: 1234
     * 示例 3:
     * <p>
     * 输入: n = 332
     * 输出: 299
     * <p>
     * <p>
     * 提示:
     * <p>
     * 0 <= n <= 10^9
     */
    static class Solution {
        public static int monotoneIncreasingDigits(int n) {
            char[] arr = (n + "").toCharArray();
            int max = -1, idx = -1;
            for (int i = 0; i < arr.length - 1; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                    idx = i;
                }
                if (arr[i] > arr[i + 1]) {
                    arr[idx] -= 1;
                    for (int j = idx + 1; j < arr.length; j++) {
                        arr[j] = '9';
                    }
                    break;
                }
            }
            return Integer.parseInt(new String(arr));
        }

        public static void main(String[] args) {
            System.out.println(monotoneIncreasingDigits(2333332));
        }
    }
}
