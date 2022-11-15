package algorithms.greedy.maximum_units_on_a_truck;

import java.util.Arrays;

/**
 * @author wangzhenjie
 * @version 1.0
 * @date 2022/11/15 21:09
 * @className: AC1
 * @description: // 1710. 卡车上的最大单元数
 */
public class AC1 {

    /**
     * 1710. 卡车上的最大单元数
     * 简单
     * 97
     * 相关企业
     * 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
     * <p>
     * numberOfBoxesi 是类型 i 的箱子的数量。
     * numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
     * 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
     * <p>
     * 返回卡车可以装载 单元 的 最大 总数。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
     * 输出：8
     * 解释：箱子的情况如下：
     * - 1 个第一类的箱子，里面含 3 个单元。
     * - 2 个第二类的箱子，每个里面含 2 个单元。
     * - 3 个第三类的箱子，每个里面含 1 个单元。
     * 可以选择第一类和第二类的所有箱子，以及第三类的一个箱子。
     * 单元总数 = (1 * 3) + (2 * 2) + (1 * 1) = 8
     * 示例 2：
     * <p>
     * 输入：boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
     * 输出：91
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= boxTypes.length <= 1000
     * 1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
     * 1 <= truckSize <= 10^6
     */
    static class Solution {
        public static int maximumUnits(int[][] boxTypes, int truckSize) {
            Arrays.sort(boxTypes, ((o1, o2) -> o2[1] - o1[1]));
            int res = 0;
            for (int[] boxType : boxTypes) {
                int consume = boxType[0];
                if (truckSize < boxType[0]) {
                    consume = truckSize;
                }
                res += consume * boxType[1];
                truckSize -= consume;
                if (truckSize == 0) {
                    return res;
                }
            }
            return res;
        }

        public static void main(String[] args) {
            System.out.println(maximumUnits(new int[][]{
                    new int[]{1, 3},
                    new int[]{2, 2},
                    new int[]{3, 1},
            }, 4));
        }
    }
}
