package fundamentals.string.goat_latin;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: AC1
 * @Description: AC1
 * @Author: 琦玉
 * @Date: 2022年04月21日 14:28:31
 */
public class AC1 {

    /**
     * 824. 山羊拉丁文
     * 给你一个由若干单词组成的句子 sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。
     *
     * 请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。山羊拉丁文的规则如下：
     *
     * 如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
     * 例如，单词 "apple" 变为 "applema" 。
     * 如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
     * 例如，单词 "goat" 变为 "oatgma" 。
     * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
     * 例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
     * 返回将 sentence 转换为山羊拉丁文后的句子。
     *
     *
     *
     * 示例 1：
     *
     * 输入：sentence = "I speak Goat Latin"
     * 输出："Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
     * 示例 2：
     *
     * 输入：sentence = "The quick brown fox jumped over the lazy dog"
     * 输出："heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
     *
     *
     * 提示：
     *
     * 1 <= sentence.length <= 150
     * sentence 由英文字母和空格组成
     * sentence 不含前导或尾随空格
     * sentence 中的所有单词由单个空格分隔
     */
    static class Solution {
        public static String toGoatLatin(String sentence) {
            String[] strings = sentence.split(" ");
            Set<Character> set = new HashSet<>();
            set.add('a');
            set.add('e');
            set.add('i');
            set.add('o');
            set.add('u');
            set.add('A');
            set.add('E');
            set.add('I');
            set.add('O');
            set.add('U');

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                String newStr = strings[i];
                int len = newStr.length();
                if (!set.contains(newStr.charAt(0)) && len > 1) {
                    char[] chars = newStr.toCharArray();
                    char temp = chars[0];
                    System.arraycopy(chars, 1, chars, 0, chars.length - 1);
                    chars[chars.length-1] = temp;
                    newStr = new String(chars);
                }
                stringBuilder.append(newStr).append("ma");
                for (int j = 0; j < i+1; j++) {
                    stringBuilder.append("a");
                }
                if (i != strings.length - 1) {
                    stringBuilder.append(" ");
                }
            }
            return stringBuilder.toString();
        }

        public static void main(String[] args) {
            String case1 = "Imaa peaksmaaa oatGmaaaa atinLmaaaaa";
            String case2 = "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa";
            System.out.println(case1.equals(toGoatLatin("I speak Goat Latin")));
            System.out.println(case2.equals(toGoatLatin("The quick brown fox jumped over the lazy dog")));
        }
    }
}
