package algorithms.breadth_first_search.find_bottom_left_tree_value;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName: AC1
 * @Description: 513. 找树左下角的值
 * @Author: 琦玉
 * @Date: 2022年06月22日 17:14:33
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
     * 513. 找树左下角的值
     * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
     * <p>
     * 假设二叉树中至少有一个节点。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * <p>
     * <p>
     * 输入: root = [2,1,3]
     * 输出: 1
     * 示例 2:
     * <p>
     * <p>
     * <p>
     * 输入: [1,2,3,4,null,5,6,null,null,7]
     * 输出: 7
     * <p>
     * <p>
     * 提示:
     * <p>
     * 二叉树的节点个数的范围是 [1,10^4]
     * -2^31 <= Node.val <= 2^31 - 1
     */
    static class Solution {
        // 广度优先
        public static int findBottomLeftValue(TreeNode root) {
            int ret = 0;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode p = queue.poll();
                if (p.right != null) {
                    queue.offer(p.right);
                }
                if (p.left != null) {
                    queue.offer(p.left);
                }
                ret = p.val;
            }
            return ret;
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
            System.out.println(findBottomLeftValue(n1));
        }
    }
}
