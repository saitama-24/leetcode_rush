package algorithms.greedy.jump_game;

/**
 * @ClassName: AC1
 * @Description: 55. 跳跃游戏
 * @Author: 琦玉
 * @Date: 2022年08月24日 10:36:26
 */
public class AC1 {

    /**
     * 55. 跳跃游戏
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 判断你是否能够到达最后一个下标。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * 示例 2：
     * <p>
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 3 * 10^4
     * 0 <= nums[i] <= 10^5
     */
    static class Solution {
        public static boolean canJump(int[] nums) {
            int maxJumpIdx = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i <= maxJumpIdx) {
                    maxJumpIdx = Math.max(maxJumpIdx, nums[i] + i);
                    if (maxJumpIdx >= nums.length - 1) {
                        return true;
                    }
                }
            }
            return false;
        }

        public static void main(String[] args) {
            System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        }
    }
}
