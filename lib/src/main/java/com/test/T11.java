package com.test;

import java.util.*;

public class T11 {

    class RandomizedSet {
        HashMap<Integer, Integer> map;

        public RandomizedSet() {
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            if (!map.containsKey(val)) {
                map.put(val, 1);
                return true;
            }
            return false;
        }

        public boolean remove(int val) {
            if (map.containsKey(val)) {
                map.remove(val);
                return true;
            }
            return false;
        }

        public int getRandom() {
            Object[] arr = (Object[]) (map.keySet().toArray());
            int len = arr.length;
            return (int) arr[new Random().nextInt(len)];
        }
    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n)  {
            int sumGas = 0, sumCost = 0, cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) %n;
                sumGas += gas[j];
                sumCost += cost[j];
                if (sumCost > sumGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }
        return spare < 0 ? -1 : (minIndex + 1) % len;
    }

    public static int romanToInt(String s) {
        char[] arr = s.toCharArray();
        char pre = ' ';
        int sum = 0;
        for (char c : arr) {
            switch (c) {
                case 'M':
                    sum += 1000;
                    if (pre == 'C') sum -= 200;
                    break;
                case 'D':
                    sum += 500;
                    if (pre == 'C') sum -= 200;
                    break;
                case 'C':
                    sum += 100;
                    if (pre == 'X') sum -= 20;
                    break;
                case 'L':
                    sum += 50;
                    if (pre == 'X') sum -= 20;
                    break;
                case 'X':
                    sum += 10;
                    if (pre == 'I') sum -= 2;
                    break;
                case 'V':
                    sum += 5;
                    if (pre == 'I') sum -= 2;
                    break;
                case 'I':
                    sum += 1;
                    break;
            }
            pre = c;
        }
        return sum;
    }

//    public static void main(String[] args) {
//        romanToInt("DCXXI");
//    }

    public static String intToRoman1(int num) {
        String ns = new StringBuilder().append(num).toString();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < ns.length(); j ++) {
            int b = ns.charAt(j) - '0';
            int carry = (int)Math.pow(10, ns.length() - 1 - j);
            switch (carry) {
                case 1: {
                    if (b == 9) {
                        sb.append("IX");
                    } else if (b == 4) {
                        sb.append("IV");
                    } else {
                        if (b >= 5) {
                            sb.append("V");
                        }
                        for (int i = 0; i < (b >=5? b - 5 : b ) ; i++) {
                            sb.append("I");
                        }
                    }
                }   break;
                case 10:{
                    if (b == 9) {
                        sb.append("XC");
                    } else if (b == 4) {
                        sb.append("XL");
                    } else {
                        if (b >= 5) {
                            sb.append("L");
                        }
                        for (int i = 0; i < (b >=5? b - 5 : b ) ; i++) {
                            sb.append("X");
                        }
                    }
                } break;
                case 100: {
                    if (b == 9) {
                        sb.append("CM");
                    } else if (b == 4) {
                        sb.append("CD");
                    } else {
                        if (b >= 5) {
                            sb.append("D");
                        }
                        for (int i = 0; i < (b >=5? b - 5 : b ) ; i++) {
                            sb.append("C");
                        }
                    }
                }
                    break;
                case 1000: {
                    for (int i = 0; i < b; i ++ ) {
                        sb.append("M");
                    }
                }
                    break;
            }
        }

        return sb.toString();
    }

    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (num > value) {
                sb.append(symbol);
                num -= value;
            }
            if (num == 0) break;
        }
        return sb.toString();
    }

    public static int lengthOfLastWord(String s) {
        int n = s.length();
        int cnt = 0;
        for (int i = n - 1; i >=0; i--) {
            if (s.charAt(i) != ' ') {
                cnt++;
            } else if (cnt > 0) {
                break;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }

}
