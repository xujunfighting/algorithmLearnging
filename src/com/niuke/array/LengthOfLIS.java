package com.niuke.array;

/**
 * @Author xujun
 * @Description 题号300
 * @Date 2023/10/2 14:34
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        int[] ints=new int[]{3,5,6,2,5,4,19,5,6,7,12};
        int result = getResult4(ints);
        System.out.println(result);
    }

    /**
     * 二维转化方程  对角线表示当前一个元素 数值填充为1
     * 行号-1 计算上一层当前元素和上一个元素构成的最长子序列  以此类推  分别计算从第一个元素开始和当前元素构成的最长子序列
     * 拿上一行的结果值和当前行作比较
     * 问题点  上一行的计算结果中已经包含了 下一行的结算结果  （上一行的元素个数多余下一行的元素）出现重复计算
     * @param nums
     * @return
     */
    public static int getResult(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int maxLen = 0;
        int[][] indexs = new int[nums.length][nums.length];
        for(int i=0;i<indexs.length;i++){
            for(int j=i;j>=0;j--){
               if(i==j){
                   //当前一个元素构成的最大长度是1
                   indexs[j][i]=1;
                   continue;
               }
               int xMax=0;
               int totalMax=0;
               for(int k=j;k<=i-1;k++){
                   if(nums[k]<nums[i]){
                       xMax=Math.max(indexs[j][k]+1,xMax);
                   }
                   if(totalMax<xMax){
                       totalMax=xMax;
                   }
               }
               indexs[j][i]=Math.max(totalMax,indexs[j+1][i]);
               if(indexs[j][i]>maxLen){
                   maxLen=indexs[j][i];
               }
            }
        }
        return maxLen;
    }

    /**
     * 错误原因 9,10,2,5 这四个元素计算出规划数组的结果是 1 2 2 3 在计算5时判断到2小于5 直接拿2所在位置的结果直接+1
     * 从而计算出3 而实际到5位置最大的数组长度只能是2也就是2和5组成的最大递增前缀
     * @param nums
     * @return
     */
    public static int  getResult2(int[] nums){
        if(nums.length==1){
            return 1;
        }
        int maxLen=0;
        int[] indexs=new int[nums.length];
        indexs[0]=1;
        for(int i=1;i<nums.length;i++){
            indexs[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    indexs[i]=Math.max(indexs[i],indexs[j]+1);
                }else{
                    //不能计算前面累加元素的最大长度
                    indexs[i]=Math.max(indexs[i],indexs[j]);
                }
                if(indexs[i]>maxLen){
                    maxLen=indexs[i];
                }
            }
        }
        return maxLen;
    }



    public static int  getResult3(int[] nums){
        if(nums.length==1){
            return 1;
        }
        int maxLen=0;
        int[] indexs=new int[nums.length];
        indexs[0]=1;
        for(int i=1;i<nums.length;i++){
            //设置当前位置元素值为当前一个元素构成的最大递增长度及为1
            indexs[i]=1;
            for(int j=0;j<i;j++){
                //判断前面计算好的位置的元素是否小于当前所在位置i的元素值 ，如果小于直接计算j规划数组中元素值+1，不断选取最大值进行替换
                //如果不大于j位置所在元素 则最大值当前一个元素
                if(nums[i]>nums[j]){
                    indexs[i]=Math.max(indexs[i],indexs[j]+1);
                }
                if(indexs[i]>maxLen){
                    maxLen=indexs[i];
                }
            }
        }
        return maxLen;
    }

    /**
     * 如果我们要使上升子序列尽可能的长，则我们需要让序列上升得尽可能慢，因此我们希望每次在上升子序列最后加上的那个数尽可能的小
     * 维护一个递增数组 在数组中查找第一个大于当前元素的角标，并将当前角标位的数值填充成当前元素  尽量使递增数组中的元素差值尽可能小
     * @param nums
     * @return
     */
    public  static int getResult4(int[] nums){
        if(nums.length==1){
            return 1;
        }
        int len=1;
        int[] indexs=new int[nums.length+1];
        indexs[1]=nums[0];
        for(int i=1;i<nums.length;i++){
            //判断当前元素是否大于递增数组末尾元素 如果是则直接累加长度，并将数组的最后最后一位填充成当前元素
            if(indexs[len]<nums[i]){
                len++;
                indexs[len]=nums[i];
            }else if(indexs[1]>=nums[i]){
                //如果数组的第一个元素大于当前元素 则替换第一个的元素 保证递增数组每一位尽可能的小
                indexs[1]=nums[i];
            }else{
                int start=1;
                int end=len;
                while(start<=end){
                    int mid=(start+end)/2;
                    //mid位的元素小于当前元素 mid+1位的元素大于当前元素  为了保证递增数组尽可能的小 将mid+1位置的元素替换成当前元素
                    if(indexs[mid]<nums[i]&&indexs[mid+1]>=nums[i]){
                        indexs[mid+1]=nums[i];
                        break;
                    }else if(indexs[mid]<nums[i]){
                           start=mid+1;
                    }else if(indexs[mid]>=nums[i]){
                            end=mid-1;
                    }
                    //保证二分查找不出现死循环 需要将所有的情况都遍历，并且每次都要修改start或end的角标位
                }
            }
        }
        return len;
    }


}
