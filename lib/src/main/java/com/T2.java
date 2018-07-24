package com;

import com.eesilif.lib.entity.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class T2 {
    public double myPow(double x, int n) {
        if (n < 0)
            return 1 / x * myPow(1 / x, -(n + 1));
        else if (n == 0)
            return 1;
        else if (n == 1)
            return x;

        double half = myPow(x, n >> 1);
        half *= half;

        if ((n & 1) == 1)
            half *= x;
        return half;
    }

    double myPow3(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return myPow3(1 / x, -(n + 1)) / x;
        Stack<Integer> s = new Stack<Integer>();
        for (; n != 1; n /= 2)
            s.push(n);
        double t = x;
        while (!s.isEmpty()) {
            t *= t;
            if (s.pop() % 2 != 0)
                t *= x;
        }
        return t;
    }

    public static void test(){
        int onoff = 3;
        System.out.println(onoff & ~2);
    }

    public static void main(String[] args) {
//       int[] num1 = new int[]{1,2,3,0,0,0};//6
//       int[] num2 = new int[]{2,5,6};//3
//        int[] num1 = new int[]{0};//0
//        int[] num2 = new int[]{1};//1
//        T2 c = new T2();
//        c.merge(num1,0, num2, 1);

        T2 c = new T2();
        test();
        test();
        test();
        test();
    }

    //475
    public int findRadius(int[] houses, int[] heaters) {
        int hL = heaters.length;
        for(int i = 0; i < hL; i++){

        }
        return 0;
    }

    //441. 排列硬币
    public int arrangeCoins(int n) {
//        n *= 2;
        int lo = 1;
        int hi = n;
        while (lo < hi) {
            int middle = lo + (hi - lo) / 2;
            if (middle == n / (middle + 1) * 2) return middle;
            if (middle< n / (middle + 1) * 2) {
                if ((middle + 1)> n / (middle + 2) * 2) {
                    return middle;
                }
                lo = middle;
            }
            if (middle > n / (middle + 1) * 2) {
                hi = middle;
            }
        }
        return hi;
    }

    //628
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int n1 = 0, n2 = 1, nmax = len - 1;
        int n3 = len - 2, n4 = len - 3;
        int m1 = nums[n1] * nums[n2] * nums[nmax];
        int m2 = nums[n3] * nums[n4] * nums[nmax];
        return m1 > m2 ? m1 : m2;
    }

    //69
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int lo = 1;
        int hi = x;
        int middle = 0;
        while (lo <= hi) {
            middle = lo + (hi - lo) / 2;
            if (middle == x / middle) {
                return middle;
            } else {
                if (middle < x / middle) {
                    lo = middle + 1;
                } else {
                    hi = middle - 1;
                }
            }

        }
        return hi;
    }

    //88
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(nums2[i]);
        }
        if (nums1.length == 0) {
            len = nums2.length;
            nums1 = new int[len];
            n = 0;
        } else {

        }
        for (int i = n; i < len; i++) {
            if (list.size() > 0) {
                nums1[i] = list.get(0);
                list.remove(0);
            } else break;
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    //350.
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> l2 = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int len2 = nums2.length;
        for (int i = 0; i < len2; i++) {
            l2.add(nums2[i]);
        }
        int len1 = nums1.length;
        for (int i = 0; i < len1; i++) {
            if (l2.contains(nums1[i])) {
                int temp = 0;
                if (null != map.get(nums1[i])) {
                    temp = map.get(nums1[i]);

                }
                temp++;
                map.put(nums1[i], temp);
                l2.remove(new Integer(nums1[i]));
            }
        }
        List<Integer> result = new ArrayList<>();
        for (Integer key : map.keySet()) {
            System.out.println(String.format("key: %d , value = %d", key, map.get(key)));
            for (int i = 0; i < map.get(key); i++) {
                result.add(key);
            }
        }
        int[] re = new int[result.size()];
        for (int i = 0; i < re.length; i++) {
            re[i] = result.get(i);
        }
        return re;
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int len = numbers.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            if (map.containsKey(numbers[i])) {
                list.addAll(map.get(numbers[i]));
            }
            if (list.size() <= 1) {
                list.add(i);
                map.put(numbers[i], list);
            }
        }
        int temp;
        int t1 = -1;
        int t2 = -2;
        for (int i = 0; i < len - 1; i++) {
            if (target < numbers[i]) break;
            temp = target - numbers[i];
            t1 = i + 1;
            if (map.containsKey(temp)) {
                List<Integer> list = map.get(temp);
                if (list.size() == 1) {
                    t2 = list.get(0) + 1;
                } else {
                    t2 = list.get(1) + 1;
                }
                break;
            }
        }
        result[0] = t1;
        result[1] = t2;
        return result;
    }

    public int findContentChildren(int[] g, int[] s) {

        for (int i = 0; i < s.length; i++) {
//            for (int j = 0; j < g.length; j++){
//                if (s[i] > = )
//            }
        }
        return 0;
    }

    public boolean isAnagram(String s, String t) {
        if (s == t) return true;
        for (int i = 0; i < s.length() - 1; i++) {
            String a = String.valueOf(s.charAt(i + 1)) + String.valueOf(s.charAt(i));
            if (t.contains(a))
                return true;
        }
        return false;
    }

    int sum = 0;

    //690
    public int getImportance(List<Employee> employees, int id) {
        List<Integer> list = new ArrayList<>();
        for (Employee e : employees) {
            if (e.id == id) {
                sum += e.importance;
                list.addAll(e.subordinates);
                break;
            }
        }
        for (Employee e : employees) {

        }
        return 0;
    }

    //744
    public char nextGreatestLetter(char[] letters, char target) {
        List<Character> list = new ArrayList<>();
        for (char c : letters) {
            if (!list.contains(c))
                list.add(c);
        }
        char[] arr = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        char min = arr[0], max = arr[arr.length - 1];
        if (target < min || target >= max) return min;
        int mid = -1;
        int len = arr.length;
        int lo = 0;
        int hi = len - 1;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            char key = arr[mid];
            if (lo + 1 == hi) {
                return arr[hi];
            }
            if (key > target) {
                hi = mid;
            } else if (key < target) {
                lo = mid;
            } else {
                return arr[mid + 1];
            }
        }
        return arr[mid];
    }
}
