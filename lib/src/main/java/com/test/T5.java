package com.test;

import java.util.ArrayList;
import java.util.Arrays;
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

    public int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                len++;
            } else if (len != 0) {
                return len;
            }
        }
        return len;
    }

//    //989
//    public List<Integer> addToArrayForm2(int[] A, int K) {
//        int lenA = A.length;
//        String k = String.valueOf(K);
//        int lenK = k.length();
//        int ca = 0;
//        StringBuilder ans = new StringBuilder();
//        for (int i = lenA - 1, j = lenK -1; i >= 0 || j >= 0; i--, j--) {
//            int sum = ca;
//            sum += i >= 0 ? A[i] : 0;
//            sum += j >= 0 ? k.charAt(j) - '0' : 0;
//            ans.append(sum % 10);
//            ca = sum / 10;
//        }
//        ans.append(ca == 1 ? ca : "");
//        String s = ans.reverse().toString();
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            result.add(Integer.parseInt(String.valueOf(s.charAt(i))));
//        }
//        return result;
//    }
//
//    public List<Integer> addToArrayForm1(int[] A, int K) {
//        String a = "";
//        for (int i = 0; i < A.length; i++) {
//            a +=A[i];
//        }
//        String b = String.valueOf(K);
//        StringBuilder ans = new StringBuilder();
//        int ca = 0;
//        int lenA = a.length();
//        int lenB = b.length();
//        for (int i = lenA -1, j = lenB -1; i >=0 || j >= 0; i--, j--) {
//            int sum = ca;
//            sum += i >= 0 ? a.charAt(i) - '0' : 0;
//            sum += j >= 0 ? b.charAt(j) - '0' : 0;
//            ans.append(sum % 10);
//            ca = sum / 10;
//        }
//        ans.append(ca == 1 ? ca : "");
//        String s = ans.reverse().toString();
//        System.out.println(s);
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            result.add(Integer.parseInt(String.valueOf(s.charAt(i))));
//        }
//        return result;
//    }
//    public List<Integer> addToArrayForm(int[] A, int K) {
//        long a = 0;
//        for (int i = A.length -1; i >=0; i--) {
//            a += A[i] * Math.pow(10, A.length -1 -i);
//        }
//        long c = a + K;
//        String s = String.valueOf(c);
//        System.out.println(s);
//        List<Integer> ans = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            ans.add(Integer.parseInt(String.valueOf(s.charAt(i))));
//        }
//        return ans;
//    }
//    public static void main(String[] args) {
////        int[] A = new int[]{1,2,0,0};int  K = 34;
////        int[] A = new int[]{2,7,4};int K = 181;
////        int[] A = new int[]{2,1,5};int K = 806;
//        int[] A = new int[]{9,9,9,9,9,9,9,9,9,9};int K = 1;
//        System.out.println(new T5().addToArrayForm2(A,K));
//    }


    //67
//    public String addBinary(String a, String b) {
//        StringBuilder ans = new StringBuilder();
//        int ca = 0;
//        int lenA = a.length();
//        int lenB = b.length();
//        for (int i = lenA -1, j = lenB -1; i >=0 || j >= 0; i--, j--) {
//            int sum = ca;
//            sum += i >= 0 ? a.charAt(i) - '0' : 0;
//            sum += j >= 0 ? b.charAt(j) - '0' : 0;
//            ans.append(sum % 2);
//            ca = sum / 2;
//        }
//        ans.append(ca == 1 ? ca : "");
//        return ans.reverse().toString();
//    }
//    public static void main(String[] args) {
//        String a = "1010", b = "1011";
//        System.out.println(new T5().addBinary(a, b));
//    }
//    //66
//    public int[] plusOne(int[] digits) {
//        int len = digits.length;
//        boolean plus = false;
//        for (int i = len -1; i >=0; i--) {
//            int a = digits[i];
//            if (a + 1 < 10) {
//                digits[i] = a + 1;
//                break;
//            } else {
//                digits[i] = 0;
//                if (i == 0) {
//                    plus = true;
//                }
//            }
//        }
//        if (plus) {
//            int[] res = new int[len+1];
//            for (int i = 0; i < len + 1; i ++) {
//                if (i == 0) {
//                    res[i] = 1;
//                } else {
//                    res[i] = digits[i -1];
//                }
//            }
//            return res;
//        }
//        return digits;
//    }
//
//    public static void main(String[] args) {
////        int[] nums = new int[]{1,2,3};
//        int[] nums = new int[]{4,3,2,1};
////        int[] nums = new int[]{9,9,9,9};
//        System.out.println(Arrays.toString(new T5().plusOne(nums)));
//    }

    //673
