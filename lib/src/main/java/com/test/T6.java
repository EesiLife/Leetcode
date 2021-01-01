package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class T6 {
    public static int longestWPI(int[] hours) {
        int len = hours.length;
        int[] score = new int[len];
        for (int i = 0; i < len; i++) {
            if (hours[i] > 8) {
                score[i] = 1;
            } else {
                score[i] = -1;
            }
        }
        int[] preSum = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            preSum[i] = preSum[i - 1] + score[i - 1];
        }
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len + 1; i++) {
            if (stack.isEmpty() || preSum[stack.peek()] > preSum[i]) {
                stack.push(i);
            }
        }
        int i = len;
        while (i > ans) {
            while (!stack.isEmpty() && preSum[stack.peek()] < preSum[i]) {
                ans = Math.max(ans, i - stack.peek());
                stack.pop();
            }
            i--;
        }
        return ans;
    }

    public static int getRampIndex(int i, int[] A, int cur) {
        int j = A.length - 1;
        for (; j >= i; j--) {
            if (A[j] >= cur) {
                break;
            }
        }
        return j;
    }

    public static int maxWidthRamp(int[] A) {
        int ans = 0;
        int len = A.length;
        for (int i = 0; i < len; i ++) {
            ans = Math.max(ans, getRampIndex(i, A, A[i]) - i);
        }
        return ans;
    }

    public static int maxWidthRamp1(int[] A) {
        int ans = 0;
        int len = A.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (st.isEmpty() || A[st.peek()] > A[i]) {
                st.push(i);
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            while (!st.isEmpty() && A[st.peek()] <= A[i]) {
                ans = Math.max(ans,  i - st.pop());
            }
        }

        return ans;
    }

//    public static void main(String[] args) {
//        int[] a = new int[]{1,0,0,0,0,1};
//        int N = 2;
//        System.out.println(canPlaceFlowers(a, N));
//    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            int cur = flowerbed[i];
            boolean place = false;
            if (cur != 0) continue;
            if (i == 0 ) {
                if(i + 1 == len || ((i + 1 < len) && flowerbed[i + 1] == 0)){
                    place = true;
                }
            } else if (i + 1 == len) {
                if(flowerbed[i - 1] == 0)place = true;
            } else {
                if(flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) place = true;
            }
            if (place){
                count++;
                flowerbed[i] = 1;
            }
        }
        return count >= n;
    }


    public static int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) return 0;
        int ans = 0;
        int row = grid.length;
        int line = grid[0].length;
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < line -2; j++) {
                if (!checkValidNum(grid, i, j)) continue;
                if (checkValid(grid, i, j)) ans++;
            }
        }
        return ans;
    }

    public static boolean checkValidNum(int[][] a, int i, int j) {
        HashSet<Integer> set = new HashSet<>();
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                if (a[k][l] > 0 && a[k][l] < 10) {
                    set.add(a[k][l]);
                } else {
                    return false;
                }
            }
        }
        return set.size() == 9;
    }

    public static boolean checkValid(int[][] a, int i, int j) {
        int sum1 = a[i][j] + a[i][j + 1] + a[i][j + 2];
        int sum2 = a[i+1][j] + a[i+1][j+1] + a[i+1][j +2];
        if (sum1 != sum2) return false;
        int sum3 = a[i+2][j] + a[i+2][j+1] + a[i+2][j+2];
        if (sum3 != sum2) return false;
        int sum4 = a[i][j] + a[i+1][j] + a[i+2][j];
        if (sum4 != sum3) return false;
        int sum5 = a[i][j+1] + a[i+1][j+1] + a[i+2][j+1];
        if (sum5 != sum4) return false;
        int sum6 = a[i][j+2] + a[i+1][j+2] + a[i+2][j+2];
        if (sum6 != sum5) return false;
        int sum7 = a[i][j] + a[i+1][j+1] + a[i+2][j+2];
        if (sum7 != sum6) return false;
        int sum8 = a[i][j+2] + a[i+1][j+1] + a[i+2][j];
        if (sum8 != sum7) return false;
        return true;
    }

    public static int maxDistToClosest(int[] seats) {
        int ans = 0;
        int len = seats.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(left, len);
        Arrays.fill(right, len);
        for (int i = 0; i < len; i++) {
            if (seats[i] == 0) left[i] = 0;
            else if (i > 0) left[i] = left[i - 1] + 1;
        }
        for (int i = len - 1; i >= 0; i--) {
            if (seats[i] == 0) right[i] = 0;
            else if (i < len - 1) right[i] = left[i + 1] + 1;
        }
        for (int i = len - 1; i >= 0; i--) {
            if (seats[i] == 0)
                ans = Math.max(ans, Math.min(left[i], right[i]));
        }
        return ans;
    }


    public static boolean containsPattern(int[] arr, int m, int k) {
        String key = "";
        int count = 0;

        for(int i = 0; i < arr.length; i ++) {
            String cur = "";
            for (int l = i; l < i + m; l++ ) {
                cur+= String.valueOf(arr[l]);
            }
            for(int j = i + 1; j < i+ m && j < arr.length;j ++) {
                cur+= String.valueOf(arr[j]);
            }
            if ("".equals(key) || key.equals(cur)) {
                if (++count == k) break;
            } else {
                count = 1;
            }
            key = cur;
        }
        return count >= k;
    }

    public static int diagonalSum(int[][] mat) {
        int m = mat.length;
        int sum = 0;
        boolean r = m % 2 != 0;
        int index = m/2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    sum+= mat[i][j];
                    if (Math.abs(m - 1 - j) != j) {
                        sum+= mat[i][Math.abs(m - 1 - j)];
                    }
                }
            }
        }
