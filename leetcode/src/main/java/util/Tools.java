package util;

/**
 * @ClassName: Tools
 * @Description: 工具类
 * @Author: 琦玉
 * @Date: 2022年04月27日 16:56:21
 */
public class Tools {

    /**
     * 转换leetcode题目"-"符号为"_"
     * @param old 原字符
     * @return string
     */
    public static String conventSpecChar(String old) {
        return old.replaceAll("-", "_");
    }

    public static void main(String[] args) {
        System.out.println(conventSpecChar("minimum-operations-to-make-the-array-increasing"));
    }
}
