package leetcode.leetcode_202204;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: QiYu20220406
 * @Description: QiYu20220406
 * @Author: 琦玉
 * @Date: 2022年04月06日 11:40:03
 */
public class QiYu20220406 {

    /**
     * 13. 罗马数字转整数
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。
     * 示例 1:
     *
     * 输入: s = "III"
     * 输出: 3
     * 示例 2:
     *
     * 输入: s = "IV"
     * 输出: 4
     * 示例 3:
     *
     * 输入: s = "IX"
     * 输出: 9
     * 示例 4:
     *
     * 输入: s = "LVIII"
     * 输出: 58
     * 解释: L = 50, V= 5, III = 3.
     * 示例 5:
     *
     * 输入: s = "MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     *  
     *
     * 提示：
     *
     * 1 <= s.length <= 15
     * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
     * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
     * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
     * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
     * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/roman-to-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public static int romanToInt(String s) {
            Map<String, Integer> map = new HashMap<>();
            map.put("I", 1);
            map.put("V", 5);
            map.put("X", 10);
            map.put("L", 50);
            map.put("C", 100);
            map.put("D", 500);
            map.put("M", 1000);
            map.put("IV", 4);
            map.put("IX", 9);
            map.put("XL", 40);
            map.put("XC", 90);
            map.put("CD", 400);
            map.put("CM", 900);
            char[] charArray = s.toCharArray();
            int sum = 0;
            for (int i = 0; i < charArray.length; i++) {
                if (i == charArray.length - 1) {
                    sum += map.get(String.valueOf(charArray[i]));
                } else {
                    String s1 = charArray[i] +  String.valueOf(charArray[i + 1]);
                    if (map.get(s1) != null) {
                        sum += map.get(s1);
                        i = i+1;
                    } else {
                        sum += map.get(String.valueOf(charArray[i]));
                    }
                }
            }
            return sum;
        }

        public static void main(String[] args) {
            System.out.println(romanToInt("IX"));
        }
    }

    /**
     * 704. 二分查找
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     *
     *
     * 示例 1:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * 示例 2:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     *
     *
     * 提示：
     *
     * 你可以假设 nums 中的所有元素是不重复的。
     * n 将在 [1, 10000]之间。
     * nums 的每个元素都将在 [-9999, 9999]之间。
     */
    static class Solution1 {
        public static int search(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = low + (high - low)/2;
                if (nums[mid] > target) {
                    high = mid - 1;
                } else if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            System.out.println(search(new int[]{-1,0,3,5,9,12}, 9));
        }
    }

    /**
     * 278. 第一个错误的版本
     * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
     *
     * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
     *
     * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
     *
     *
     * 示例 1：
     *
     * 输入：n = 5, bad = 4
     * 输出：4
     * 解释：
     * 调用 isBadVersion(3) -> false
     * 调用 isBadVersion(5) -> true
     * 调用 isBadVersion(4) -> true
     * 所以，4 是第一个错误的版本。
     * 示例 2：
     *
     * 输入：n = 1, bad = 1
     * 输出：1
     *
     *
     * 提示：
     *
     * 1 <= bad <= n <= 231 - 1
     */
    public static class Solution2  {
        // 随便定义一个，为了编译可以通过
        public static boolean isBadVersion(int n) {
            return n > 2;
        }

        public static int firstBadVersion(int n) {
            // 此处需要定义为1，因为调用的不是下标，而是具体的版本，版本是[1, 2, ..., n]
            int low = 1;
            int high = n;
            while (low < high) {
                int mid = low + (high - low)/2;
                if (isBadVersion(mid)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }

    /**
     * 35. 搜索插入位置
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 请必须使用时间复杂度为 O(log n) 的算法。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     * 示例 2:
     *
     * 输入: nums = [1,3,5,6], target = 2
     * 输出: 1
     * 示例 3:
     *
     * 输入: nums = [1,3,5,6], target = 7
     * 输出: 4
     *
     *
     * 提示:
     *
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 为 无重复元素 的 升序 排列数组
     * -104 <= target <= 104
     */
    static class Solution3 {
        public static int searchInsert(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = low + (high - low)/2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }
}
