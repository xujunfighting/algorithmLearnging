package com.zto.algorithm;

/**
 * Created by xujun on 2018-08-02.
 */
public class MaxSumSubSequence2 {
    int MaxSubSum4( int[] vec)
    {
        int sum = 0;
        int max = 0;

        for (int i = 0; i < vec.length; ++i) {
            sum += vec[i];
            if (sum > max) {
                max = sum;
            } else if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
    public  static  void main(String[] args){
        int a[]={-10, 5, 0, 8, -1, 10 ,-10, 100, -1};
        MaxSumSubSequence2 sequence2=new MaxSumSubSequence2();
        int result=sequence2.MaxSubSum4(a);
        System.out.print(result);

    }
}
