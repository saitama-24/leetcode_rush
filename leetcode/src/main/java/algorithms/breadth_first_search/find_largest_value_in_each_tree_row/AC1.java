package algorithms.breadth_first_search.find_largest_value_in_each_tree_row;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: AC1
 * @Description: 515. 在每个树行中找最大值
 * @Author: 琦玉
 * @Date: 2022年06月24日 10:39:32
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
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node == null) {
                        continue;
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    max = Math.max(max, node.val);
                }
                list.add(max);
            }
            return list;
        }

        public static void main(String[] args) {
            TreeNode n1 = new TreeNode();
            TreeNode n2 = new TreeNode();
            TreeNode n3 = new TreeNode();
            TreeNode n4 = new TreeNode();
            n1.val = 2;
            n2.val = 1;
            n3.val = 3;
            n4.val = 7;
            n1.left = n2;
            n1.right = n3;
            n2.left = n4;
            System.out.println(largestValues(n1));
        }
    }
}
