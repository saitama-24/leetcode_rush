package fundamentals.string.check_if_the_sentence_is_pangram;

/**
 * @author wangzhenjie
 * @version 1.0
 * @date 2022/12/13 11:13
 * @className: AC1
 * @description: // 1832. 判断句子是否为全字母句
 */
public class AC1 {

    /**
     * 1832. 判断句子是否为全字母句
     * 简单
     * 46
     * 相关企业
     * 全字母句 指包含英语字母表中每个字母至少一次的句子。
     *
     * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
     *
     * 如果是，返回 true ；否则，返回 false 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
     * 输出：true
     * 解释：sentence 包含英语字母表中每个字母至少一次。
     * 示例 2：
     *
     * 输入：sentence = "leetcode"
     * 输出：false
     *
     *
     * 提示：
     *
     * 1 <= sentence.length <= 1000
     * sentence 由小写英语字母组成
     */
    static class Solution {
        public static boolean checkIfPangram(String sentence) {
            int[] arr = new int[26];
            for (int i = 0; i < sentence.length(); i++) {
                arr[sentence.charAt(i) - 97]++;
            }
            for (int j : arr) {
                if (j == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
