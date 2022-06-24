package algorithms.depth_first_search.find_largest_value_in_each_tree_row;

import java.util.*;

/**
 * @ClassName: AC1
 * @Description: 515. 在每个树行中找最大值
 * @Author: 琦玉
 * @Date: 2022年06月24日 10:54:57
 */
public class AC1 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 515. 在每个树行中找最大值
     * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
     * <p>
     * <p>
     * <p>
     * 示例1：
     * <p>
     * <p>
     * <p>
     * 输入: root = [1,3,2,5,3,null,9]
     * 输出: [1,3,9]
     * 示例2：
     * <p>
     * 输入: root = [1,2,3]
     * 输出: [1,3]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 二叉树的节点个数的范围是 [0,10^4]
     * -2^31 <= Node.val <= 2^31 - 1
     */
    static class Solution {
        public static List<Integer> largestValues(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (null == root) {
                return list;
            }
            Map<Integer, Integer> map = new HashMap<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            int high = 0;
            // todo 实现有问题
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.right != null) {
                    stack.add(node.right);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
                int max;
                if (map.get(high) != null) {
                    max = Math.max(map.get(high), node.val);
                } else {
                    max = node.val;
                }
                map.put(high, max);
                high++;
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                list.add(entry.getValue());
            }
            return list;
        }

        public static void main(String[] args) {
            TreeNode n1 = new TreeNode();
            TreeNode n2 = new TreeNode();
            TreeNode n3 = new TreeNode();
            TreeNode n4 = new TreeNode();
            TreeNode n5 = new TreeNode();
            TreeNode n6 = new TreeNode();
            n1.val = 1;
            n2.val = 3;
            n3.val = 2;
            n4.val = 5;
            n5.val = 3;
            n6.val = 9;
            n1.left = n2;
            n1.right = n3;
            n2.left = n4;
            n2.right = n5;
            n3.right = n6;
            System.out.println(largestValues(n1));
        }
    }
}
