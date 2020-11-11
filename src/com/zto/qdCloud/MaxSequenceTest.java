package com.zto.qdCloud;

/**
 * Author xujun
 * Create date 2019-04-26.
 * desc:
 */
public class MaxSequenceTest {
    public static void main(String[] args) {
         int[] a=new int[]{0,1,2,-1,4,5,-6,7,8,-9};
         int res=getMaxSequenceSum(a);
         System.out.println(res);
    }
    public static int getMaxSequenceSum(int[] a){
        int max=0;
        int current=0;
        for(int i=0;i<a.length;i++){
            current+=a[i];
            if(current<=0){
                current=0;
            }
            if(max<current){
                max=current;
            }
        }
        return max;
    }
}
