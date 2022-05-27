package fundamentals.array.find_closest_lcci;

/**
 * @ClassName: AC1
 * @Description: 面试题 17.11. 单词距离
 * @Author: 琦玉
 * @Date: 2022年05月27日 13:49:56
 */
public class AC1 {

    /**
     * 面试题 17.11. 单词距离
     * 有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
     *
     * 示例：
     *
     * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
     * 输出：1
     * 提示：
     *
     * words.length <= 100000
     */
    static class Solution {
        public static int findClosest(String[] words, String word1, String word2) {
            int len = words.length;
            int idx1 = -1;
            int idx2 = -1;
            int ans = len;
            for (int i = 0; i < len; i++) {
                if (word1.equals(words[i])) {
                    idx1 = i;
                } else if (word2.equals(words[i])) {
                    idx2 = i;
                }
                if (idx1 >= 0 && idx2 >= 0) {
                    ans = Math.min(ans, Math.abs(idx1 - idx2));
                    if (ans == 1) {
                        return ans;
                    }
                }
            }
            return ans;
        }
    }
}
