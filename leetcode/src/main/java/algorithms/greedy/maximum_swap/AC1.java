package algorithms.greedy.maximum_swap;

import java.util.*;

/**
 * @author wangzhenjie
 * @version 1.0
 * @date 2022/10/12 21:08
 * @className: AC1
 * @description: // 670. 最大交换
 */
public class AC1 {
    /**
     * 670. 最大交换
     * 中等
     * 373
     * 相关企业
     * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
     *
     * 示例 1 :
     *
     * 输入: 2736
     * 输出: 7236
     * 解释: 交换数字2和数字7。
     * 示例 2 :
     *
     * 输入: 9973
     * 输出: 9973
     * 解释: 不需要交换。
     * 注意:
     *
     * 给定数字的范围是 [0, 10^8]
     */
    static class Solution {
        public static int maximumSwap(int num) {
            // 记录每个数字的出现次数，用于拼成理论最大数
            int[] arr = new int[10];
            // 记录每个数字对应的索引列表
            Map<Integer, List<Integer>> map = new HashMap<>();
            String numStr = String.valueOf(num);
            for (int i = 0; i < numStr.length(); i++) {
                int digit = numStr.charAt(i) - '0';
                arr[digit]++;
                List<Integer> list = map.get(digit);
                if (null == list) {
                    list = new ArrayList<>();
                }
                list.add(i);
                map.put(digit, list);
            }
            StringBuilder theoryNum = new StringBuilder();
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] != 0) {
                    for (int j = 0; j < arr[i]; j++) {
                        // 拼成理论最大数，用于对比
                        theoryNum.append(i);
                    }
                }
            }
            int idx1 = -1;
            int idx2 = -1;
            for (int i = 0; i < theoryNum.length(); i++) {
                if (theoryNum.charAt(i) != numStr.charAt(i)) {
                    // 对比理论最大数，如果发现有不一样的数，则取该数最大一个索引的位置进行调换
                    List<Integer> list = map.get(theoryNum.charAt(i) - '0');
                    idx1 = list.get(list.size() - 1);
                    idx2 = i;
                    break;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < numStr.length(); i++) {
                int realIdx = i;
                if (i == idx2) {
                    realIdx = idx1;
                } else if (i == idx1){
                    realIdx = idx2;
                }
                stringBuilder.append(numStr.charAt(realIdx));
            }
            return Integer.parseInt(stringBuilder.toString());
        }

        public static void main(String[] args) {
            System.out.println(maximumSwap(232267543));
        }
    }
}
