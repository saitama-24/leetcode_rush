package fundamentals.array.find_and_replace_pattern;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: AC1
 * @Description: 890. 查找和替换模式
 * @Author: 琦玉
 * @Date: 2022年07月06日 16:58:02
 */
public class AC1 {

    /**
     * 890. 查找和替换模式
     * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
     * <p>
     * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
     * <p>
     * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
     * <p>
     * 返回 words 中与给定模式匹配的单词列表。
     * <p>
     * 你可以按任何顺序返回答案。
     * <p>
     * <p>
     * <p>
     * 示例：
     * <p>
     * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
     * 输出：["mee","aqq"]
     * 解释：
     * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
     * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
     * 因为 a 和 b 映射到同一个字母。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= words.length <= 50
     * 1 <= pattern.length = words[i].length <= 20
     */
    static class Solution {
        public static List<String> findAndReplacePattern(String[] words, String pattern) {
            List<String> pattern1 = getPattern(words, pattern.length());
            List<String> pattern2 = getPattern(new String[]{pattern}, pattern.length());
            List<String> list = new ArrayList<>();
            for (int i = 0; i < pattern1.size(); i++) {
                if (pattern1.get(i).equals(pattern2.get(0))) {
                    list.add(words[i]);
                }
            }
            return list;
        }

        private static List<String> getPattern(String[] words, int len) {
            List<String> list = new ArrayList<>();
            for (String word : words) {
                int[] arr = new int[26];
                int count = 0;
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < word.length(); i++) {
                    int idx = word.charAt(i) - 97;
                    if (arr[idx] == 0) {
                        count++;
                        arr[idx] = count;
                    }
                    stringBuilder.append(arr[idx]).append(",");
                }
                list.add(stringBuilder.toString());
            }
            return list;
        }

        public static void main(String[] args) {
            System.out.println(findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "abb"));
        }
    }
}
