package algorithms.depth_first_search.univalued_binary_tree;

/**
 * @ClassName: AC1
 * @Description: 965. 单值二叉树
 * @Author: 琦玉
 * @Date: 2022年05月24日 10:44:01
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
     * 965. 单值二叉树
     * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
     *
     * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：[1,1,1,1,1,null,1]
     * 输出：true
     * 示例 2：
     *
     *
     *
     * 输入：[2,2,2,5,2]
     * 输出：false
     *
     *
     * 提示：
     *
     * 给定树的节点数范围是 [1, 100]。
     * 每个节点的值都是整数，范围为 [0, 99] 。
     */
    static class Solution {
        public static boolean isUnivalTree(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (root.left != null) {
                if (root.val != root.left.val || !isUnivalTree(root.left)) {
                    return false;
                }
            }
            if (root.right != null) {
                if (root.val != root.right.val || !isUnivalTree(root.right)) {
                    return false;
                }
            }
            return true;
        }
    }
}
