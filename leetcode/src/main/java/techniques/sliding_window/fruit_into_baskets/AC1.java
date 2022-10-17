package techniques.sliding_window.fruit_into_baskets;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangzhenjie
 * @version 1.0
 * @date 2022/10/17 18:19
 * @className: AC1
 * @description: // 904. 水果成篮
 */
public class AC1 {
    /**
     * 904. 水果成篮
     * 中等
     * 337
     * 相关企业
     * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
     * <p>
     * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
     * <p>
     * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
     * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
     * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
     * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：fruits = [1,2,1]
     * 输出：3
     * 解释：可以采摘全部 3 棵树。
     * 示例 2：
     * <p>
     * 输入：fruits = [0,1,2,2]
     * 输出：3
     * 解释：可以采摘 [1,2,2] 这三棵树。
     * 如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
     * 示例 3：
     * <p>
     * 输入：fruits = [1,2,3,2,2]
     * 输出：4
     * 解释：可以采摘 [2,3,2,2] 这四棵树。
     * 如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
     * 示例 4：
     * <p>
     * 输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
     * 输出：5
     * 解释：可以采摘 [1,2,1,1,2] 这五棵树。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= fruits.length <= 10^5
     * 0 <= fruits[i] < fruits.length
     */
    static class Solution {
        public static int totalFruit(int[] fruits) {
            // 每一轮计数
            int count = 0;
            Set<Integer> set = new HashSet<>();
            int res = 0;
            // 第二种数的索引起点
            int lastIdx = -1;
            for (int i = 0; i < fruits.length; i++) {
                if (set.isEmpty()) {
                    set.add(fruits[i]);
                    count++;
                } else {
                    if (set.contains(fruits[i])) {
                        count++;
                    } else {
                        // 判断篮子有几种水果
                        if (set.size() > 1) {
                            res = Math.max(count, res);
                            set.clear();
                            count = 0;
                            i = lastIdx - 1;
                        } else {
                            lastIdx = i;
                            set.add(fruits[i]);
                            count++;
                        }
                    }
                }
            }
            return Math.max(count, res);
        }

        public static void main(String[] args) {
            System.out.println(totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
        }
    }
}
