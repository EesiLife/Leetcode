package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T9 {


    /**
     * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
     *
     *
     *
     * 示例 1：
     *
     * 输入:a = "11", b = "1"
     * 输出："100"
     * 示例 2：
     *
     * 输入：a = "1010", b = "1011"
     * 输出："10101"
     * 1010
     *  111
     *
     * 提示：
     *
     * 1 <= a.length, b.length <= 104
     * a 和 b 仅由字符 '0' 或 '1' 组成
     * 字符串如果不是 "0" ，就不含前导零
     */

    public static String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int maxLen = Math.max(b.length(), a.length());
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = maxLen - 1; i >= 0; i--) {
            int sum = carry;
            sum += (i - Math.abs(maxLen - aLen)) < 0 ? 0 : (int)(a.charAt(i - Math.abs(maxLen - aLen)) - '0');
            sum += (i - Math.abs(maxLen - bLen)) < 0 ? 0 : (int)(b.charAt(i - Math.abs(maxLen - bLen)) - '0');
            sb.append(sum %2);
            carry = sum /2;
        }
        if (carry > 0) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 示例 1：
     *
     * 输入：digits = [1,2,3]
     * 输出：[1,2,4]
     * 解释：输入数组表示数字 123。
     * 示例 2：
     *
     * 输入：digits = [4,3,2,1]
     * 输出：[4,3,2,2]
     * 解释：输入数组表示数字 4321。
     * 示例 3：
     *
     * 输入：digits = [0]
     * 输出：[1]
     *
     *
     * 提示：
     *
     * 1 <= digits.length <= 100
     * 0 <= digits[i] <= 9
     */
    public static int[] plusOne(int[] digits) {
        int carry = 0;
        int len = digits.length;
        int[] tmp = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            int sum;
            if (i == len - 1) {
                sum = digits[i] + 1;
            } else {
                sum = digits[i] + carry;
            }
            tmp[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry > 0) {
            int[] ans = new int[len + 1];
            for (int i = 0; i < len + 1; i ++) {
                if (i == 0) {
                    ans[i] = 1;
                } else {
                    ans[i] = tmp[i - 1];
                }
            }
            return ans;
        }
        return tmp;
    }

    /**
     * 43. 字符串相乘
     * 中等
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
     *
     * 示例 1:
     *
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * 示例 2:
     *
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     *
     *
     * 提示：
     *
     * 1 <= num1.length, num2.length <= 200
     * num1 和 num2 只能由数字组成。
     * num1 和 num2 都不包含任何前导零，除了数字0本身。
     */

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int n1 = num1.length(), n2 = num2.length();
        int[] ans = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            int a = (num1.charAt(i) - '0');
            for (int j = n2 - 1; j >= 0; j--) {
                int b = (num2.charAt(j) - '0');
                int sum = ans[i + j + 1] + a * b;
                ans[i + j + 1] = sum % 10;
                ans[i + j] = sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++ ) {
            if (i == 0 && ans[i] == 0) continue;
            sb.append(ans[i]);
        }
        return sb.toString();
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {
        int len = num.length;
        int carry = k;
        List<Integer> ans = new ArrayList<>();
        for(int i = len - 1; i >= 0; i--) {
            int sum = carry;
            sum += num[i];
            num[i] = sum %10;
            carry = sum /10;
        }
        for(int a : num) {
            ans.add(a);
        }
        while(carry > 0) {
            ans.add(0,carry%10);
            carry = carry /10;
        }
        for (int a :ans) {
            System.out.println(a);
        }
        return ans;
    }

    public static List<Integer> addToArrayForm1(int[] num, int k) {
        int n = num.length;
        List<Integer> ans = new ArrayList<>();
        int i = n - 1;
        while (i >=0 || k > 0) {
            int a = i >=0 ? num[i] : 0;
            int b = k % 10;
            int sum = a + b;
            ans.add(0, sum %10);
            k = k/10 + sum /10;
            i--;
        }
        return ans;
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int m = v1.length, n = v2.length;
        int i = 0;
        while (i < m || i < n) {
            int a = i < m ? Integer.parseInt(v1[i]) : 0;
            int b = i < n ? Integer.parseInt(v2[i]) : 0;
            if (a == b) {
                i++;
                continue;
            }
            return Integer.compare(a, b);
        }
        return 0;
    }


    /**
     * 有时候人们会用重复写一些字母来表示额外的感受，比如 "hello" -> "heeellooo", "hi" -> "hiii"。我们将相邻字母都相同的一串字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。
     *
     * 对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。扩张操作定义如下：选择一个字母组（包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。
     *
     * 例如，以 "hello" 为例，我们可以对字母组 "o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 长度小于 3。此外，我们可以进行另一种扩张 "ll" -> "lllll" 以获得 "helllllooo"。如果 s = "helllllooo"，那么查询词 "hello" 是可扩张的，因为可以对它执行这两种扩张操作使得 query = "hello" -> "hellooo" -> "helllllooo" = s。
     *
     * 输入一组查询单词，输出其中可扩张的单词数量。
     *
     *
     *
     * 示例：
     *
     * 输入：
     * s = "heeellooo"
     * words = ["hello", "hi", "helo"]
     * 输出：1
     * 解释：
     * 我们能通过扩张 "hello" 的 "e" 和 "o" 来得到 "heeellooo"。
     * 我们不能通过扩张 "helo" 来得到 "heeellooo" 因为 "ll" 的长度小于 3 。
     *
     *
     * 提示：
     *
     * 1 <= s.length, words.length <= 100
     * 1 <= words[i].length <= 100
     * s 和所有在 words 中的单词都只由小写字母组成。
     * @param s
     * @param words
     * @return
     */
    public int expressiveWords(String s, String[] words) {

    }

    public static void main(String[] args) {
        /**
         int[] a = new int[]{1, 2, 3};
         plusOne(a);
         */
//        System.out.println(multiply("1234", "456"));

        /**
        int[] num = new int[]{1,2,1,1};
        int k = 9999;
        addToArrayForm(num, k);
         */
        System.out.println(compareVersion("1.01", "1.01.01"));

    }
}
