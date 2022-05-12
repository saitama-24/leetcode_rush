package fundamentals.array.delete_columns_to_make_sorted;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: AC1
 * @Description: 944. 删列造序
 * @Author: 琦玉
 * @Date: 2022年05月12日 10:01:02
 */
public class AC1 {

    /**
     * 944. 删列造序
     * 给你由 n 个小写字母字符串组成的数组 strs，其中每个字符串长度相等。
     *
     * 这些字符串可以每个一行，排成一个网格。例如，strs = ["abc", "bce", "cae"] 可以排列为：
     *
     * abc
     * bce
     * cae
     *
     * 返回你需要删除的列数。
     *
     *
     *
     * 示例 1：
     *
     * 输入：strs = ["cba","daf","ghi"]
     * 输出：1
     * 解释：网格示意如下：
     *   cba
     *   daf
     *   ghi
     * 列 0 和列 2 按升序排列，但列 1 不是，所以只需要删除列 1 。
     * 示例 2：
     *
     * 输入：strs = ["a","b"]
     * 输出：0
     * 解释：网格示意如下：
     *   a
     *   b
     * 只有列 0 这一列，且已经按升序排列，所以不用删除任何列。
     * 示例 3：
     *
     * 输入：strs = ["zyx","wvu","tsr"]
     * 输出：3
     * 解释：网格示意如下：
     *   zyx
     *   wvu
     *   tsr
     * 所有 3 列都是非升序排列的，所以都要删除。
     *
     *
     * 提示：
     *
     * n == strs.length
     * 1 <= n <= 100
     * 1 <= strs[i].length <= 1000
     * strs[i] 由小写英文字母组成
     */
    static class Solution {
        public static int minDeletionSize(String[] strs) {
            int count = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i < strs.length; i++) {
                char[] currChars = strs[i].toCharArray();
                char[] preChars = strs[i - 1].toCharArray();
                for (int j = 0; j < currChars.length; j++) {
                    if (map.get(j) == null) {
                        if (currChars[j] < preChars[j]) {
                            count++;
                            map.put(j, 1);
                        }
                    }
                }
            }
            return count;
        }

        public static void main(String[] args) {
            System.out.println(minDeletionSize(new String[]{"a","b"}));
        }
    }
}
