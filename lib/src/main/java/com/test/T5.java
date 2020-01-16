package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public int findLengthOfLCIS(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int len = nums.length;
        int max = 1;
        int set = 0;//0表示相等,1递增,2递减
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i -1]) {
                if (set <= 0) {
                    set = 2;
                } else if (set > 0) {
                    set++;
                }
            } else if (nums[i] < nums[i -1]) {
                if (set >= 0) {
                    set = -2;
                } else if (set < 0) {
                    set--;
                }
            } else {
                set = 0;
            }
            max = Math.max(max, set);
        }
        return max;
    }
    public static void main(String[] args) {
//        int[] nums = new int[]{1,3,5,4,7};
//        int[] nums = new int[]{2,2,2,2,2};
//        int[] nums = new int[]{1,3,5,4,2,3,4,5};
        int[] nums = new int[]{2,1};
        System.out.println(new T5().findLengthOfLCIS(nums));
    }

    //dp[i]表示以nums[i]结尾时,最大子数组和
    //dp[i] = max(dp[i-1]+nums[i],nums[i])
//    public int maxSubArray(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        int ans = dp[0];
//        for (int i = 1, len = nums.length; i < len; i++) {
//            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
//            ans = Math.max(ans, dp[i]);
//        }
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        System.out.println(new T5().maxSubArray(nums));
//    }


//    public boolean isMonotonic(int[] A) {
//        if (A.length <= 2)return true;
//        int set = 0;
//        for (int i = 1; i < A.length; i ++) {
//            if (A[i] > A[i -1]) {
//                if (set == 0) {
//                    set++;
//                } else if (set < 0) {
//                    return false;
//                }
//            } else if (A[i] < A[i -1]) {
//                if (set == 0) {
//                    set--;
//                } else if (set > 0) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//    public static void main(String[] args) {
////        int[] nums = new int[]{1,2,2,3};
////        int[] nums = new int[]{6,5,4,4};
////        int[] nums = new int[]{1,3,2};
////        int[] nums = new int[]{1,2,4,5};
//        int[] nums = new int[]{1,1,1};
//        System.out.println(new T5().isMonotonic(nums));
//    }

//    static class Item {
//        int startIndex;
//        int endIndex;
//        int cnt;
//    }
//
//    public int findShortestSubArray1(int[] nums) {
//        Map<Integer, Item> map = new HashMap<>();
//        int arrDu = 0;
//        for (int i = 0, len = nums.length; i < len; i++) {
//            Item item = map.get(nums[i]);
//            if (item == null) {
//                item = new Item();
//                item.startIndex = item.endIndex = i;
//                item.cnt = 1;
//                map.put(nums[i], item);
//            } else {
//                item.endIndex = i;
//                item.cnt++;
//            }
//            arrDu = Math.max(arrDu, item.cnt);
//        }
//
//        int ans = nums.length;
//        for (Map.Entry<Integer, Item> entry : map.entrySet()) {
//            Item item = entry.getValue();
//            if (item.cnt == arrDu) {
//                ans = Math.min(item.endIndex - item.startIndex + 1, ans);
//            }
//        }
//        return ans;
//    }
//
//    public int findShortestSubArray(int[] nums) {
//        HashMap<Integer, Integer> list = new HashMap<>();
//        HashMap<Integer, Integer[]> ll = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (null == list.get(nums[i])) {
//                list.put(nums[i], 1);
//            } else {
//                int tmp = list.get(nums[i]);
//                tmp++;
//                list.put(nums[i], tmp);
//            }
//
//            if (null == ll.get(nums[i])) {
//                Integer[] i1 = new Integer[]{-1, -1};
//                i1[0] = i;
//                ll.put(nums[i], i1);
//            } else {
//                Integer[] i2 = ll.get(nums[i]);
//                i2[1] = i;
//                ll.put(nums[i], i2);
//            }
//        }
//        int max = 0, step = 0;
//        for (Integer i : list.keySet()) {
//            if (list.get(i) > max) {
//                max = list.get(i);
//                Integer[] steps = ll.get(i);
//                step = steps[1] - steps[0];
//            } else if (list.get(i) == max) {
//                Integer[] steps = ll.get(i);
//                int step_cur = steps[1] - steps[0];
//                if (step > step_cur) {
//                    max = list.get(i);
//                    step = step_cur;
//                }
//            }
//        }
//        return step <= 0 ? 1 : step + 1;
//    }

