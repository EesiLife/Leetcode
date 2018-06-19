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
        int[] A = new int[]{0,2,1,0};
        int[] b = new int[]{
                0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,
                31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,
                59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,
                87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,
                111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,
                131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,
                151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,
                171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,
                191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,
                211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,
                231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,
                251,252,253,254,255,256,257,258,259,260,261,262,263,264,265,266,267,268,269,270,
                271,272,273,274,275,276,277,278,279,280,281,282,283,284,285,286,287,288,289,290,
                291,292,293,294,295,296,297,298,299,300,301,302,303,304,305,306,307,308,309,310,
                311,312,313,314,315,316,317,318,319,320,321,322,323,324,325,326,327,328,329,330,
                331,332,333,334,335,336,337,338,339,340,341,342,343,344,345,346,347,348,349,350,
                351,352,353,354,355,356,357,358,359,360,361,362,363,364,365,366,367,368,369,370,371,372,373,374,375,376,377,378,379,380,381,382,383,384,385,386,387,388,389,390,391,392,393,394,395,396,397,398,399,400,
                401,402,403,404,405,406,407,408,409,410,411,412,413,414,415,416,417,418,419,420,421,422,423,424,425,426,427,428,429,430,431,432,433,434,435,436,437,438,439,440,441,442,443,444,445,446,447,448,449,450,451,452,453,454,455,456,457,458,459,460,461,462,463,464,465,466,467,468,469,470,
                471,472,473,474,475,476,477,478,479,480,481,482,483,484,485,486,487,488,489,490,
                491,492,493,494,495,496,497,498,499,500,498,497,496,495,494,493,492,491,490,489,
                488,487,486,485,484,483,482,481,480,479,478,477,476,475,474,473,472,471,470,469,
                468,467,466,465,464,463,462,461,460,459,458,457,456,455,454,453,452,451,450,449,
                448,447,446,445,444,443,442,441,440,439,438,437,436,435,434,433,432,431,430,429,428,
                427,426,425,424,423,422,421,420,419,418,417,416,415,414,413,412,411,410,409,408,407,
                406,405,404,403,402,401,400,399,398,397,396,395,394,393,392,391,390,389,388,387,386,
                385,384,383,382,381,380,379,378,377,376,375,374,373,372,371,370,369,368,367,366,365,364,363,362,361,360,359,358,357,356,355,354,353,352,351,350,349,348,347,346,345,344,343,342,341,340
                ,339,338,337,336,335,334,333,332,331,330,329,328,327,326,325,324,323,322,321,320,319,318,317,316,315,314,313,312
                ,311,310,309,308,307,306,305,304,303,302,301,300,299,298,297,296,295,294,293,292,291,290,289,288,287,286,285,284,283,282,281,280,279,278,277,276,275,274,273,272,271,270,269,268,267,266,265,264,263,262,261,260,259,258,257,256,255,254,253,252,251
                ,250,249,248,247,246,245,244,243,242,241,240,239,238,237,236,235,234,233,232,231,230,229,228,227,226,225,224,223,222,221,220,219,218,217,216,215,214,213,212,211,210,209,208,207,206,205,204,203,202,201,200,199,198,197,196,195,194,193,192,191,190,189,188,187,186,185,184,183,182,181,180,
                179,178,177,176,175,174,173,172,171,170,169,168,167,166,165,164,163,162,161,160,159,158,157,156,155,154,153,152,151,150,149,148,147,146,145,144,143,142,141,140,139,138,137,136,135,134,133,132,131,130,129,128,127,126,125,124,123,122,121,
                120,119,118,117,116,115,114,113,112,111,110,109,108,107,106,105,104,103,102,101
                ,100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,
                29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0
        };//500
        int[] d = new int[]{0,1,4,7,3,2,1}; //3
        int[] e = new int[]{2,1,4,10,11,10,9,8,7,6,5,4,3,2,1};//4
        int[] f = new int[]{1,2,4,7,5,4,3};//3
        int[] g = new int[]{0, 2, 1};//1
        int[] h = new int[]{18,29,38,59,98,100,99,98,90};//5
        System.out.println(t.peakIndexInMountainArray(b));
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
