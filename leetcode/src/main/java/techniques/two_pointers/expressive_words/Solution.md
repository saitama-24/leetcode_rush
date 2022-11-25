> Problem: [809. 情感丰富的文字](https://leetcode.cn/problems/expressive-words/description/)

[TOC]

# 思路
> 由题意可知要通过扩张得到指定的字符串，必须字符顺序一致，如果指定字符重复个数小于3的，则两者重复数量必须一致

# 解题方法
> 可以通过把字符串预处理，再对照比较即可。例如s = "heeellooo"，可以预处理为"h1e3l2o3",每个字符后面跟着的是重复数量。再把要对比的字符串也进行预处理，例如word[0] = "hello"，可以预处理为 "h1e1l2o1", 对照着比较，相同位置字符不一样直接pass，字符一样的情况下如果源字符重复数量 <3，则对照的字符重复数量必须强相等，且需要判断重复数量不能大于源字符重复数量，具体看代码即可。

# 复杂度
- 时间复杂度: $O(n*m)$

- 空间复杂度: $O(m)$

# Code
```Java []

class Solution {
    public int expressiveWords(String s, String[] words) {
        int res = 0;
        String originMatch = getMatchStr(s);
        for (String word : words) {
            String matchStr = getMatchStr(word);
            if (originMatch.length() != matchStr.length()) {
                continue;
            }
            boolean flag = false;
            for (int i = 0; i < originMatch.length(); i+=2) {
                if (originMatch.charAt(i) != matchStr.charAt(i)) {
                    flag = true;
                    break;
                }
                int originNum = originMatch.charAt(i + 1) - '0';
                int matchNum = matchStr.charAt(i+1) - '0';
                if (originNum < 3) {
                    if (matchNum != originNum) {
                        flag = true;
                        break;
                    }
                } else {
                    if (matchNum > originNum) {
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                res++;
            }
        }
        return res;
    }

        private String getMatchStr(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char prev = '0';
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (prev == '0') {
                prev = s.charAt(i);
                count = 1;
            } else {
                if (s.charAt(i) != prev) {
                    stringBuilder.append(prev).append(count);
                    prev = s.charAt(i);
                    count = 1;
                } else {
                    count++;
                }
            }
        }
        stringBuilder.append(prev).append(count);
        return stringBuilder.toString();
    }
}
```
