package algorithms.breadth_first_search.sum_of_nodes_with_even_valued_grandparent;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName: AC1
 * @Description: 1315. 祖父节点值为偶数的节点和
 * @Author: 琦玉
 * @Date: 2022年06月23日 17:39:45
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
     * 1315. 祖父节点值为偶数的节点和
     * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
     * <p>
     * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
     * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
     * <p>
     * <p>
     * <p>
     * 示例：
     * <p>
     * <p>
     * <p>
     * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
     * 输出：18
     * 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 树中节点的数目在 1 到 10^4 之间。
     * 每个节点的值在 1 到 100 之间。
     */
    static class Solution {
        public static int sumEvenGrandparent(TreeNode root) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            Queue<TreeNode> queue2 = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if ((node.val & 1) == 0) {
                    if (null != node.left) {
                        if (null != node.left.left) {
                            queue2.offer(node.left.left);
                        }
                        if (null != node.left.right) {
                            queue2.offer(node.left.right);
                        }
                    }
                    if (null != node.right) {
                        if (null != node.right.left) {
                            queue2.offer(node.right.left);
                        }
                        if (null != node.right.right) {
                            queue2.offer(node.right.right);
                        }
                    }
                }
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
            int ans = 0;
            while (!queue2.isEmpty()) {
                TreeNode node = queue2.poll();
                ans += node.val;
            }
            return ans;
        }

        public static void main(String[] args) {
            TreeNode n1 = new TreeNode();
            TreeNode n2 = new TreeNode();
            TreeNode n3 = new TreeNode();
            n1.val = 2;
            n2.val = 1;
            n3.val = 3;
            n1.left = n2;
            n1.right = n3;
            System.out.println(sumEvenGrandparent(n1));
        }
    }
}
