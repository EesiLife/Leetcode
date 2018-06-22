package com.eesilife.lib;


import com.eesilif.lib.entity.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Created by siy on 18-5-28.
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        int[][] grid = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        int[][] points = new int[][]{
                {0, 0}, {1, 0}, {2, 0}
        };
//        System.out.println(Arrays.toString(t.numberOfBoomerangs(points)));

        //
//        int[] num1= new int[]{1, 2, 2, 1};
//        int[] nums2 = new int[]{2, 2};
//        int[] result = t.intersection(num1, nums2);
//        for (int i = 0; i <result.length; i++)
//            System.out.println(result[i]);

//        //598
//        t.maxCount(3, 3, new int[][]{{2,2},{3,3}});
//
//        //599
//        String[] list1 = new String[]{"Shogun","Tapioca Express","Burger King","KFC"};
//        String[] list2 = new String[]{"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
//        System.out.println(Arrays.toString(t.findRestaurant(list1,list2)));

        //633
//        int c = 2147482647;
//        int c = 2;
//        int c = 18;
//        System.out.println(t.judgeSquareSum(c));

//        int[] A = new int[]{0,2,1,0};
//        int[] d = new int[]{0,1,4,7,3,2,1}; //3
//        int[] e = new int[]{2,1,4,10,11,10,9,8,7,6,5,4,3,2,1};//4
//        int[] f = new int[]{1,2,4,7,5,4,3};//3
//        int[] g = new int[]{0, 2, 1};//1
//        int[] h = new int[]{18,29,38,59,98,100,99,98,90};//5
//        System.out.println(t.peakIndexInMountainArray(A));

        //