//    public static void main(String[] args) {
////        int[] nums = new int[]{1, 2, 2, 3, 1};
//        int[] nums = new int[]{1, 2, 2, 3, 1, 4, 2};
//        System.out.println(new T5().findShortestSubArray(nums));
//    }

    //873. 最长的斐波那契子序列的长度
//    public int lenLongestFibSubseq(int[] A) {
//        if (A == null || A.length < 3) return 0;
//        int k = 0;
//        int l = 0;
////        int n1 = A[0], n2 = A[1];
//        for (int i = 2; i < A.length; i++) {
//            int n1 = A[i - 2], n2 = A[i - 1];
//            for (int j = i; j < A.length; j++) {
//                if (n1 + n2 == A[j]) {
//                    n1 = n2;
//                    n2 = A[j];
//                    if (j == 2) {
//                        k = 3;
//                    } else {
//                        k++;
//                    }
//                }
//            }
//            if (k > l) l = k;
//            k = 0;
//        }
//        return l;
//    }
//    public int lenLongestFibSubseq(int[] A) {
//        if (A == null || A.length < 3) return 0;
//        int k = 0;
//        int l = 0;
//        for (int i = 0; i < A.length - 2; i++) {
//            int n1 = A[i], n2 = A[i + 1];
//            for (int j = i + 2; j < A.length; j++) {
//                if (n1 + n2 == A[j]) {
//                    if (j == i + 2) {
//                        k = 3;
//                    } else {
//                        k++;
//                    }
//                    n1 = n2;
//                    n2 = A[j];
//                }
//            }
//            if (k > l) l = k;
//            k = 0;
//        }
//        return l;
//    }
//
//    public static void main(String[] args) {
////        int[] A = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
//        int[] A = new int[]{1, 3, 7, 11, 12, 14, 18};
//        System.out.println(new T5().lenLongestFibSubseq(A));
//    }

//    public static void main(String[] args) {
////        int[] nums = new int[]{1, 3, 5, 6};
////        int target = 5;
//
////        int[] nums = new int[]{1,3,5,6};
////        int target = 2;
//
////        int[] nums = new int[]{1,3,5,6};
////        int target = 7;
//
//        int[] nums = new int[]{1, 3, 5, 6};
//        int target = 0;
//
//        int result = new T5().searchInsert(nums, target);
//        System.out.println(result);
//    }
//
//    public int searchInsert(int[] nums, int target) {
//        int low = 0;
//        int high = nums.length - 1;
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//            if (nums[mid] > target)
//                high = mid - 1;
//            else if (nums[mid] < target)
//                low = mid + 1;
//            else
//                return mid;
//        }
//        return low;
//    }

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
//    public int aremoveDuplicates(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int p1 = 0;
//        int p2 = 1;
//        int len = nums.length;
//        while (p2 < len) {
//            if (nums[p1] == nums[p2]) {
//                if (p1 == 0 || nums[p1 - 1] != nums[p2]) {
//                    p1++;
//                    nums[p1] = nums[p2];
//                    p2++;
//                } else {
//                    p2++;
//                }
//
//            } else {
//                p1++;
//                nums[p1] = nums[p2];
//                p2++;
//            }
//        }
//        return p1 + 1;
//    }


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
//    public static String removeOuterParentheses(String S) {
//        String result = "";
//        Stack<Character> stack = new Stack<>();
//        stack.push(S.charAt(0));
//        for (int i = 1; i < S.length(); i++) {
//            stack.push(S.charAt(i));
//            if (S.charAt(i) == S.charAt(i - 1)) {
//                stack.pop();
//            }
//        }
//        if (stack.isEmpty()) return result;
//        for (char c : stack) {
//            result += String.valueOf(c);
//        }
//        return result;
//    }
//
//
//    //
//    public boolean isSubsequence(String s, String t) {
//        int len = s.length();
//        if (len == 0) {
//            return true;
//        }
//        int current = 0;
//        for (int i = 0; i < t.length(); i++) {
//            char child = t.charAt(i);
//            if (s.charAt(current) == child) {
//                current++;
//                if (current == s.length()) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

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