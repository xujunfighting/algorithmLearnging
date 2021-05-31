package com.niuke;

import java.util.Stack;
/**
 * @Description
 * 查找当前元素后面第一个大于当前元素的值
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/3/3
 */
public class FindFirstBiggerData {
    public static void main(String[] args) {
        int[] arrays=new int[]{4,3,4,2,1,5,6,7,3,8};
        int[] res=getResult(arrays);
        System.out.println(res);
    }
    public static int[] getResult(int[] args){
        int[] ints=new int[args.length];
        /**
         * 最后一个元素不存在后续元素直接填写-1
         */
        for(int i=0;i<ints.length;i++){
            ints[i]=-1;
        }
        Stack<Integer> stack=new Stack<>();
        /**
         * 添加第一个元素的角标
         */
        stack.add(0);
        /**
         * 当前遍历的元素位置
         */
        int index=1;

        while(index<args.length){
            /**
             * 查找的后继元素大于当前需要遍历的元素值
             * 如果存在一直出栈直到条件匹配失败或者栈元素为空
             */
            while(!stack.isEmpty()&& args[index]>args[stack.peek()]){
                ints[stack.pop()]=args[index];
            }
            /**
             * 栈顶元素不小于当前遍历元素直接压栈元素角标
             * 当前遍历元素角标直接压栈
             */
            stack.add(index++);
        }
        return ints;
    }
}
