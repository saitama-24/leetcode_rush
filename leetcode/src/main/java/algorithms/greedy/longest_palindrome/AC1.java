package algorithms.greedy.longest_palindrome;

/**
 * @ClassName: AC1
 * @Description: 409. 最长回文串
 * @Author: 琦玉
 * @Date: 2022年06月09日 16:59:47
 */
public class AC1 {

    /**
     * 409. 最长回文串
     * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
     *
     * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
     *
     *
     *
     * 示例 1:
     *
     * 输入:s = "abccccdd"
     * 输出:7
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     * 示例 2:
     *
     * 输入:s = "a"
     * 输入:1
     * 示例 3:
     *
     * 输入:s = "bb"
     * 输入: 2
     *
     *
     * 提示:
     *
     * 1 <= s.length <= 2000
     * s 只能由小写和/或大写英文字母组成
     */
    static class Solution {
        public static int longestPalindrome(String s) {
            int[] arr = new int[58];
            for (char c : s.toCharArray()) {
                arr[c - 65]++;
            }
            boolean haveOne = false;
            boolean haveOdd = false;
            int res = 0;
            for (int i : arr) {
                if (i == 0) {
                    continue;
                }
                if (i == 1 && !haveOne) {
                    res++;
                    haveOne = true;
                } else if ((i & 1) != 1) {
                    res += i;
                } else if ((i & 1) == 1) {
                    res += i - 1;
                    haveOdd = true;
                }
            }
            if (haveOdd && !haveOne) {
                res++;
            }
            return res;
        }

        public static void main(String[] args) {
            System.out.println(longestPalindrome("azAZ"));
        }
    }
}
