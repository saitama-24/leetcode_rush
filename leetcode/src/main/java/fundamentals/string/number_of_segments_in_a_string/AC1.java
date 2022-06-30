package fundamentals.string.number_of_segments_in_a_string;

/**
 * @ClassName: AC1
 * @Description: 434. 字符串中的单词数
 * @Author: 琦玉
 * @Date: 2022年06月30日 14:02:41
 */
public class AC1 {

    /**
     * 434. 字符串中的单词数
     * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
     * <p>
     * 请注意，你可以假定字符串里不包括任何不可打印的字符。
     * <p>
     * 示例:
     * <p>
     * 输入: "Hello, my name is John"
     * 输出: 5
     * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
     */
    static class Solution {
        public static int countSegments(String s) {
            String[] split = s.split("\\s+");
            int count = 0;
            for (String s1 : split) {
                if (!"".equals(s1)) {
                    count++;
                }
            }
            return count;
        }

        public static void main(String[] args) {
            System.out.println(countSegments("    foo    bar"));
        }
    }
}
