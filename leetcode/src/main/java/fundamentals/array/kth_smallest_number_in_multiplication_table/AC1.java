package fundamentals.array.kth_smallest_number_in_multiplication_table;

import java.util.Arrays;

/**
 * @ClassName: AC1
 * @Description: 668. 乘法表中第k小的数
 * @Author: 琦玉
 * @Date: 2022年05月18日 11:03:37
 */
public class AC1 {

    /**
     * 668. 乘法表中第k小的数
     * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
     *
     * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
     *
     * 例 1：
     *
     * 输入: m = 3, n = 3, k = 5
     * 输出: 3
     * 解释:
     * 乘法表:
     * 1	2	3
     * 2	4	6
     * 3	6	9
     *
     * 第5小的数字是 3 (1, 2, 2, 3, 3).
     * 例 2：
     *
     * 输入: m = 2, n = 3, k = 6
     * 输出: 6
     * 解释:
     * 乘法表:
     * 1	2	3
     * 2	4	6
     *
     * 第6小的数字是 6 (1, 2, 2, 3, 4, 6).
     * 注意：
     *
     * m 和 n 的范围在 [1, 30000] 之间。
     * k 的范围在 [1, m * n] 之间。
     */
    static class Solution {
        public static int findKthNumber(int m, int n, int k) {
            int[] arr1 = new int[m-1];
            int[] arr2 = new int[n-1];
            for (int i = 0; i < m-1; i++) {
                arr1[i] = i+2;
            }
            for (int i = 0; i < n-1; i++) {
                arr2[i] = i+2;
            }
            int[] arr3 = new int[(m-1)*(n-1)];
            int idx = 0;
            for (int item : arr1) {
                for (int value : arr2) {
                    arr3[idx++] = item * value;
                }
            }

            int[] arr4 = new int[m * n];
            arr4[0] = 1;
            System.arraycopy(arr1, 0, arr4, 1, arr1.length);
            System.arraycopy(arr2, 0, arr4, arr1.length+1, arr2.length);
            System.arraycopy(arr3, 0, arr4, arr1.length + arr2.length + 1, arr3.length);
            Arrays.sort(arr4);
            return arr4[k-1];
        }

        public static void main(String[] args) {
            System.out.println(findKthNumber(46, 9, 9));
        }
    }
}
