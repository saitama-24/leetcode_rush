package algorithms.dynamic_programming.count_sorted_vowel_strings;

/**
 * @ClassName: AC1
 * @Description: 1641. 统计字典序元音字符串的数目
 * @Author: 琦玉
 * @Date: 2022年04月29日 14:49:34
 */
public class AC1 {

    /**
     * 1641. 统计字典序元音字符串的数目
     * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
     *
     * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 1
     * 输出：5
     * 解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
     * 示例 2：
     *
     * 输入：n = 2
     * 输出：15
     * 解释：仅由元音组成的 15 个字典序字符串为
     * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
     * 注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
     * 示例 3：
     *
     * 输入：n = 33
     * 输出：66045
     *
     *
     * 提示：
     *
     * 1 <= n <= 50
     */
    static class Solution {
        public static int countVowelStrings(int n) {
            int[][] dp = new int[n][5];
            dp[0][0] = dp[0][1] = dp[0][2] = dp[0][3] = dp[0][4] = 1;
            for (int i = 1; i < n; i++) {
                dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2] + dp[i-1][3] + dp[i-1][4];
                dp[i][1] = dp[i-1][1] + dp[i-1][2] + dp[i-1][3] + dp[i-1][4];
                dp[i][2] = dp[i-1][2] + dp[i-1][3] + dp[i-1][4];
                dp[i][3] = dp[i-1][3] + dp[i-1][4];
                dp[i][4] = dp[i-1][4];
            }
            return dp[n-1][0] + dp[n-1][1] + dp[n-1][2] + dp[n-1][3] + dp[n-1][4];
        }

        public static void main(String[] args) {
            System.out.println(countVowelStrings(33));
        }
    }
}
