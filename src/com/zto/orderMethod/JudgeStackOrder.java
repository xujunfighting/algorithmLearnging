package com.zto.orderMethod;

import java.util.Stack;

/**
 * Author xujun
 * Create date 2019-08-09.
 * desc:
 */
public class JudgeStackOrder {
    public static void main(String[] args) {
        int[] a=new int[]{1,2,3,4,5,6,7,8,9};
        int[] b=new int[]{1,2,3,5,4,9,8,7,6};
        Stack<Integer> stack=new Stack<>();
        boolean res=method(a,b,0,a.length,0,b.length,stack);
        System.out.println(res);
    }
    public static boolean method(int[] a,int[] b,int aStart,int aEnd,int bStart,int bEnd,Stack<Integer> stack){

        while(aStart<aEnd) {
            int index = b[bStart];
            int i = aStart;
            if (a[aStart] != b[bStart]&&stack.size()==0||stack.size()!=0&&stack.peek()!=b[bStart]) {
                while (i < aEnd && a[i] != index) {
                    stack.add(a[i]);
                    i++;
                }
                aStart = (++i);
                bStart++;
            }else if(stack.size()!=0&&stack.peek()==b[bStart]){
                stack.pop();
                bStart++;
            }else if(a[aStart] == b[bStart]){
                aStart++;
                bStart++;
            }
        }
        if(stack.size()!=0&&bStart<bEnd){
            while(bStart<bEnd&&b[bStart]==stack.peek()){
                bStart++;
                stack.pop();
            }
        }
        if(stack.size()==0){
            return true;
        }else{

            return false;
        }

    }
}
