package com.leetcode;

import java.util.Stack;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/8/14
 */
class StringMatchMethod {
    public static boolean isValid(String s) {
        Stack<Character> stringStack=new Stack<>();
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            char c=chars[i];
            if(c=='('||c=='['||c=='{'){
                stringStack.add(c);
            }
            if(c=='}'){
                char st=stringStack.pop();
                if(st!='{') return false;
            }
            if(c==']'){
                char st=stringStack.pop();
                if(st!='[') return false;
            }
            if(c==')'){
                char st=stringStack.pop();
                if(st!='(') return false;
            }
        }

        if(stringStack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        boolean valid = isValid("{[]}");
        System.out.println(valid);

    }
}
