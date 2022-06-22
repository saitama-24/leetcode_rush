package algorithms.breadth_first_search.deepest_leaves_sum;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName: AC1
 * @Description: 1302. 层数最深叶子节点的和
 * @Author: 琦玉
 * @Date: 2022年06月22日 17:53:20
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
     * 1302. 层数最深叶子节点的和
     * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
     * 输出：15
     * 示例 2：
     * <p>
     * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
     * 输出：19
     * <p>
     * <p>
     * 提示：
     * <p>
     * 树中节点数目在范围 [1, 104] 之间。
     * 1 <= Node.val <= 100
     */
    static class Solution {
        public static int deepestLeavesSum(TreeNode root) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            int ans = 0;
            while (!queue.isEmpty()) {
                // 当前层的节点数量
                int levelCount = queue.size();
                // 当前层所有节点值的和
                ans = 0;
                // 遍历当前层的所有节点
                for (int j = 0; j < levelCount; j++) {
                    TreeNode node = queue.poll();
                    if (null == node) {
                        continue;
                    }
                    // 累加当前层节点的值
                    ans += node.val;
                    // 如果左子节点不为空就把他加入到队列中
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    // 如果右子节点不为空就把他加入到队列中
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            return ans;
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
            System.out.println(deepestLeavesSum(n1));
        }
    }
}
