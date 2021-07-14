package com.niuke.array;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/14
 **/
public class FindTargetStartAndEndIndexInSortedArray {
    public static void main(String[] args) {
        int[] ints=new int[]{0,1,2,3,4,4,4};
        int[] result = getResult(ints, 2);
        System.out.println(result);

    }
    public static int[] getResult(int[] nums,int target){
        int[] result=new int[]{-1,-1};
        if(nums==null||nums.length==0){
            return result;
        }
        int start=0;
        int end=nums.length-1;
        int middle=0;
        if(nums[start]==target){
            /**
             * 开始节点为目标值 遍历后面的元素是否满足
             */
            result[0]=start;
            while(start<=nums.length-1&&nums[start]==target){
                start++;
            }
            result[1]=start-1;
            return result;
        }if(nums[end]==target){
            /**
             * 末尾节点为目标值 遍历前面的元素是否满足
             */
            result[1]=end;
            while(end>=0&&nums[end]==target){
                end--;
            }
            result[0]=end+1;
            return result;
        }
        while(start<end){
            if(nums[start]==target){
                result[0]=start;
                while(start<=nums.length-1&&nums[start]==target){
                    start++;
                }
                result[1]=start-1;
                return result;
            }if(nums[end]==target){
                result[1]=end;
                while(end>=0&&nums[end]==target){
                    end--;
                }
                result[0]=end+1;
                return result;
            }
              middle=(start+end)/2;
             if(nums[middle]==target){
                 /**
                  * 查找到结果 遍历前面和后面的元素是否满足条件
                  */
                 int startIndex=middle;
                 int endIndex=middle;
                 while(startIndex>=0&&nums[startIndex]==target){
                     startIndex--;
                 }
                 while(endIndex<=nums.length-1&&nums[endIndex]==target){
                     endIndex++;
                 }
                 result[0]=startIndex+1;
                 result[1]=endIndex-1;
                 return result;
             }else if(nums[middle]<target){
                 start=middle+1;
             }else if(nums[middle]>target){
                 end=middle-1;
             }
        }
        return result;
    }
}
