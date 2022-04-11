package leetcode_202204;

/**
 * @ClassName: QiYu20220411
 * @Description: QiYu20220411
 * @Author: 琦玉
 * @Date: 2022年04月11日 14:35:47
 */
public class QiYu20220411 {
    /**
     * 344. 反转字符串
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     *
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = ["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     * 示例 2：
     *
     * 输入：s = ["H","a","n","n","a","h"]
     * 输出：["h","a","n","n","a","H"]
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 105
     * s[i] 都是 ASCII 码表中的可打印字符
     */
    static class Solution {
        public static void reverseString(char[] s) {
            int len = s.length;
            int head = 0;
            int tail = len - 1;

            while (head < tail) {
                if (s[head] != s[tail]) {
                    char temp = s[head];
                    s[head] = s[tail];
                    s[tail] = temp;
                }
                head ++;
                tail --;
            }
        }

        public static void main(String[] args) {
            reverseString(new char[]{'h','e','l','l','o'});
        }
    }

    /**
     * 557. 反转字符串中的单词 III
     * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     * 示例 2:
     *
     * 输入： s = "God Ding"
     * 输出："doG gniD"
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 5 * 104
     * s 包含可打印的 ASCII 字符。
     * s 不包含任何开头或结尾空格。
     * s 里 至少 有一个词。
     * s 中的所有单词都用一个空格隔开。
     */
    static class Solution1 {
        public static String reverseWords(String s) {
            String[] strings = s.split(" ");
            StringBuilder resultStr = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                char[] chars = strings[i].toCharArray();
                int len = chars.length;
                int head = 0;
                int tail = len - 1;

                while (head < tail) {
                    if (chars[head] != chars[tail]) {
                        char temp = chars[head];
                        chars[head] = chars[tail];
                        chars[tail] = temp;
                    }
                    head ++;
                    tail --;
                }
                resultStr.append(String.valueOf(chars));
                if (i != strings.length - 1) {
                    resultStr.append(" ");
                }
            }
            return resultStr.toString();
        }

        public static void main(String[] args) {
            System.out.println(reverseWords("Let's take LeetCode contest"));
        }
    }


}
