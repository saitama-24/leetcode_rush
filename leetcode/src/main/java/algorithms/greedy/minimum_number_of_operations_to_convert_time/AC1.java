package algorithms.greedy.minimum_number_of_operations_to_convert_time;

/**
 * @ClassName: AC1
 * @Description: 2224. 转化时间需要的最少操作数
 * @Author: 琦玉
 * @Date: 2022年05月17日 16:29:23
 */
public class AC1 {

    /**
     * 2224. 转化时间需要的最少操作数
     * 给你两个字符串 current 和 correct ，表示两个 24 小时制时间 。
     *
     * 24 小时制时间 按 "HH:MM" 进行格式化，其中 HH 在 00 和 23 之间，而 MM 在 00 和 59 之间。最早的 24 小时制时间为 00:00 ，最晚的是 23:59 。
     *
     * 在一步操作中，你可以将 current 这个时间增加 1、5、15 或 60 分钟。你可以执行这一操作 任意 次数。
     *
     * 返回将 current 转化为 correct 需要的 最少操作数 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：current = "02:30", correct = "04:35"
     * 输出：3
     * 解释：
     * 可以按下述 3 步操作将 current 转换为 correct ：
     * - 为 current 加 60 分钟，current 变为 "03:30" 。
     * - 为 current 加 60 分钟，current 变为 "04:30" 。
     * - 为 current 加 5 分钟，current 变为 "04:35" 。
     * 可以证明，无法用少于 3 步操作将 current 转化为 correct 。
     * 示例 2：
     *
     * 输入：current = "11:00", correct = "11:01"
     * 输出：1
     * 解释：只需要为 current 加一分钟，所以最小操作数是 1 。
     *
     *
     * 提示：
     *
     * current 和 correct 都符合 "HH:MM" 格式
     * current <= correct
     */
    static class Solution {
        public static int convertTime(String current, String correct) {
            if (current.equals(correct)) {
                return 0;
            }
            String[] currArr = current.split(":");
            String[] corrArr = correct.split(":");
            int currHour = Integer.parseInt(currArr[0]);
            int currMinute = Integer.parseInt(currArr[1]);
            int corrHour = Integer.parseInt(corrArr[0]);
            int corrMinute = Integer.parseInt(corrArr[1]);
            int count = 0;
            if (currMinute > corrMinute) {
                // 分时大的时候不能加超
                count += Math.max(0, corrHour - currHour - 1);
            } else {
                count += corrHour - currHour;
            }
            int[] timeArr = new int[]{1, 5, 15};
            if (currMinute != corrMinute) {
                int idx = 2;
                int remainSum = corrMinute - currMinute;
                if (currMinute > corrMinute) {
                    remainSum = 60 - currMinute + corrMinute;
                }
                while (true) {
                    if (timeArr[idx] > remainSum) {
                        idx--;
                    } else if (timeArr[idx] == remainSum) {
                        count++;
                        break;
                    } else {
                        count++;
                        remainSum -= timeArr[idx];
                    }
                }
            }
            return count;
        }

        public static void main(String[] args) {
            System.out.println(3 == convertTime("02:30", "04:35"));
            System.out.println(1 == convertTime("11:00", "11:01"));
            System.out.println(7 == convertTime("09:41", "10:34"));
        }
    }
}
