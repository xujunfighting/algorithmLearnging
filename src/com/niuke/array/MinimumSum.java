package com.niuke.array;

/**
 * @Author xujun
 * @Description 计算 最小的山形三元组
 * @Date 2023/10/28 10:57
 */
public class MinimumSum {
    public static void main(String[] args) {
       int[] nums=new int[]{5,4,8,7,10,2};
        int result = getResult2(nums);
        System.out.println(result);

    }

    /**
     * 从第二个元素i开始到倒数第二个元素 和之前的j元素(0=<j<i)小于当前元素i  以及和之后的元素k(i<k<nums.length)小于当前元素
     * 比较交换求解最小值
     * @param nums
     * @return
     */
    public static int getResult(int[] nums){
        int res=-1;
        for(int i=1;i<nums.length-1;i++){
            for(int j=0;j<i;j++){
                for(int k=nums.length-1;k>i;k--){
                    if(nums[j]<nums[i]&&nums[k]<nums[i]&&(res==-1||nums[j]+nums[k]+nums[i]<res)){
                        res=nums[i]+nums[j]+nums[k];
                    }
                }
            }
        }
        return res;
    }

    /**
     * 根据动态规划的思想 提前计算好正向从0到指定位置index的当前数组最小值 同理计算反向从nums.length到index的最小值
     * 同时判断正向和反向最小值是否小于当前i元素 满足的同时进行比较交换计算最小值
     * @param nums
     * @return
     */
    public static int getResult2(int[] nums){
        int res=-1;
        int[] preMin=new int[nums.length];
        int[] backMin=new int[nums.length];
        preMin[0]=nums[0];
        int curPreMin=nums[0];
        backMin[nums.length-1]=nums[nums.length-1];
        int curBackMin=nums[nums.length-1];
        int len=nums.length-1;
        for(int i=1;i<=nums.length-1;i++){
            if(nums[i]<curPreMin){
                preMin[i]=nums[i];
                curPreMin=nums[i];
            }else{
                preMin[i]=curPreMin;
            }

            if(nums[len-i]<curBackMin){
                backMin[len-i]=nums[len-i];
                curBackMin=nums[len-i];
            }else{
                backMin[len-i]=curBackMin;
            }
        }
        System.out.println(preMin);
        System.out.println(backMin);
        for(int i=1;i<nums.length-1;i++){
            if((preMin[i-1]<nums[i]&&nums[i]>backMin[i+1])&&(res==-1||res>preMin[i-1]+nums[i]+backMin[i+1])){
                System.out.println("preMin:"+preMin[i-1]+"middle:"+nums[i]+"back:"+backMin[i+1]);
                res=preMin[i-1]+nums[i]+backMin[i+1];
            }
        }

        return res;
    }
}
