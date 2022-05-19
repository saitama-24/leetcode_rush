package algorithms.greedy.longest_happy_string;

import java.util.PriorityQueue;

/**
 * @ClassName: AC1
 * @Description: 1405. 最长快乐字符串
 * @Author: 琦玉
 * @Date: 2022年05月19日 16:00:06
 */
public class AC1 {

    /**
     * 1405. 最长快乐字符串
     * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
     * <p>
     * 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
     * <p>
     * s 是一个尽可能长的快乐字符串。
     * s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
     * s 中只含有 'a'、'b' 、'c' 三种字母。
     * 如果不存在这样的字符串 s ，请返回一个空字符串 ""。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：a = 1, b = 1, c = 7
     * 输出："ccaccbcc"
     * 解释："ccbccacc" 也是一种正确答案。
     * 示例 2：
     * <p>
     * 输入：a = 2, b = 2, c = 1
     * 输出："aabbc"
     * 示例 3：
     * <p>
     * 输入：a = 7, b = 1, c = 0
     * 输出："aabaa"
     * 解释：这是该测试用例的唯一正确答案。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= a, b, c <= 100
     * a + b + c > 0
     */
    static class Solution {
        public static String longestDiverseString(int a, int b, int c) {
            // 主要是需要一个能够维护字符和剩余次数的优先级队列
            PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> y[1] - x[1]);
            if (a > 0) {
                queue.add(new int[]{0, a});
            }
            if (b > 0) {
                queue.add(new int[]{1, b});
            }
            if (c > 0) {
                queue.add(new int[]{2, c});
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int len = stringBuilder.length();
                if (len >= 2 && stringBuilder.charAt(len - 1) - 'a' == poll[0] && stringBuilder.charAt(len - 2) - 'a' == poll[0]) {
                    if (queue.isEmpty()) {
                        break;
                    }
                    int[] pollNext = queue.poll();
                    pollNext[1]--;
                    if (pollNext[1] > 0) {
                        queue.add(pollNext);
                    }
                    stringBuilder.append((char) (pollNext[0] + 'a'));
                } else {
                    poll[1]--;
                    stringBuilder.append((char) (poll[0] + 'a'));
                }
                if (poll[1] > 0) {
                    queue.add(poll);
                }
            }
            return stringBuilder.toString();
        }

        public static void main(String[] args) {
            System.out.println(longestDiverseString(2, 2, 1));
        }
    }
}
