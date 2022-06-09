package algorithms.greedy.remove_digit_from_number_to_maximize_result;

/**
 * @ClassName: AC1
 * @Description: 2259. 移除指定数字得到的最大结果
 * @Author: 琦玉
 * @Date: 2022年06月09日 14:19:08
 */
public class AC1 {

    /**
     * 2259. 移除指定数字得到的最大结果
     * 给你一个表示某个正整数的字符串 number 和一个字符 digit 。
     * <p>
     * 从 number 中 恰好 移除 一个 等于 digit 的字符后，找出并返回按 十进制 表示 最大 的结果字符串。生成的测试用例满足 digit 在 number 中出现至少一次。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：number = "123", digit = "3"
     * 输出："12"
     * 解释："123" 中只有一个 '3' ，在移除 '3' 之后，结果为 "12" 。
     * 示例 2：
     * <p>
     * 输入：number = "1231", digit = "1"
     * 输出："231"
     * 解释：可以移除第一个 '1' 得到 "231" 或者移除第二个 '1' 得到 "123" 。
     * 由于 231 > 123 ，返回 "231" 。
     * 示例 3：
     * <p>
     * 输入：number = "551", digit = "5"
     * 输出："51"
     * 解释：可以从 "551" 中移除第一个或者第二个 '5' 。
     * 两种方案的结果都是 "51" 。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 2 <= number.length <= 100
     * number 由数字 '1' 到 '9' 组成
     * digit 是 '1' 到 '9' 中的一个数字
     * digit 在 number 中出现至少一次
     */
    static class Solution {
        public static String removeDigit(String number, char digit) {
            int len = number.length();
            StringBuilder stringBuilder = new StringBuilder();
            int removeIdx = -1;
            for (int i = 1; i < len; i++) {
                if (number.charAt(i) != digit && number.charAt(i - 1) == digit) {
                    // 如果碰到不是目标字符，且前一个字符是目标字符的，需要标记目标字符索引
                    removeIdx = i - 1;
                    if (number.charAt(i) > digit) {
                        // 如果目标字符没有后一个数大，直接删除该目标字符，不需要继续
                        break;
                    }
                }
                if (i == len - 1 && number.charAt(i) == digit) {
                    removeIdx = i;
                }
            }
            for (int i = 0; i < len; i++) {
                if (i != removeIdx) {
                    stringBuilder.append(number.charAt(i));
                }
            }
            return stringBuilder.toString();
        }

        public static void main(String[] args) {
            System.out.println(removeDigit("73197", '7'));
        }
    }
}
