package com.baidu.sort;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/9/28
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums=new int[]{3,2,4,1,6,9,7,8,19,11};
        method(nums);
        print(nums);
    }
    public static void method(int[] nums){
        int cur=0;
        int index=0;
         for(int i=1;i<nums.length;i++){
             cur=nums[i];
             if(nums[i-1]>cur){
                 for(int j=i-1;j>=0;j--){
                     if(nums[j]>cur){
                         nums[j+1]=nums[j];
                         index=j;
                     }else{
                         break;
                     }
                 }
                 nums[index]=cur;
                 print(nums);
             }
         }
    }
    public static void print(int[] nums){
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
}
