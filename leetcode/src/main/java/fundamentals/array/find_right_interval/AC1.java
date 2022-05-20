package fundamentals.array.find_right_interval;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName: AC1
 * @Description: 436. 寻找右区间
 * @Author: 琦玉
 * @Date: 2022年05月20日 10:31:57
 */
public class AC1 {

    /**
     * 436. 寻找右区间
     * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
     *
     * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
     *
     * 返回一个由每个区间 i 的 右侧区间 的最小起始位置组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
     *
     *
     * 示例 1：
     *
     * 输入：intervals = [[1,2]]
     * 输出：[-1]
     * 解释：集合中只有一个区间，所以输出-1。
     * 示例 2：
     *
     * 输入：intervals = [[3,4],[2,3],[1,2]]
     * 输出：[-1,0,1]
     * 解释：对于 [3,4] ，没有满足条件的“右侧”区间。
     * 对于 [2,3] ，区间[3,4]具有最小的“右”起点;
     * 对于 [1,2] ，区间[2,3]具有最小的“右”起点。
     * 示例 3：
     *
     * 输入：intervals = [[1,4],[2,3],[3,4]]
     * 输出：[-1,2,-1]
     * 解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
     * 对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
     *
     *
     * 提示：
     *
     * 1 <= intervals.length <= 2 * 10^4
     * intervals[i].length == 2
     * -10^6 <= starti <= endi <= 10^6
     * 每个间隔的起点都 不相同
     */
    static class Solution {
        public static int[] findRightInterval(int[][] intervals) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int i = 0; i < intervals.length; i++) {
                treeMap.put(intervals[i][0], i);
            }
            int[] arr = new int[intervals.length];
            for (int i = 0; i < intervals.length; i++) {
                int j = intervals[i][1];
                Integer idx = treeMap.get(j);
                if (idx != null) {
                    arr[i] = idx;
                } else {
                    Map.Entry<Integer, Integer> entry = treeMap.higherEntry(j);
                    if (null == entry) {
                        arr[i] = -1;
                    } else {
                        arr[i] = entry.getValue();
                    }
                }
            }
            return arr;
        }

        public static void main(String[] args) {
            int[] arr1 = new int[]{3,4};
            int[] arr2 = new int[]{2,3};
            int[] arr3 = new int[]{1,2};
            int[][] arr = new int[3][2];
            arr[0] = arr1;
            arr[1] = arr2;
            arr[2] = arr3;
            System.out.println(Arrays.toString(findRightInterval(arr)));
        }
    }
}
