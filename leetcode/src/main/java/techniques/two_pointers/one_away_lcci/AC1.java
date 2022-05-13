package techniques.two_pointers.one_away_lcci;

/**
 * @ClassName: AC1
 * @Description: 面试题 01.05. 一次编辑
 * @Author: 琦玉
 * @Date: 2022年05月13日 17:12:52
 */
public class AC1 {

    /**
     * 面试题 01.05. 一次编辑
     * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
     *
     *
     *
     * 示例 1:
     *
     * 输入:
     * first = "pale"
     * second = "ple"
     * 输出: True
     *
     *
     * 示例 2:
     *
     * 输入:
     * first = "pales"
     * second = "pal"
     * 输出: False
     */
    static class Solution {
        public static boolean oneEditAway(String first, String second) {
            if (first.equals(second)) {
                return true;
            }
            if (Math.abs(first.length() - second.length()) > 1) {
                return false;
            }
            int fLen = first.length();
            int sLen = second.length();
            if (fLen == sLen) {
                // 长度相同的情况
                int count = 0;
                for (int i = 0; i < fLen; i++) {
                    if (first.charAt(i) != second.charAt(i)) {
                        count ++;
                    }
                    if (count > 1) {
                        return false;
                    }
                }
                return true;
            } else {
                if (fLen > sLen) {
                    return oneInsert(second, first);
                } else {
                    return oneInsert(first, second);
                }
            }
        }

        public static boolean oneInsert(String shorter, String longer) {
            int sLen = shorter.length(), lLen = longer.length();
            int index1 = 0, index2 = 0;
            while (index1 < sLen && index2 < lLen) {
                if (shorter.charAt(index1) == longer.charAt(index2)) {
                    index1++;
                }
                index2++;
                if (index2 - index1 > 1) {
                    return false;
                }
            }
            return true;
        }
    }
}
