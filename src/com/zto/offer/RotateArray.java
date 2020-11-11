package com.zto.offer;

/**
 * Created by xujun on 2018-11-28.
 */
public class RotateArray {
    public static void main(String[] args){
        int[] a=new int[]{1,1,2,2,2,0,1};
        int result=method(a);
        System.out.print(result);
    }
    public static int  method(int[] rotateArray){
        int length = rotateArray.length;
        if (length == 0)
            return 0;
        int left = 0, right = length-1;
        int mid;
        int result=0;
        while(rotateArray[left] >= rotateArray[right])
        {
            if(left == right - 1) {
                result=rotateArray[right];
                break;
            }

            mid = (left + right)/2;

            if(rotateArray[left] == rotateArray[mid] &&
                    rotateArray[mid] == rotateArray[right])
            {
                int min_num = rotateArray[left];
                for(int i=left; i < right; i++)
                    min_num = rotateArray[i]<min_num? rotateArray[i]:min_num;
                return min_num;
            }
            if(rotateArray[left] <= rotateArray[mid])
                left = mid;
            else
                right = mid;

        }

      return  result;
    }
}
