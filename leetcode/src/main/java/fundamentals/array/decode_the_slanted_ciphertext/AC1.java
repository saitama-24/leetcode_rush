package fundamentals.array.decode_the_slanted_ciphertext;

/**
 * @author wangzhenjie
 * @description 2075. 解码斜向换位密码
 * @date 2022-09-21 19:38:00
 */
public class AC1 {

    /**
     * 2075. 解码斜向换位密码
     * 字符串 originalText 使用 斜向换位密码 ，经由 行数固定 为 rows 的矩阵辅助，加密得到一个字符串 encodedText 。
     *
     * originalText 先按从左上到右下的方式放置到矩阵中。
     *
     *
     * 先填充蓝色单元格，接着是红色单元格，然后是黄色单元格，以此类推，直到到达 originalText 末尾。箭头指示顺序即为单元格填充顺序。所有空单元格用 ' ' 进行填充。矩阵的列数需满足：用 originalText 填充之后，最右侧列 不为空 。
     *
     * 接着按行将字符附加到矩阵中，构造 encodedText 。
     *
     *
     * 先把蓝色单元格中的字符附加到 encodedText 中，接着是红色单元格，最后是黄色单元格。箭头指示单元格访问顺序。
     *
     * 例如，如果 originalText = "cipher" 且 rows = 3 ，那么我们可以按下述方法将其编码：
     *
     *
     * 蓝色箭头标识 originalText 是如何放入矩阵中的，红色箭头标识形成 encodedText 的顺序。在上述例子中，encodedText = "ch   ie   pr" 。
     *
     * 给你编码后的字符串 encodedText 和矩阵的行数 rows ，返回源字符串 originalText 。
     *
     * 注意：originalText 不 含任何尾随空格 ' ' 。生成的测试用例满足 仅存在一个 可能的 originalText 。
     * 提示：
     *
     * 0 <= encodedText.length <= 106
     * encodedText 仅由小写英文字母和 ' ' 组成
     * encodedText 是对某个不含尾随空格的 originalText 的一个有效编码
     * 1 <= rows <= 1000
     * 生成的测试用例满足 仅存在一个 可能的 originalText
     */
    static class Solution {
        public static String decodeCiphertext(String encodedText, int rows) {
            int len = encodedText.length();
            int cols = len / rows;
            char[][] matrix = new char[rows][cols];
            int idx = 0;
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (i / cols != idx) {
                    idx++;
                    count = 0;
                }
                matrix[idx][count++] = encodedText.charAt(i);
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < cols; i++) {
                int col = i;
                int row = 0;
                while (col < cols && row < rows) {
                    stringBuilder.append(matrix[row++][col++]);
                }
            }
            return stringBuilder.toString().replaceAll("\\s+$", "");
        }

        public static void main(String[] args) {
            System.out.println(decodeCiphertext(" b  ac", 2));
        }
    }
}
