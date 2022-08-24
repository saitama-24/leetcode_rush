package algorithms.greedy.largest_number;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: AC1
 * @Description: 179. 最大数
 * @Author: 琦玉
 * @Date: 2022年08月24日 16:16:55
 */
public class AC1 {

    /**
     * 179. 最大数
     * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
     * <p>
     * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [10,2]
     * 输出："210"
     * 示例 2：
     * <p>
     * 输入：nums = [3,30,34,5,9]
     * 输出："9534330"
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 10^9
     */
    static class Solution {
        public static String largestNumber(int[] nums) {
            StringBuilder stringBuilder = new StringBuilder();
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            while (list.size() > 0) {
                int num = list.get(0);
                int removeIdx = 0;
                for (int i = 1; i < list.size(); i++) {
                    int pickIdx = getPickIdx(num, list.get(i));
                    if (pickIdx == 1) {
                        num = list.get(i);
                        removeIdx = i;
                    }
                }
                stringBuilder.append(num);
                list.remove(removeIdx);
            }
            String s = stringBuilder.toString();
            if (s.charAt(0) == '0' && s.length() > 1) {
                return "0";
            }
            return s;
        }

        private static int getPickIdx(int num1, int num2) {
            if (num1 == num2) {
                return 0;
            }
            String str1 = num1 + String.valueOf(num2);
            String str2 = num2 + String.valueOf(num1);
            return Long.parseLong(str1) > Long.parseLong(str2) ? 0 : 1;
        }

        public static void main(String[] args) {
            System.out.println(largestNumber(new int[]{0,0}));
        }
    }
}
