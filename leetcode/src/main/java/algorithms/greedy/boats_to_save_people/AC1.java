package algorithms.greedy.boats_to_save_people;

import java.util.Arrays;

/**
 * @ClassName: AC1
 * @Description: 881. 救生艇
 * @Author: 琦玉
 * @Date: 2022年06月09日 17:39:02
 */
public class AC1 {

    /**
     * 881. 救生艇
     * 给定数组 people 。people[i]表示第 i 个人的体重 ，船的数量不限，每艘船可以承载的最大重量为 limit。
     * <p>
     * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
     * <p>
     * 返回 承载所有人所需的最小船数 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：people = [1,2], limit = 3
     * 输出：1
     * 解释：1 艘船载 (1, 2)
     * 示例 2：
     * <p>
     * 输入：people = [3,2,2,1], limit = 3
     * 输出：3
     * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
     * 示例 3：
     * <p>
     * 输入：people = [3,5,3,4], limit = 5
     * 输出：4
     * 解释：4 艘船分别载 (3), (3), (4), (5)
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= people.length <= 5 * 10^4
     * 1 <= people[i] <= limit <= 3 * 10^4
     */
    static class Solution {
        public static int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);
            int len = people.length;
            int low = 0;
            int high = len - 1;
            int res = 0;
            while (low <= high) {
                if (people[low] + people[high] <= limit) {
                    low++;
                }
                high--;
                res++;
            }
            return res;
        }

        public static void main(String[] args) {
            System.out.println(numRescueBoats(new int[]{1,1,3,5,3}, 5));
        }
    }
}