//        if (r) {
//            sum-= mat[index][index];
//        }
        return sum;
    }

    public static int findLengthOfShortestSubarray(int[] arr) {
        int len = arr.length;
        Stack<Integer> stack = new Stack<>();
        int minLeft = arr[0];
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    minLeft = Math.max(stack.pop(),minLeft);
                }
                stack.push(arr[i]);
            }
        }
        System.out.println(stack.size());
        return stack.size();
    }



//    public static void main(String[] args) {
////        int[][] a = new int[][] {
////                {1,2,3},
////                {4,5,6},
////                {7,8,9}
////        };
////        int[][] a = new int[][] {
////                {1,1,1,1},
////                {1,1,1,1},
////                {1,1,1,1},
////                {1,1,1,1}
////        };
////        System.out.println(diagonalSum(a));
//        int[] a = new int[] {
//                1,2,3,10,4,2,3,5
//        };
//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.getOrDefault(10, 0);
//        System.out.println(findLengthOfShortestSubarray(a));
//    }


    public static int findRepeatNumber(int[] nums) {
        int temp;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return -1;
    }

    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        int tmp = -1;
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                tmp = numbers[i];
                numbers[i] = numbers[tmp];
                numbers[tmp] = tmp;
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >=0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            res[i] = stack.pop();
        }
        System.out.println(Arrays.toString(res));
        return res;
    }


    public static int[] printNumbers(int n) {
        if (n == 0) return new int[0];
//        int len = 1;
////        while(n > 0) {
////            len *= 10;
////        }
////        len--;
        int len = (int)Math.pow(10, n);
        int[] ans = new int[len];
        for (int i = 0; i < len -1; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>=1;
        }
        return count;
    }

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        double res = 1.00000;
        if (n < 0) {
            x = res / x;
            n = -n;
        }
        long a = n;
        while ( a > 0) {
            if( (a & 1) == 1) res *= x;
            x*=x;
            a >>= 1;
        }
        return res;
    }

    public static int[] exchange(int[] nums) {
        int left = 0, right = nums.length -1;
        while (left <= right) {
            if (nums[left] % 2 == 0) {
                if (nums[right] % 2 != 0) {
                    int tmp = nums[left];
                    nums[left] = tmp;
                    nums[right] = tmp;
                }
                right--;
                left++;
            } else {
                left++;
                if (nums[right] % 2 == 0) {
                    right--;
                }
            }
        }
        return nums;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null == nums || nums.length < 3) return ans;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1])continue;
            int L = i + 1, R = len -1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1] ) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                } else if (sum > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        return ans;

    }

    public static int countDigitOne(int n) {
        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            char[] arr = String.valueOf(i).toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == '1') ans++;
            }
        }
        return ans;
    }

    public static void duplicateZeros(int[] arr) {
//        int len = arr.length;
//        int last = 0;
//        int zero = 0;
//        for (last = 0; last < len - 1; last++) {
//            if ()
//        }
//        for (int i = last; i >=0; i--) {
//            if (arr[i] == 0) {
//                arr[i + zero] = 0;
//                zero--;
//                arr[i + zero] = 0;
//            } else {
//                arr[i + zero] = arr[i];
//            }
//        }
//        System.out.println(Arrays.toString(arr));
    }

    public static char firstUniqChar(String s) {
        int[] count = new int[26];
        char[] arr = s.toCharArray();
        for(char c : arr) {
            count[c - 'a']++;
        }
        for(char c : arr){
            if(count[c - 'a'] == 1)
                return c;
        }

        return ' ';
    }

    private static int[] ans = new int[1690];

    public static void generateUN() {
        int ungly = 1, i2 = 0, i3 = 0, i5 = 0;
        ans[0] = 1;
        for (int i = 1; i < 1690; i++) {
            ungly = Math.min(ans[i2] * 2, Math.min(ans[i3] * 3, ans[i5] * 5));
            ans[i] = ungly;
            if (ungly == ans[i2] * 2) i2++;
            if (ungly == ans[i3] * 3) i3++;
            if (ungly == ans[i5] * 5) i5++;
        }
    }

    public static int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int[] ans = new int[n];
        ans[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;;
        for (int i = 1; i < n; i++) {
            int ungly = Math.min(ans[i2] * 2, Math.min(ans[i3] * 3, ans[i5] * 5));
            ans[i] = ungly;
            if (ungly == ans[i2] * 2) i2++;
            if (ungly == ans[i3] * 3) i3++;
            if (ungly == ans[i5] * 5) i5++;
        }
        return ans[n -1];
    }

    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) return 0;
        int ans = 0, tmp = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < s.length(); j ++) {
            int i = map.getOrDefault(s.charAt(j), -1);
            map.put(s.charAt(j), j);
            tmp = tmp < j - i ? tmp + 1 : j - i;
            ans = Math.max(tmp, ans);
        }
        return ans;
    }

    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length;i++) {
            int cur = prices[i];
            if (min < cur) {
                ans = Math.max(ans, cur - min);
            } else {
                min = cur;
            }
        }
        return ans;
    }

    public static int sumNums(int n) {
        int ans = (int)Math.pow(n, 2) + n;
        ans >>=1;
        return ans;
    }

    public static int add(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a== 0 && b == 0) return 0;
        if (a < 0 && b < 0) return -(Math.abs(a) | Math.abs(b));
        if (a < 0 || b < 0) return Math.abs(a) ^ Math.abs(b);
        return a | b;
    }

