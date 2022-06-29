package other.design.encode_and_decode_tinyurl;


import java.util.Base64;

/**
 * @ClassName: AC1
 * @Description: 535. TinyURL 的加密与解密
 * @Author: 琦玉
 * @Date: 2022年06月29日 16:48:57
 */
public class AC1 {

    /**
     * 535. TinyURL 的加密与解密
     * TinyURL 是一种 URL 简化服务， 比如：当你输入一个 URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk 。请你设计一个类来加密与解密 TinyURL 。
     * <p>
     * 加密和解密算法如何设计和运作是没有限制的，你只需要保证一个 URL 可以被加密成一个 TinyURL ，并且这个 TinyURL 可以用解密方法恢复成原本的 URL 。
     * <p>
     * 实现 Solution 类：
     * <p>
     * Solution() 初始化 TinyURL 系统对象。
     * String encode(String longUrl) 返回 longUrl 对应的 TinyURL 。
     * String decode(String shortUrl) 返回 shortUrl 原本的 URL 。题目数据保证给定的 shortUrl 是由同一个系统对象加密的。
     * <p>
     * <p>
     * 示例：
     * <p>
     * 输入：url = "https://leetcode.com/problems/design-tinyurl"
     * 输出："https://leetcode.com/problems/design-tinyurl"
     * <p>
     * 解释：
     * Solution obj = new Solution();
     * string tiny = obj.encode(url); // 返回加密后得到的 TinyURL 。
     * string ans = obj.decode(tiny); // 返回解密后得到的原本的 URL 。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= url.length <= 10^4
     * 题目数据保证 url 是一个有效的 URL
     */
    public static class Codec {

        // Encodes a URL to a shortened URL.
        public static String encode(String longUrl) {
            return Base64.getUrlEncoder().encodeToString(longUrl.getBytes());
        }

        // Decodes a shortened URL to its original URL.
        public static String decode(String shortUrl) {
            return new String(Base64.getUrlDecoder().decode(shortUrl));
        }

        public static void main(String[] args) {
            String url = "https://leetcode.com/problems/design-tinyurl";
            String encode = encode(url);
            String decode = decode(encode);
            System.out.println(encode);
            System.out.println(decode);
        }
    }
}
