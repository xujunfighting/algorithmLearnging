package com.niuke;

import java.util.Stack;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/11/24
 */
public class IsValidMatchString {
    public static void main(String[] args) {
        boolean valid = isValid("())");
        System.out.println(valid);

    }
    public static boolean isValid(String strs){
        boolean result=true;
        Stack<Character> stack1=new Stack<>();
        if(strs==null||strs.length()==0||strs.trim().equals("")){
            return result;
        }

        char[] chars = strs.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='['||chars[i]=='{'||chars[i]=='('){
                stack1.add(chars[i]);
            }else if(!stack1.isEmpty()&&(chars[i]=='}'||chars[i]==']'||chars[i]==')')){
                if(chars[i]=='}'&&stack1.peek()=='{'){
                    stack1.pop();
                }else if(chars[i]==']'&&stack1.peek()=='['){
                    stack1.pop();
                }else if(chars[i]==')'&&stack1.peek()=='('){
                    stack1.pop();
                }
            }else if(stack1.isEmpty()){
                return false;
            }
        }
        if(stack1.size()==0){
            result=true;
        }else{
            result=false;
        }
        return result;
    }
}
