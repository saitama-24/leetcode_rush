package algorithms.greedy.partition_labels;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhenjie
 * @description 763. 划分字母区间
 * @date 2022-05-16 21:30:48
 */
public class AC1 {

    /**
     * 763. 划分字母区间
     * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
     * <p>
     * <p>
     * <p>
     * 示例：
     * <p>
     * 输入：S = "ababcbacadefegdehijhklij"
     * 输出：[9,7,8]
     * 解释：
     * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
     * 每个字母最多出现在一个片段中。
     * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
     * <p>
     * <p>
     * 提示：
     * <p>
     * S的长度在[1, 500]之间。
     * S只包含小写字母 'a' 到 'z' 。
     * 通过次数114,125提交次数148,929
     */
    static class Solution {
        public static List<Integer> partitionLabels(String s) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                int max = s.lastIndexOf(s.charAt(i));
                int newMax = getMaxIdxOf(s, i + 1, max);
                list.add(newMax - i + 1);
                i = newMax;
            }
            return list;
        }

        public static int getMaxIdxOf(String s, int from, int end) {
            int max = end;
            for (int i = from; i < end; i++) {
                int newMax = s.lastIndexOf(s.charAt(i));
                if (newMax > max) {
                    max = getMaxIdxOf(s, i + 1, newMax);
                }
            }
            return max;
        }

        public static void main(String[] args) {
            System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        }
    }
}
