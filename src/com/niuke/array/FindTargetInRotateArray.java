package com.niuke.array;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/13
 **/
public class FindTargetInRotateArray {
    public static void main(String[] args) {
        //
        //
        //
        //[]
         int[] nums=new int[]{3,1,2};
        int result = getResult(nums, 2);
        System.out.println(result);

    }
    public static int getResult(int[] nums,int target){

        int start=nums[0];
        int end=nums[nums.length-1];
        if(start==target){
            return 0;
        }else if(end==target){
            return nums.length-1;
        }
        start=0;
        end=nums.length-1;
        while (start<end){
            if(target==nums[start]){
                return start;
            }else if(target==nums[end]){
                return end;
            }
            if(nums[start]<nums[end]){
                /**
                 * 没有出现旋转的情况
                 */
                 if(target<nums[start]||target>nums[end]){
                     /**
                      * 结果集不存在
                      */
                     return -1;
                 }
                 int middle=(start+end)/2;
                 if(nums[middle]==target){
                     return middle;
                 }else if(nums[middle]>target){
                     end=middle-1;
                 }else if(nums[middle]<target){
                     start=middle+1;
                 }

            }else{
                  if(target>nums[end]&&target<nums[start]){
                      return -1;
                  }
                  int middle=(start+end)/2;
                  if(nums[middle]==target){
                      return middle;
                  }else if(nums[start]<target){
                      /**
                       * 结果只会出现在前半段
                       */
                        if(nums[middle]>nums[start]){
                            /**
                             * 正序列
                             */
                            if(nums[middle]<target){
                                start=middle+1;
                            }else if(nums[middle]>target){
                                end=middle-1;
                            }

                        }else if(nums[middle]<nums[start]){
                            /**
                             * 非正序列
                             */
                            end=middle-1;

                        }else{
                            break;
                        }
                  }else if(nums[end]>target){
                      /**
                       *结果只会出现在后半段
                       */
                      if(nums[middle]<nums[end]){
                          /**
                           * 正序列
                           */
                          if(nums[middle]<target){
                              start=middle+1;
                          }else if(nums[middle]>target){
                              end=middle-1;
                          }
                      }else if(nums[middle]>nums[end]){
                          /**
                           * 非正序列
                           */
                           start=middle+1;
                      }else{
                          break;
                      }
                  }
            }
        }
        return -1;
    }
}
