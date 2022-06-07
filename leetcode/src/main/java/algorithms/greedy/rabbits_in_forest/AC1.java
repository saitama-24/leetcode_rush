package algorithms.greedy.rabbits_in_forest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: AC1
 * @Description: 781. 森林中的兔子
 * @Author: 琦玉
 * @Date: 2022年06月07日 17:05:31
 */
public class AC1 {

    /**
     * 781. 森林中的兔子
     * 森林中有未知数量的兔子。提问其中若干只兔子 "还有多少只兔子与你（指被提问的兔子）颜色相同?" ，将答案收集到一个整数数组 answers 中，其中 answers[i] 是第 i 只兔子的回答。
     * <p>
     * 给你数组 answers ，返回森林中兔子的最少数量。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：answers = [1,1,2]
     * 输出：5
     * 解释：
     * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
     * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
     * 设回答了 "2" 的兔子为蓝色。
     * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
     * 因此森林中兔子的最少数量是 5 只：3 只回答的和 2 只没有回答的。
     * 示例 2：
     * <p>
     * 输入：answers = [10,10,10]
     * 输出：11
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= answers.length <= 1000
     * 0 <= answers[i] < 1000
     */
    static class Solution {
        public static int numRabbits(int[] answers) {
            Arrays.sort(answers);
            int sum = answers[0] + 1;
            int prev = answers[0];
            // 用于存储表示相同数量的兔子的个数
            Map<Integer, Integer> map = new HashMap<>();
            map.put(prev, 1);
            for (int i = 1; i < answers.length; i++) {
                if (answers[i] == prev && map.get(answers[i]) < answers[i] + 1) {
                    // 虽然表示的数量一样，但是还需要判断是否超出最大容量，超出不能表示为同一颜色的兔子
                    map.put(answers[i], map.get(answers[i]) + 1);
                    continue;
                }
                // 重新计数
                map.put(answers[i], 1);
                sum += answers[i] + 1;
                prev = answers[i];
            }
            return sum;
        }

        public static void main(String[] args) {
            System.out.println(numRabbits(new int[]{1, 1, 1, 2}));
        }
    }
}
