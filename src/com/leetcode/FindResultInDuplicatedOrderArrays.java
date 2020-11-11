package com.leetcode;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/8/25
 */
public class FindResultInDuplicatedOrderArrays {
    public static void main(String[] args) {
        int result = getResult(5, 4, new int[]{1, 2, 4, 4, 5});
        System.out.println(result);
    }
    public static int getResult(int len,int result,int[] arrays){
        int res=0;
        int p=0;
        int q=arrays.length-1;
        while(p<=q){
            int index=(p+q)/2;
            res=index;
            if(arrays[index]==result){
                while(arrays[--index]==result){
                    res=index;
                }
                return res+1;
            }else if(arrays[index]>result){
                q=index--;
            }else{
                p=index++;
            }
        }
        return res;
    }
}
