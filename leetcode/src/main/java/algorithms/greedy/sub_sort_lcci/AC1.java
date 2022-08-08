package algorithms.greedy.sub_sort_lcci;

import java.util.Arrays;

/**
 * @ClassName: AC1
 * @Description: 面试题 16.16. 部分排序
 * @Author: 琦玉
 * @Date: 2022年08月08日 11:48:25
 */
public class AC1 {

    /**
     * 面试题 16.16. 部分排序
     * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
     * <p>
     * 示例：
     * <p>
     * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
     * 输出： [3,9]
     * 提示：
     * <p>
     * 0 <= len(array) <= 1000000
     */
    static class Solution {
        public static int[] subSort(int[] array) {
            int[] copyArr = Arrays.copyOf(array, array.length);
            Arrays.sort(copyArr);
            int startIdx = -1;
            int endIdx = -1;
            for (int i = 0; i < array.length; i++) {
                if (copyArr[i] != array[i]) {
                    startIdx = i;
                    break;
                }
            }
            if (startIdx != -1) {
                for (int i = array.length - 1; i >= 0; i--) {
                    if (copyArr[i] != array[i]) {
                        endIdx = i;
                        break;
                    }
                }
            }
            return new int[]{startIdx, endIdx};
        }

        public static void main(String[] args) {
            System.out.println(Arrays.toString(subSort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19})));
        }
    }
}
