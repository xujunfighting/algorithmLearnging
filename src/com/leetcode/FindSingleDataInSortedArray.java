package com.leetcode;

/**
 * @author xujun
 * @date 2022-02-14
 **/
public class FindSingleDataInSortedArray {
    private static  int end1=0;
    private static int start1=0;
    public static void main(String[] args) {
       int[] arrays=new int[]{1,1,2,3,3,4,4,8,8};
        Integer result = getResult(arrays, 0, arrays.length - 1);
        System.out.println(result);
    }

    public static Integer  getResult(int[] arrays,int start,int end){
        if(start==end){
            return null;
        }
        if(start==0&&arrays[start]!=arrays[start+1]){
            return arrays[start];
        }
        if(end==arrays.length-1&&arrays[end]!=arrays[end-1]){
            return arrays[end];
        }
        if(start>=1&&start+1<=arrays.length&&arrays[start]!=arrays[start-1]&&arrays[start]!=arrays[start+1]){
            return arrays[start];
        }
        if(end>start&&end+1<arrays.length&&arrays[end]!=arrays[end-1]&&arrays[end]!=arrays[end+1]){
            return arrays[end];
        }
        int middle=(start+end)/2;
        if(arrays[middle]!=arrays[middle-1]&&arrays[middle]!=arrays[middle+1]){
            return arrays[middle];
        }

        if(arrays[middle]==arrays[middle+1]){
            end1=middle+2;
            start1=middle-1;
        }else{
            end1=middle+1;
            start1=middle-2;
        }
        if((start1-start+1)%2==1) {
            Integer res=getResult(arrays, start, start1);
            if(res!=null){
                return res;
            }
        }
        if((end-end1+1)%2==1) {
            Integer res=getResult(arrays, end1, end);
            if(res!=null){
                return res;
            }
        }
        return null;
    }

}
