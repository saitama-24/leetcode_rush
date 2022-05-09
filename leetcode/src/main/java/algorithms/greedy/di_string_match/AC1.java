package algorithms.greedy.di_string_match;

import java.util.Arrays;

/**
 * @ClassName: AC1
 * @Description: 942. 增减字符串匹配
 * @Author: 琦玉
 * @Date: 2022年05月09日 17:56:15
 */
public class AC1 {

    /**
     * 942. 增减字符串匹配
     * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
     *
     * 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I'
     * 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D'
     * 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "IDID"
     * 输出：[0,4,1,3,2]
     * 示例 2：
     *
     * 输入：s = "III"
     * 输出：[0,1,2,3]
     * 示例 3：
     *
     * 输入：s = "DDI"
     * 输出：[3,2,0,1]
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 10^5
     * s 只包含字符 "I" 或 "D"
     */
    static class Solution {
        public static int[] diStringMatch(String s) {
            char[] chars = s.toCharArray();
            int minNum = 0;
            int maxNum = chars.length;
            int[] arr = new int[chars.length+1];
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'I') {
                    // 碰到字符'I'取剩下的最小数字，并步进1
                    arr[i] = minNum++;
                } else {
                    // 碰到字符'D'取剩下的最大数字，并递减1
                    arr[i] = maxNum--;
                }
            }
            // 最后一个位置直接取剩下的数字即可
            arr[chars.length] = minNum;
            return arr;
        }

        public static void main(String[] args) {
            System.out.println(Arrays.toString(diStringMatch("DDI")));
        }
    }

}
