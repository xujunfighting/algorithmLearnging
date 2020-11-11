package com.zto.newYear;

/**
 * Created by xujun on 2019-01-04.
 */
public class BinarySearch {
    public static void main(String[] args){
        int[] a=new int[]{1,2,2,3,3,3,4,5,6,7,7,8};
        int index=binarySearch(a,3);
        System.out.print(index);
    }
    public static int binarySearch(int[] nums , int target){

        int left = 0;
        int right = nums.length - 1;

        while(left <= right ) {
            int mid = (left + (right - left) / 2);
            if( target == nums[mid] ) {
                while(mid >= 0) {
                    if(nums[mid] != target) {
                        break;
                    }
                    mid--;
                }
                if(mid <= -1 ) {
                    return 0;
                }
                return mid + 1;//多减了一次，返回的时候需要再加1
            }else if( target < nums[mid] ) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return -1;
    }

}
