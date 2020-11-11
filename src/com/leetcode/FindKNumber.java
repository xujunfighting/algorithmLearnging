package com.leetcode;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/8/28
 */
public class FindKNumber {
    public static void main(String[] args) {
      int[] res=new int[]{4,3,1,6,2,8};
    }
    public int getResult(int[] res,int n,int k){
        int result=0;

        return result;
    }
    public void method(int[] res,int start,int end){
        int index=res[start];
        int p=start;
        int q=end;
        while(p<q){
            while(p<q&&res[q]>index){//查找第一个小于index的元素
                q--;
            }
            res[p]=res[q];
            while(p<q&&res[q]<index){//查找第一个大于index的元素
                p++;
            }
            res[q]=res[p];
        }

    }
}
