package fundamentals.array.count_items_matching_a_rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangzhenjie
 * @version 1.0
 * @date 2022/10/29 19:51
 * @className: AC1
 * @description: // 1773. 统计匹配检索规则的物品数量
 */
public class AC1 {

    /**
     * 1773. 统计匹配检索规则的物品数量
     * 简单
     * 65
     * 相关企业
     * 给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。
     * <p>
     * 另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。
     * <p>
     * 如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
     * <p>
     * ruleKey == "type" 且 ruleValue == typei 。
     * ruleKey == "color" 且 ruleValue == colori 。
     * ruleKey == "name" 且 ruleValue == namei 。
     * 统计并返回 匹配检索规则的物品数量 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
     * 输出：1
     * 解释：只有一件物品匹配检索规则，这件物品是 ["computer","silver","lenovo"] 。
     * 示例 2：
     * <p>
     * 输入：items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
     * 输出：2
     * 解释：只有两件物品匹配检索规则，这两件物品分别是 ["phone","blue","pixel"] 和 ["phone","gold","iphone"] 。注意，["computer","silver","phone"] 未匹配检索规则。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= items.length <= 10^4
     * 1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
     * ruleKey 等于 "type"、"color" 或 "name"
     * 所有字符串仅由小写字母组成
     */
    static class Solution {
        private static final Map<String, Integer> map;

        static {
            map = new HashMap<>();
            map.put("type", 0);
            map.put("color", 1);
            map.put("name", 2);
        }

        public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
            int idx = map.get(ruleKey);
            int count = 0;
            for (List<String> item : items) {
                if (ruleValue.equals(item.get(idx))) {
                    count++;
                }
            }
            return count;
        }

        public static void main(String[] args) {
            List<List<String>> lists = new ArrayList<>();
            List<String> list1 = new ArrayList<>();
            list1.add("phone");
            list1.add("blue");
            list1.add("pixel");
            List<String> list2 = new ArrayList<>();
            list2.add("computer");
            list2.add("silver");
            list2.add("phone");
            List<String> list3 = new ArrayList<>();
            list3.add("phone");
            list3.add("gold");
            list3.add("iphone");
            lists.add(list1);
            lists.add(list2);
            lists.add(list3);
            System.out.println(countMatches(lists, "type", "phone"));
        }
    }
}
