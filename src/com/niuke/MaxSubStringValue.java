package com.niuke;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/11/8
 */
public class MaxSubStringValue {
    public static void main(String[] args) {
         int[] ints=new int[]{1, -2, 3, 5, -2, 6, -1};
        int result = getResult(ints);
    }
    public static int getResult(int[] ints){
        int result=0;
        int max=0;
        int cur=0;
        for(int i=0;i<ints.length;i++){
            if(cur<0){
                cur=0;
            }
            cur+=ints[i];
            if(cur>max){
                max=cur;
            }
        }
        String str=new String("123");

        result=max;
        return result;
    }
}