//        int[] nums = new int[]{10,6,7,9,11,5,4,3,2};
//        System.out.println(Arrays.toString(t.findRelativeRanks(nums)));

        //788
        System.out.println(t.rotatedDigits(10));
    }

    //788
    public int rotatedDigits(int N) {
        int result = 0;
        if (N <= 1 || N > 10000 )return result;
        for (int i = 1; i <  N + 1; i++) {
            String s = String.valueOf(i);
            if (s.contains("3") || s.contains("4") || s.contains("7"))continue;
            String a = s.replaceAll("1", "");
            String b = a.replaceAll("0", "");
            String c = a.replaceAll("0", "");
            if(b.length() == 0 || b.equals(""))continue;
            System.out.println(i + "  ");
            result++;
        }
        return result;
    }
    //506
    public String[] findRelativeRanks(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new String[]{};
        } else if (nums.length == 1) {
            return new String[]{"Gold Medal"};
        }else if (nums.length == 2){
            int max = Math.max(nums[0], nums[1]);
            if (max == nums[0]) {
                return new String[]{"Gold Medal","Silver Medal"};
            } else {
                return new String[]{"Silver Medal","Gold Medal"};
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        String[] result = new String[len];
        for (int i = 0; i < len; i++){
            int target = map.get(nums[i]);
            if (i == len - 1) {
                result[target] = "Gold Medal";
            } else if (i == len - 2) {
                result[target] = "Silver Medal";
            } else if (i == len - 3){
                result[target] = "Bronze Medal";
            } else {
                result[target] = String.valueOf(len - i);
            }
        }
        return result;

    }

    //852
    public int peakIndexInMountainArray(int[] A) {
        if(A.length < 3 || A.length > 1000){
            return -1;
        }
        int mid = -1;
        int len = A.length;
        int lo = 0;
        int hi = len - 1;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            int key = A[mid];
            if (key > A[mid - 1] && key > A[mid + 1]) {
                return mid;
            } else if (key > A[mid - 1] && key < A[mid + 1]) {
                lo = mid;
            } else if (key < A[mid - 1] && key > A[mid + 1]) {
                hi = mid ;
            }
        }
        return mid;
    }

    //690
    public int getImportance(List<Employee> employees, int id) {
        Employee target = new Employee();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for ( Employee e : employees) {
            if (e.id == id){
                target = e;
            }
            map.put(e.id, e.subordinates);
            map1.put(e.id, e.importance);
        }
        while (null != target.subordinates && target.subordinates.size() >0){

        }
        return 0;
    }

    //633
    public boolean judgeSquareSum(int c) {
        if (c < 0)return false;
        long a = System.currentTimeMillis();
        int sqrt = (int)Math.sqrt(c);
        for (int i = 0; i <= sqrt; i++) {
            int as = i * i;
            for (int j = sqrt; j >= sqrt/2; j--) {
                int bs = j * j;
                if (c == as + bs) {
                    System.out.println("i: " + i + ", j: " + j);
                    long s = (System.currentTimeMillis() - a);
                    System.out.println(s);
                    return true;
                }
            }
        }long s = (System.currentTimeMillis() - a);
        System.out.println("false: " + s);
        return false;
    }

    //599
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> l1= Arrays.asList(list1);
        List<String> l2= Arrays.asList(list2);
        ArrayList<String> list = new ArrayList<>();
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        HashMap<Integer, Integer> mapL = new HashMap<>();
        int len = 0;
        for (String s : l1){
            if (l2.contains(s)) {
                len = s.length();
                int index = l1.indexOf(s) + l2.indexOf(s);
                if (null == mapL.get(len)) {
                    mapL.put(len, index);
                    list = new ArrayList<>();
                    list.add(s);
                    map.put(len, list);
                } else {
                    int indexO = mapL.get(len);
                    list = map.get(len);
                    if (index < indexO) {
                        list.clear();
                        list.add(s);
                        map.put(len, list);
                        mapL.put(len, index);
                    } else if (index == indexO) {
                        list.add(s);
                        map.put(len, list);
                    }
                }
            }
        }
        int min = -1;
        for (int key : mapL.keySet()){
            if (min == -1){
                min = mapL.get(key);
            }
            if (min > mapL.get(key)){
                min = mapL.get(key);
            }
        }
        List<Integer> lisKey = new ArrayList<>();

        for (int key : mapL.keySet()){
            if (mapL.get(key) == min) {
                lisKey.add(key);
            }
        }
        list = new ArrayList<>();
        for (int key : lisKey){
           list.addAll(map.get(key));
        }
        len = list.size();

        String[] array = new String[len];
        String[] result =list.toArray(array);
        return result;
    }

    //598
    public int maxCount(int m, int n, int[][] ops) {
        if (null == ops || ops.length == 0)return m*n;
        int len = ops.length;
        int maxA = ops[0][0];
        int maxB = ops[0][1];
        for (int i = 0; i < len; i++) {
            int a = ops[i][0];
            int b = ops[i][1];
            if ( a <= maxA){
                maxA = a;
            }
            if (b <= maxB){
                maxB = b;
            }
        }
        return maxA * maxB;
    }

    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for(int j = i; j < height.length; j++ ){
                int x = j - i;
                int y = height[i] > height[j] ? height[j] : height[i];
                int area = x * y;
                if (area > max) max = area;
            }
        }
        return max;
    }

    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int m = points[0].length;
        int n = points.length;
        if (m != 2) return 0;
        if (n > 500)return 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int temp = 0;
            for (int j = 0; j < n; j++) {
                int x1 = points[j][0];
                int y1 = points[j][1];
                int ss = 0;
                temp = (x1 - x) * (x1 - x) + (y1 - y) * (y1 - y);
                if (map.get(temp)!= null &&map.get(temp) > 0) {
                    ss = map.get(temp) + 1;
                    map.put(temp, ss);
                } else {
                    map.put(temp, 1);
                }
            }
            System.out.println("i: " + i);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
                int value = entry.getValue();
                if (value > 1) {
                    sum += (value - 1) * value;
                }
            }
            map.clear();
            System.out.println();
        }
        return sum;
    }

    public int islandPerimeter(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int temp = 4;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        temp--;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        temp--;
                    }
                    if (i + 1 < n && grid[i + 1][j] == 1) {
                        temp--;
                    }
                    if (j + 1 < m && grid[i][j + 1] == 1) {
                        temp--;
                    }
                    sum += temp;
                }
            }
        }
        return sum;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            int n1 = nums1[i];
            if(set.contains(n1))continue;
            for (int j = 0; j < nums2.length; j++) {
                if (n1 == nums2[j]) {
                    set.add(n1);
                    break;
                }
            }
        }
        if (set.size() >0) {
            Integer[] temp = set.toArray(new Integer[] {});
            int[] result = new int[temp.length];
            for (int i = 0; i < temp.length; i++) {
                result[i] = temp[i].intValue();
            }
            return result;
        }else {
            return new int[]{};
        }

    }
}
