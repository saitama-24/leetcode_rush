package techniques.two_pointers.find_k_closest_elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: AC1
 * @Description: 658. 找到 K 个最接近的元素
 * @Author: 琦玉
 * @Date: 2022年08月25日 15:58:05
 */
public class AC1 {

    /**
     * 658. 找到 K 个最接近的元素
     * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
     * <p>
     * 整数 a 比整数 b 更接近 x 需要满足：
     * <p>
     * |a - x| < |b - x| 或者
     * |a - x| == |b - x| 且 a < b
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [1,2,3,4,5], k = 4, x = 3
     * 输出：[1,2,3,4]
     * 示例 2：
     * <p>
     * 输入：arr = [1,2,3,4,5], k = 4, x = -1
     * 输出：[1,2,3,4]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= k <= arr.length
     * 1 <= arr.length <= 10^4
     * arr 按 升序 排列
     * -10^4 <= arr[i], x <= 10^4
     */
    static class Solution {
        public static List<Integer> findClosestElements(int[] arr, int k, int x) {
            int len = arr.length;
            int removeCount = len - k;
            int left = 0;
            int right = len - 1;
            while (removeCount > 0) {
                int leftNum = arr[left];
                int rightNum = arr[right];
                if (Math.abs(x - leftNum) <= Math.abs(x - rightNum)) {
                    right--;
                } else {
                    left++;
                }
                removeCount--;
            }
            List<Integer> list = new ArrayList<>();
            for (int i = left; i <= right; i++) {
                list.add(arr[i]);
            }
            return list;
        }

        public static void main(String[] args) {
            System.out.println(findClosestElements(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, 5));
        }
    }
}
