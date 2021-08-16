package com.niuke.array;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/8/16
 **/
public class RemoveDuplicateNumInSortedArrays {
    public static void main(String[] args) {
        int[] nums=new int[]{0,0,0,1,1,1,2,2,2,3,3,3,4,4,4,5};
        int result = getResultEnhance(nums);
        System.out.println(result);

    }

    public static int getResultEnhance(int[] nums){
        int curVal=nums[0];
        int curCount=1;
        int totalCount=1;
        /**
         * 从1开始遍历元素
         */
        int index=1;
        while(index<nums.length){
            if(nums[index]==curVal&&curCount<=1){
                /**
                 * 相同元素只需要访问一次
                 */
               totalCount++;
               nums[totalCount-1]=nums[index];
               index++;
               curCount++;

            }else if(curVal==nums[index]){
                /**
                 * 相同元素 且curCount已经是2 表示已经访问过两次了 后续元素不需要统计 直接跳过
                 */
                index++;
                continue;
            }else if(curVal!=nums[index]){
                curVal=nums[index];
                curCount=1;
                totalCount++;
                /**
                 *前移替换重复的元素
                 */
                nums[totalCount-1]=nums[index];
                index++;
            }
        }

        return totalCount;
    }
}
