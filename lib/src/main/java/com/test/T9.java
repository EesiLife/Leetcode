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
//    public int expressiveWords(String s, String[] words) {

//    }

    /**
     删除有序数组中的重复项 II
     已解答
     中等
     相关标签
     相关企业
     给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。

     不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。



     说明：

     为什么返回数值是整数，但输出的答案是数组呢？

     请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

     你可以想象内部操作如下:

     // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
     int len = removeDuplicates(nums);

     // 在函数里修改输入数组对于调用者是可见的。
     // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
     for (int i = 0; i < len; i++) {
     print(nums[i]);
     }


     示例 1：

     输入：nums = [1,1,1,2,2,3]
     输出：5, nums = [1,1,2,2,3]
     解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
     示例 2：

     输入：nums = [0,0,1,1,1,1,2,3,3]
     输出：7, nums = [0,0,1,1,2,3,3]
     解释：函数应返回新长度 length = 7, 并且原数组的前七个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。


     提示：

     1 <= nums.length <= 3 * 104
     -104 <= nums[i] <= 104
     nums 已按升序排列
     * @param nums
     */
    public int removeDuplicates(int[] nums) {
        if ( null == nums || nums.length <= 2) return nums.length;
        int j = 0, pre = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur == pre && count == 1) {

            } else {

            }
        }
        return 0;
    }

    /**
     * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
     * 示例 1：
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * 示例 2：
     *
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     *
     * 提示：
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 105
     */
    public static boolean canJump1(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + i);
            if (dp[i] >= len - 1) {
                return true;
            }
            if (dp[i] == i) {
                return false;
            }
        }
        return false;
    }

    public static boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(max, nums[i] + i);
            }
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
     * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
     * 0 <= j <= nums[i]
     * i + j < n
     * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
     * 示例 1:
     * 输入: nums = [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     * 示例 2:
     * 输入: nums = [2,3,0,1,4]
     * 输出: 2
     * 提示:
     *
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 1000
     * 题目保证可以到达 nums[n-1]
     * @param nums
     */
    public static int jump(int[] nums) {
        int len = nums.length;
        int end = 0;
        int max = 0;
        int ans = 0;
        for (int i = 0; i < len - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == end) {
                end = max;
                ans++;
            }
        }
        return ans;
    }

    /**
     * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
     *
     * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且 至少 有 h 篇论文被引用次数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个。
     * 示例 1：
     * 输入：citations = [3,0,6,1,5]
     * 输出：3
     * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
     *      由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
     * 示例 2：
     * 输入：citations = [1,3,1]
     * 输出：1
     * 提示：
     * n == citations.length
     * 1 <= n <= 5000
     * 0 <= citations[i] <= 1000
     */
    public static int hIndex1(int[] citations) {
        Arrays.sort(citations);
        int ans = 0;
        int pre = -1;
        for (int i = 0; i < citations.length; i++) {
            if (pre == citations[i]) {
                continue;
            }
            if (citations.length - i >= citations[i]) {
                ans = citations[i];
            } else {
                ans = Math.max(ans, citations.length - i);
            }

            pre = citations[i];
        }
        return ans;
    }

    public static int hIndex(int[] citations) {
        int n = citations.length, tot = 0;
        int[] counter = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                counter[n]++;
            } else {
                counter[citations[i]]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            tot += counter[i];
            if (tot >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(hIndex(new int[] {1,3,1}));
        System.out.println(hIndex(new int[] {100}));
        System.out.println(hIndex(new int[] {11, 15}));

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
        /**
         * System.out.println(compareVersion("1.01", "1.01.01"));
         */


    }
}
