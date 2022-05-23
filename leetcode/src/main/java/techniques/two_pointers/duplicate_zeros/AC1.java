package techniques.two_pointers.duplicate_zeros;

/**
 * @ClassName: AC1
 * @Description: 1089. 复写零
 * @Author: 琦玉
 * @Date: 2022年05月23日 14:32:38
 */
public class AC1 {

    /**
     * 1089. 复写零
     * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
     *
     * 注意：请不要在超过该数组长度的位置写入元素。
     *
     * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
     *
     *
     *
     * 示例 1：
     *
     * 输入：[1,0,2,3,0,4,5,0]
     * 输出：null
     * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
     * 示例 2：
     *
     * 输入：[1,2,3]
     * 输出：null
     * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
     *
     *
     * 提示：
     *
     * 1 <= arr.length <= 10000
     * 0 <= arr[i] <= 9
     */
    static class Solution {
        public static void duplicateZeros(int[] arr) {
            int len = arr.length;
            if (len == 1) {
                return;
            }
            // 标记从哪个位置开始写入
            int idx = 0;
            int sum = 0;
            // 用于判断最后一个位置的零是否需要复写
            boolean flag = false;
            for (int i = 0; i < len; i++) {
                if (sum >= len) {
                    if (sum == len) {
                        flag = true;
                    }
                    idx = i - 1;
                    break;
                }
                if (arr[i] == 0) {
                    sum += 2;
                } else {
                    sum++;
                }
                if (i == len - 1) {
                    // 没有零
                    return;
                }
            }
            int slow = len - 1;
            int fast = idx;
            while (fast >= 0) {
                arr[slow--] = arr[fast];
                if (arr[fast] == 0 && (fast != idx || flag)) {
                    if (slow >= 0) {
                        arr[slow--] = 0;
                    }
                }
                fast--;
            }
        }

        public static void main(String[] args) {
            duplicateZeros(new int[]{1,2,3});
        }
    }
}
