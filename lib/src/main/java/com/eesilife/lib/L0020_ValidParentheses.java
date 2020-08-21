package com.eesilife.lib;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class L0020_ValidParentheses {
    public boolean isValid(String s) {
        if ("".equals(s)) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                if (stack.size() > 0 && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '[') {
                stack.push('[');
            } else if (s.charAt(i) == ']') {
                if (stack.size() > 0 && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '{') {
                stack.push('{');
            } else if (s.charAt(i) == '}') {
                if (stack.size() > 0 && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return (stack.size() == 0);
    }

    public static void main(String[] args) {
        L0020_ValidParentheses c = new L0020_ValidParentheses();
        String s = "]";
//        String s = "{[]}";
//        String s = "()[]{}";
        System.out.println(c.isValid(s));
        System.out.println(c.isValid2(s));
    }

    private static HashMap<Character, Character> sMap = new HashMap<Character, Character>() {
        {
            put('(',')');
            put('[',']');
            put('{','}');
            put('1','1');
        }
    };
    public boolean isValid2(String s) {
        LinkedList<Character> list = new LinkedList<Character>(){
            {
                add('1');
            }
        };
        for (int i = 0; i < s.length(); i++) {
            if (sMap.containsKey(s.charAt(i))) {
                list.add(s.charAt(i));
            }
//            else {
//                Character pop = list.removeLast();
//                System.out.println(pop);
//                Character tmp = sMap.get(pop);
//                System.out.println(tmp);
//                Character current = s.charAt(i);
//                System.out.println(current);
//                System.out.println("\n");
//                if (tmp != s.charAt(i)) {
//                    return false;
//                }
//            }
            else if (s.charAt(i) != sMap.get(list.peekLast())){
                return false;
            }
        }
        return list.size() == 1;
    }
}
