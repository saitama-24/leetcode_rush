package algorithms.greedy.two_city_scheduling;

import java.util.Arrays;

/**
 * @ClassName: AC1
 * @Description: 1029. 两地调度
 * @Author: 琦玉
 * @Date: 2022年05月12日 14:48:00
 */
public class AC1 {

    /**
     * 1029. 两地调度
     * 公司计划面试 2n 人。给你一个数组 costs ，其中 costs[i] = [aCosti, bCosti] 。第 i 人飞往 a 市的费用为 aCosti ，飞往 b 市的费用为 bCosti 。
     *
     * 返回将每个人都飞到 a 、b 中某座城市的最低费用，要求每个城市都有 n 人抵达。
     *
     *
     *
     * 示例 1：
     *
     * 输入：costs = [[10,20],[30,200],[400,50],[30,20]]
     * 输出：110
     * 解释：
     * 第一个人去 a 市，费用为 10。
     * 第二个人去 a 市，费用为 30。
     * 第三个人去 b 市，费用为 50。
     * 第四个人去 b 市，费用为 20。
     *
     * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
     * 示例 2：
     *
     * 输入：costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
     * 输出：1859
     * 示例 3：
     *
     * 输入：costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
     * 输出：3086
     *
     *
     * 提示：
     *
     * 2 * n == costs.length
     * 2 <= costs.length <= 100
     * costs.length 为偶数
     * 1 <= aCosti, bCosti <= 1000
     */
    static class Solution {
        public static int twoCitySchedCost(int[][] costs) {
            Arrays.sort(costs, (o1, o2) -> o1[0] - o1[1] - (o2[0] - o2[1]));
            int sum = 0;
            for (int i = 0; i < costs.length; i++) {
                if (i < costs.length/2) {
                    sum += costs[i][0];
                } else {
                    sum += costs[i][1];
                }
            }
            return sum;
        }

        public static void main(String[] args) {
            int[] arr1 = new int[]{10,20};
            int[] arr2 = new int[]{30,200};
            int[] arr3 = new int[]{400,50};
            int[] arr4 = new int[]{30,20};
            int[][] arrs = new int[4][2];
            arrs[0] = arr1;
            arrs[1] = arr2;
            arrs[2] = arr3;
            arrs[3] = arr4;
            System.out.println(twoCitySchedCost(arrs));
        }
    }
}
