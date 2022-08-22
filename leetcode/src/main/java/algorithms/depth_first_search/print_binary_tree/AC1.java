package algorithms.depth_first_search.print_binary_tree;

import java.util.*;

/**
 * @ClassName: AC1
 * @Description: 655. 输出二叉树
 * @Author: 琦玉
 * @Date: 2022年08月22日 17:09:01
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
     * 655. 输出二叉树
     * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
     * <p>
     * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
     * 矩阵的列数 n 应该等于 2^(height+1) - 1 。
     * 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
     * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1] 。
     * 继续这一过程，直到树中的所有节点都妥善放置。
     * 任意空单元格都应该包含空字符串 "" 。
     * 返回构造得到的矩阵 res 。
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [1,2]
     * 输出：
     * [["","1",""],
     * ["2","",""]]
     * 示例 2：
     * <p>
     * <p>
     * 输入：root = [1,2,3,null,4]
     * 输出：
     * [["","","","1","","",""],
     * ["","2","","","","3",""],
     * ["","","4","","","",""]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 树中节点数在范围 [1, 2^10] 内
     * -99 <= Node.val <= 99
     * 树的深度在范围 [1, 10] 内
     */
    static class Solution {
        static class Tuple {
            TreeNode node;
            int r;
            int c;

            public Tuple(TreeNode node, int r, int c) {
                this.node = node;
                this.r = r;
                this.c = c;
            }
        }

        public static List<List<String>> printTree(TreeNode root) {
            int height = calcHigh(root);
            int m = height + 1;
            int n = (1 << (height + 1)) - 1;
            List<List<String>> lists = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                List<String> list = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    list.add("");
                }
                lists.add(list);
            }
            Queue<Tuple> queue = new ArrayDeque<>();
            queue.offer(new Tuple(root, 0, (n - 1) / 2));
            while (!queue.isEmpty()) {
                Tuple t = queue.poll();
                TreeNode node = t.node;
                int r = t.r, c = t.c;
                lists.get(r).set(c, Integer.toString(node.val));
                if (node.left != null) {
                    queue.offer(new Tuple(node.left, r + 1, c - (1 << (height - r - 1))));
                }
                if (node.right != null) {
                    queue.offer(new Tuple(node.right, r + 1, c + (1 << (height - r - 1))));
                }
            }
            return lists;
        }

        private static int calcHigh(TreeNode root) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            int height = -1;
            while (!queue.isEmpty()) {
                int count = queue.size();
                for (int i = 0; i < count; i++) {
                    TreeNode node = queue.poll();
                    if (null == node) {
                        continue;
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                height++;
            }
            return height;
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
            System.out.println(printTree(n1));
        }
    }
}
