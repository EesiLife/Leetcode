package com.test;

import java.util.Stack;

/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * 返回 true.
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * 返回 false.
 * 后续挑战 :
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * 致谢:
 */
public class T5 {

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 3, 5, 6};
//        int target = 5;

//        int[] nums = new int[]{1,3,5,6};
//        int target = 2;

//        int[] nums = new int[]{1,3,5,6};
//        int target = 7;

        int[] nums = new int[]{1, 3, 5, 6};
        int target = 0;

        int result = new T5().searchInsert(nums, target);
        System.out.println(result);
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target)
                high = mid - 1;
            else if (nums[mid] < target)
                low = mid + 1;
            else
                return mid;
        }
        return low;
    }

    //80. 删除排序数组中的重复项 II
//    public int aremoveDuplicate(int[] nums) {
//        if (null == nums || nums.length == 0) return 0;
//        int j = 1;
//        int k = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] != nums[i - 1]) {
//                nums[j] = nums[i];
//                j++;
//                k = 1;
//            } else if (k == 1) {
//                nums[j] = nums[i];
//                j++;
//                k = k + 1;
//            }
//        }
//        return j;
//    }

    //80. 删除排序数组中的重复项 II
    public int aremoveDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int p1 = 0;
        int p2 = 1;
        int len = nums.length;
        while (p2 < len) {
            if (nums[p1] == nums[p2]) {
                if (p1 == 0 || nums[p1 - 1] != nums[p2]) {
                    p1++;
                    nums[p1] = nums[p2];
                    p2++;
                } else {
                    p2++;
                }

            } else {
                p1++;
                nums[p1] = nums[p2];
                p2++;
            }
        }
        return p1 + 1;
    }


//    public static void main(String[] args) {
////    int[] nums = new int[]{1,1,2};
//        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        System.out.println(removeDuplicates(nums) + "");
//    }


    //26. 删除排序数组中的重复项
    public static int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    //27. 移除元素
    public static int removeElement(int[] nums, int val) {
        if (null == nums || nums.length == 0) return 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    //     public static void main(String[] args) {
// //        String s1 = "(()())(())";
// //        String s1 = "(()())(())(()(()))";
// //        String s1 = "()()";
// //        String s1 = "(()())(())";
// //        String s1 = "(()())(())(()(()))";//"()()()()(())"
//         // String s1 = "(()(()))";//"()()()()(())"
//         // System.out.println(removeOuterParentheses(s1));
//     }

    //1021. 删除最外层的括号
    public static String removeOuterParentheses(String S) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        stack.push(S.charAt(0));
        for (int i = 1; i < S.length(); i++) {
            stack.push(S.charAt(i));
            if (S.charAt(i) == S.charAt(i - 1)) {
                stack.pop();
            }
        }
        if (stack.isEmpty()) return result;
        for (char c : stack) {
            result += String.valueOf(c);
        }
        return result;
    }


    //
    public boolean isSubsequence(String s, String t) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        int current = 0;
        for (int i = 0; i < t.length(); i++) {
            char child = t.charAt(i);
            if (s.charAt(current) == child) {
                current++;
                if (current == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }

//    public boolean isSubsequence(String s, String t) {
//        int index = 0;
//        int n = s.length();
//        if (n == 0) {
//            return true;
//        }
//        for (int i = 0; i < t.length(); i++) {
//            if (s.charAt(index) == t.charAt(i)) {
//                index++;
//                if (index == s.length()) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}