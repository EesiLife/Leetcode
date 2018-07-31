package com.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by siy on 18-7-24.
 */
public class T4 {
    //868. 二进制间距
    public int binaryGap(int N) {
        if (N < 1 || N > 1E9) return 0;
        String s = Integer.toBinaryString(N);
        int tep = -1;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (tep == -1 && s.charAt(i) == '1') {
                tep = i;
            }
            if (s.charAt(i) == '1') {
                max = Math.max(i - tep, max);
                tep = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        T4 c = new T4();
//        //868. 二进制间距
//        System.out.println(c.binaryGap(512));

        //compareVersion
//        System.out.println(c.compareVersion1("0.1", "1.1"));
//        System.out.println(c.compareVersion1("1.0.1", "1"));
//        System.out.println(c.compareVersion1("7.5.2.4", "7.5.3"));
//        //"1.00000000000000000000001"
//        //"1.10"
//        System.out.println(c.compareVersion1("1.00000000000000000000001", "1.10"));
//        System.out.println(c.compareVersion1("01", "1"));
        //"1.01"
        //"1.01.1"
//        System.out.println(c.compareVersion1("1.01", "1.01.1"));
        //"4.08"
        //"4.08.01"
//        System.out.println(c.compareVersion1("4.08", "4.08.01"));
        //"19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000"

        // //860. 柠檬水找零
//        int[] a = new int[]{5,5,5,10,20};
//        System.out.println(c.lemonadeChange(a));
//        int[] b = new int[]{5,5,10};
//        System.out.println(c.lemonadeChange(b));
//        int[] d = new int[]{10,10};
//        System.out.println(c.lemonadeChange(d));
//        int[] e = new int[]{5,5,10,10,20};
//        System.out.println(c.lemonadeChange(e));
//        int[] f = new int[]{5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
//        System.out.println(c.lemonadeChange(f));
//        int[] g = new int[]{5,5,5,5,20,20,5,5,20,5};
//        System.out.println(c.lemonadeChange(g));
        System.out.println(c.isHappy(19));
        System.out.println(c.isHappy(7));
        System.out.println(c.isHappy(2));
    }

    //202.
    public boolean isHappy(int n) {
        Set<Integer> add = new HashSet<>();
        while (n != 1 && !add.contains(n)) {
            add.add(n);
            String s = String.valueOf(n);
            int Sum = 0;
            for (int i = 0; i < s.length(); i++){
                int  intNum = s.charAt(i) - '0';
                Sum += Math.pow(intNum, 2);
            }
            n = Sum;
        }
        return n == 1;
    }

    //860. 柠檬水找零
    public boolean lemonadeChange(int[] bills) {
        int n5 = 0;
        int n10 = 0;
        if (bills.length > 10000) return false;
        for (int i = 0; i < bills.length; i++) {
            int current = bills[i];
            if (current == 5) {
                n5++;
            } else if (current == 10) {
                if (n5 == 0) {
                    return false;
                } else {
                    n5--;
                    n10++;
                }
            } else if (current == 20) {
                if (n5 == 0) {
                    return false;
                } else if (n10 == 0) {
                    if (n5 < 3) {
                        return false;
                    } else {
                        n5 -= 3;
                    }
                } else {
                    n5--;
                    n10--;
                }
            }
        }
        return true;
    }

    public int compareVersion(String version1, String version2) {
        String v11 = "";
        String v22 = "";
        int index1 = 0;
        int index2 = 0;
        if (!version1.contains(".")) {
            for (int i = 0; i < version1.length(); i++) {
                if (version1.charAt(i) != '0') {
                    index1 = i;
                    break;
                }
            }
        }
        if (!version2.contains(".")) {
            for (int i = 0; i < version2.length(); i++) {
                if (version2.charAt(i) != '0') {
                    index2 = i;
                    break;
                }
            }
        }
        v11 = version1.substring(index1, version1.length());
        v22 = version2.substring(index2, version2.length());
        String v1 = v11.replaceAll("\\.", "");
        String v2 = v22.replaceAll("\\.", "");
        int len1 = v1.length();
        int len2 = v2.length();
        int l = Math.abs(len1 - len2);
        for (int i = 0; i < l; i++) {
            if (len1 > len2) {
                v2 += "0";
            } else {
                v1 += "0";
            }
        }
        for (int i = 0; i < v1.length(); i++) {
            char c1 = v1.charAt(i);
            char c2 = v2.charAt(i);
            if (c1 == c2) {
                continue;
            } else if (c1 > c2) {
                return 1;
            } else if (c1 < c2) {
                return -1;
            }
        }
        return 0;
    }


    public int compareVersion1(String version1, String version2) {
        String v11 = "";
        String v22 = "";
        int index1 = 0;
        int index2 = 0;
        if (!version1.contains(".")) {
            for (int i = 0; i < version1.length(); i++) {
                if (version1.charAt(i) != '0') {
                    index1 = i;
                    break;
                }
            }
        }
        if (!version2.contains(".")) {
            for (int i = 0; i < version2.length(); i++) {
                if (version2.charAt(i) != '0') {
                    index2 = i;
                    break;
                }
            }
        }
        v11 = version1.substring(index1, version1.length());
        v22 = version2.substring(index2, version2.length());
        String[] c1 = v11.split("\\.");
        String[] c2 = v22.split("\\.");
        int len1 = c1.length;
        int len2 = c2.length;
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        int a = Math.max(len1, len2);
        for (int i = 0; i < a; i++) {
            if (i < len1) {
                l1.add(c1[i]);
            } else {
                l1.add("0");
            }
            if (i < len2) {
                l2.add(c2[i]);
            } else {
                l2.add("0");
            }
        }
        for (int i = 0; i < a; i++) {
            if (l1.get(i) == l2.get(i)) continue;
            else {
                int a1;
                if (l1.get(i).equals("0")) {
                    a1 = 0;
                } else if (l1.get(i).startsWith("0")) {
                    int tep1 = 0;
                    for (int j = 0; j < l1.get(i).length(); j++) {
                        if (l1.get(i).charAt(i) != '0') {
                            tep1 = i;
                            break;
                        }
                    }
                    a1 = Integer.parseInt(l1.get(i).substring(tep1, l1.get(i).length()));
                } else {
                    a1 = Integer.parseInt(l1.get(i));
                }

                int a2;
                if (l2.get(i).equals("0")) {
                    a2 = 0;
                } else if (l2.get(i).startsWith("0")) {
                    int tep2 = 0;
                    for (int j = 0; j < l2.get(i).length(); j++) {
                        if (l2.get(i).charAt(j) != '0') {
                            tep2 = j;
                            break;
                        }
                    }
                    a2 = Integer.parseInt(l2.get(i).substring(tep2, l2.get(i).length()));
                } else {
                    a2 = Integer.parseInt(l2.get(i));
                }
                if (a1 == a2) continue;
                else if (a1 > a2) return 1;
                else return -1;
            }
        }
        return 0;
    }
}
