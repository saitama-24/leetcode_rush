package fundamentals.sorting.minimum_absolute_difference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: AC1
 * @Description: 1200. 最小绝对差
 * @Author: 琦玉
 * @Date: 2022年07月04日 14:17:45
 */
public class AC1 {

    /**
     * 1200. 最小绝对差
     * 给你个整数数组 arr，其中每个元素都 不相同。
     * <p>
     * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [4,2,1,3]
     * 输出：[[1,2],[2,3],[3,4]]
     * 示例 2：
     * <p>
     * 输入：arr = [1,3,6,10,15]
     * 输出：[[1,3]]
     * 示例 3：
     * <p>
     * 输入：arr = [3,8,-10,23,19,-4,-14,27]
     * 输出：[[-14,-10],[19,23],[23,27]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 2 <= arr.length <= 10^5
     * -10^6 <= arr[i] <= 10^6
     * 通过次数36,851提交次数50,82
     */
    static class Solution {
        public static List<List<Integer>> minimumAbsDifference(int[] arr) {
            Arrays.sort(arr);
            List<List<Integer>> list = new ArrayList<>();
            int min = Math.abs(arr[1] - arr[0]);
            List<Integer> cList = new ArrayList<>();
            cList.add(arr[0]);
            cList.add(arr[1]);
            list.add(cList);
            for (int i = 2; i < arr.length; i++) {
                if (Math.abs(arr[i] - arr[i - 1]) < min) {
                    list.clear();
                    min = Math.abs(arr[i] - arr[i - 1]);
                } else if (Math.abs(arr[i] - arr[i - 1]) > min) {
                    continue;
                }
                List<Integer> childList = new ArrayList<>();
                childList.add(arr[i - 1]);
                childList.add(arr[i]);
                list.add(childList);
            }
            return list;
        }
    }
}
