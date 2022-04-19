package leetcode.leetcode_202204;

import java.util.*;

/**
 * @ClassName: QiYu20220418
 * @Description: QiYu20220418
 * @Author: 琦玉
 * @Date: 2022年04月18日 15:56:38
 */
public class leetcode_20220418 {

    /**
     * 1
     * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
     *
     * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 13
     * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
     * 示例 2：
     *
     * 输入：n = 2
     * 输出：[1,2]
     *
     *
     * 提示：
     *
     * 1 <= n <= 5 * 10^4
     */
    static class Solution {
        public static List<Integer> lexicalOrder(int n) {
            List<Integer> list = new ArrayList<>();
            int num = 1;

            for (int i = 0; i < n; i++) {
                list.add(num);

                if (num * 10 <= n) {
                    num *= 10;
                } else {
                    while (num % 10 == 9 || num + 1 > n) {
                        num /= 10;
                    }
                    num ++;
                }
            }
            return list;
        }

        public static void main(String[] args) {
            System.out.println(lexicalOrder(192));
        }
    }

    /**
     * 16. 最接近的三数之和
     * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
     *
     * 返回这三个数的和。
     *
     * 假定每组输入只存在恰好一个解。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     * 示例 2：
     *
     * 输入：nums = [0,0,0], target = 1
     * 输出：0
     *
     *
     * 提示：
     *
     * 3 <= nums.length <= 1000
     * -1000 <= nums[i] <= 1000
     * -10^4 <= target <= 10^4
     */
    static class Solution1 {
        public static int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int diffMin = Integer.MAX_VALUE;
            int diff = 0;
            for (int i = 0; i < nums.length; i++) {
                int head = i + 1;
                int tail = nums.length - 1;

                while (head < tail) {
                    int sum = nums[head] + nums[tail] + nums[i];
                    if (sum == target) {
                        return sum;
                    } else if (sum > target) {
                        tail --;
                    } else {
                        head ++;
                    }
                    if (Math.abs(sum - target) < diffMin) {
                        diff = sum;
                        diffMin = Math.abs(sum - target);
                    }
                }
            }
            return diff;
        }

        public static void main(String[] args) {
            System.out.println(threeSumClosest(new int[]{0,0,0}, 1));
        }
    }

    /**
     * 1402. 做菜顺序
     * 一个厨师收集了他 n 道菜的满意程度 satisfaction ，这个厨师做出每道菜的时间都是 1 单位时间。
     *
     * 一道菜的 「喜爱时间」系数定义为烹饪这道菜以及之前每道菜所花费的时间乘以这道菜的满意程度，也就是 time[i]*satisfaction[i] 。
     *
     * 请你返回做完所有菜 「喜爱时间」总和的最大值为多少。
     *
     * 你可以按 任意 顺序安排做菜的顺序，你也可以选择放弃做某些菜来获得更大的总和。
     *
     *
     *
     * 示例 1：
     *
     * 输入：satisfaction = [-1,-8,0,5,-9]
     * 输出：14
     * 解释：去掉第二道和最后一道菜，最大的喜爱时间系数和为 (-1*1 + 0*2 + 5*3 = 14) 。每道菜都需要花费 1 单位时间完成。
     * 示例 2：
     *
     * 输入：satisfaction = [4,3,2]
     * 输出：20
     * 解释：按照原来顺序相反的时间做菜 (2*1 + 3*2 + 4*3 = 20)
     * 示例 3：
     *
     * 输入：satisfaction = [-1,-4,-5]
     * 输出：0
     * 解释：大家都不喜欢这些菜，所以不做任何菜可以获得最大的喜爱时间系数。
     *
     *
     * 提示：
     *
     * n == satisfaction.length
     * 1 <= n <= 500
     * -1000 <= satisfaction[i] <= 1000
     */
    static class Solution3 {
        public static int maxSatisfaction(int[] satisfaction) {
            Arrays.sort(satisfaction);

            int pre = 0;
            int ans = 0;
            for (int i = satisfaction.length - 1; i >= 0; i--) {
                if (pre + satisfaction[i] > 0) {
                    pre += satisfaction[i];
                    ans += pre;
                } else {
                    break;
                }
            }
            return ans;
        }

        public static void main(String[] args) {
            System.out.println(maxSatisfaction(new int[]{4, 3, 2, 0}));
        }
    }

    /**
     * 509. 斐波那契数
     * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     *
     * F(0) = 0，F(1) = 1
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     * 给定 n ，请计算 F(n) 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：1
     * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
     * 示例 2：
     *
     * 输入：n = 3
     * 输出：2
     * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
     * 示例 3：
     *
     * 输入：n = 4
     * 输出：3
     * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
     *
     *
     * 提示：
     *
     * 0 <= n <= 30
     */
    static class Solution2 {
        public static int fib(int n) {
            int[] fib = new int[n+1];
            if (n < 1) {
                return fib[n];
            }
            fib[1] = 1;
            for (int i = 2; i <= n; i++) {
                fib[i] = fib[i-1] + fib[i-2];
            }
            return fib[n];
        }

        public static void main(String[] args) {
            System.out.println(fib(30));
        }
    }
}