//    public int findNumberOfLIS(int[] nums) {
//        if (null == nums || nums.length == 0) return 0;
//        int len = nums.length;
//        int max = 1;
//        int set = 0;//0表示相等,1递增,2递减
//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(max, 1);
//        for (int i = 1; i < len; i++) {
//            if (nums[i] > nums[i - 1]) {
//                if (set <= 0) {
//                    set = 2;
//                } else if (set > 0) {
//                    set++;
//                }
//            } else if (nums[i] < nums[i - 1]) {
//                if (set >= 0) {
//                    set = -2;
//                } else if (set < 0) {
//                    set--;
//                }
//            } else {
//                set = 0;
//            }
//            if (set > max) {
//                max = set;
//                map.put(set, 1);
//            } else if (set == max) {
//                int temp = map.get(max);
//                map.put(max, temp+1);
//            }
//        }
//        System.out.println(max);
//        return map.get(max);
//    }
//    public static void main(String[] args) {
////        int[] nums = new int[]{5,4,4,6,2,3,1};
//        int[] nums = new int[]{1,3,5,4,7};
////        int[] nums = new int[]{2,2,2,2,2};
//        System.out.println(new T5().findNumberOfLIS(nums));
//    }

//    //611
//    public int triangleNumber(int[] nums) {
//        if (null == nums || nums.length <= 2)return 0;
//        int result = 0;
//        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
//        int len = nums.length;
//        for (int i = 0; i < len -2; i++) {
//            for (int j = i + 1; j < len -1; j++) {
//                for (int k = j + 1; k < len; k++) {
//                    if (nums[i] + nums[j] > nums[k]) {
//                        System.out.println("{"+ i + ","+ j + "," + k + "},"+"{"+ nums[i] + ","+ nums[j] + "," + nums[k] + "}");
//                        result++;
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//    public static void main(String[] args){
//        int[] nums = new int[]{5,4,4,6,2,3,1};
////        int[] nums = new int[]{2,2,3,4};
//        System.out.println(new T5().triangleNumber(nums));
//    }

//    public int findLengthOfLCIS(int[] nums) {
//        if (null == nums || nums.length == 0) return 0;
//        int len = nums.length;
//        int max = 1;
//        int set = 0;//0表示相等,1递增,2递减
//        for (int i = 1; i < len; i++) {
//            if (nums[i] > nums[i -1]) {
//                if (set <= 0) {
//                    set = 2;
//                } else if (set > 0) {
//                    set++;
//                }
//            } else if (nums[i] < nums[i -1]) {
//                if (set >= 0) {
//                    set = -2;
//                } else if (set < 0) {
//                    set--;
//                }
//            } else {
//                set = 0;
//            }
//            max = Math.max(max, set);
//        }
//        return max;
//    }
//    public static void main(String[] args) {
////        int[] nums = new int[]{1,3,5,4,7};
////        int[] nums = new int[]{2,2,2,2,2};
////        int[] nums = new int[]{1,3,5,4,2,3,4,5};
//        int[] nums = new int[]{2,1};
//        System.out.println(new T5().findLengthOfLCIS(nums));
//    }

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