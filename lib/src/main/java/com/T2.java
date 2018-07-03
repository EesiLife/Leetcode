package com;

import com.eesilif.lib.entity.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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

    public static void main(String[] args) {
        T2 c = new T2();
        int[] nums = new int[]{0, 0,3,4};
        int target = 0;
        int[] re = c.twoSum(nums, target);
        for (int i: re){
            System.out.println(i);
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int len = numbers.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            if (map.containsKey(numbers[i])){
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
            if (target < numbers[i])break;
            temp = target - numbers[i];
            t1 = i + 1;
            if(map.containsKey(temp)){
                List<Integer> list = map.get(temp);
                if (list.size() == 1){
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
        if (s == t)return true;
        for (int i = 0; i < s.length() - 1; i++) {
            String a = String.valueOf(s.charAt(i+1)) + String.valueOf(s.charAt(i));
            if (t.contains(a))
                return true;
        }
        return false;
    }

    int sum = 0;
    //690
    public int getImportance(List<Employee> employees, int id) {
        List<Integer> list = new ArrayList<>();
        for (Employee e: employees) {
            if (e.id == id) {
                sum += e.importance;
                list.addAll(e.subordinates);
                break;
            }
        }
        for (Employee e : employees){

        }
        return 0;
    }

    //744
    public char nextGreatestLetter(char[] letters, char target) {
        List<Character> list = new ArrayList<>();
        for (char c : letters){
            if (!list.contains(c))
                list.add(c);
        }
        char[] arr = new char[list.size()];
        for(int i = 0; i < list.size(); i++){
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
                lo = mid ;
            } else {
                return arr[mid + 1];
            }
        }
        return arr[mid];
    }
}
