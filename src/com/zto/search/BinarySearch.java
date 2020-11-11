package com.zto.search;

/**
 * Created by xujun on 2019-01-02.
 */
public class BinarySearch {
    public static void main(String[] args){
      int[] result=new int[]{1,2,3,4,5,6,7,8,9,10};
      int search=12;
      int index=method2(result,0,result.length-1,search);
      System.out.print(index);
    }
    public static int method1(int[] seq,int search){
        int index=-1;
        int start=0;
        int end=seq.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(seq[mid]==search){
                return mid;
            }
            if(seq[mid]>search){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return index;
    }
    public static int method2(int[] seq,int start,int end,int search){
        if (start<=end) {
            int mid = (start + end) / 2;
            if (seq[mid] == search) {
                return mid;
            }
            if (seq[mid] > search) {
              return  method2(seq, start, mid-1,search);
            }
            if (seq[mid] < search) {
              return  method2(seq, mid +1, end, search);
            }
        }
        return -1;
    }
}