//    class MaxQueue {
//
//
//        public MaxQueue() {
//
//        }
//
//        public int max_value() {
//
//        }
//
//        public void push_back(int value) {
//
//        }
//
//        public int pop_front() {
//
//        }
//    }

    public static int strToInt(String str) {
        if (null == str || "".equals(str)) return 0;
        str = str.trim();
        if ("".equals(str)) return 0;
        char first = str.charAt(0);
        if (!(first == '-'|| first == '+' || (first >= '0' && first <= '9'))) return 0;
        boolean isNegative = false;
        if (str.startsWith("-")) {
            isNegative = true;
        }
        if (str.startsWith("-") ||str.startsWith("+")) {
            str = str.substring(1);
        }
        char[] arr = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            char cur = arr[i];
            if (cur >= '0' && cur <= '9') {
                sb.append(cur);
            } else {
                break;
            }
        }
        if (sb.toString().equals("")) return 0;
        char[] ans = sb.reverse().toString().toCharArray();
        long ret = 0;
        for (int i = 0; i < ans.length;i++) {
            ret += (ans[i] - '0') * Math.pow(10, i);
        }
        if (isNegative) {
            ret = 0 - ret;
        }
        if (ret > Integer.MAX_VALUE) ret = Integer.MAX_VALUE;
        if (ret < Integer.MIN_VALUE) ret = Integer.MIN_VALUE;
        return (int)ret;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null == nums || nums.length < 3) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                   ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }


    public static String[] uncommonFromSentences(String A, String B) {
        if (A.length() == 0 || B.length() == 0) return null;
        HashMap<String, Integer> map = new HashMap<>();
        String[] a = A.split(" ");
        for(String s : a) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        String[] b = A.split(" ");
        for(String s : b) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> ss = new ArrayList<>();
        for(String key :map.keySet()) {
            int val = map.get(key);
            if (val == 1) {
                ss.add(key);
            }
        }
        return ss.toArray(new String[ss.size()]);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num :nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num :nums2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()) {
            Integer val = map.get(key);
            val >>= 1;
            for (int i = 0; i < val; i++) {
                list.add(key);
            }
        }
         int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        String A = "this apple is sweet";
        String B = "this apple is sour";
        System.out.println(Arrays.toString(uncommonFromSentences(A, B)));
    }


}
