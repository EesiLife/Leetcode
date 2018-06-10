package com.eesilife.lib;

import java.util.Stack;

public class L20_ValidParentheses {
    public boolean isValid(String s) {
        if ("".equals(s))return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                if (stack.size()>0 &&stack.peek() == '('){
                    stack.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '[') {
                stack.push('[');
            } else if (s.charAt(i) == ']') {
                if (stack.size()>0 &&stack.peek() == '['){
                    stack.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '{') {
                stack.push('{');
            } else if (s.charAt(i) == '}') {
                if (stack.size()>0 &&stack.peek() == '{'){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return (stack.size() == 0);
    }

    public static void main(String[] args){
        L20_ValidParentheses c = new L20_ValidParentheses();
        String s = "([)]";
//        String s = "{[]}";
//        String s = "()[]{}";
        System.out.println(c.isValid(s));
    }
}
