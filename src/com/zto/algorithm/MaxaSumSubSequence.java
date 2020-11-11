package com.zto.algorithm;

/**
 * Created by xujun on 2018-08-02.
 */
public class MaxaSumSubSequence {
   public  int MaxSubSum3(int[] vec, int left, int right)
    {
        if (right == left) {
            if (vec[left] > 0) {
                return vec[left];
            } else {
                return 0;
            }
        }
        int center = (right + left) / 2;
        int left_max_sum = MaxSubSum3(vec, left, center);
        System.out.println("left:"+left+" center:"+center);
        System.out.println("left_max_sum:"+left_max_sum);
        int right_max_sum = MaxSubSum3(vec, center + 1, right);
        System.out.print("center:"+center+" right:"+right);
        System.out.print("right_max_sum:"+right_max_sum);

        int left_sum = 0;
        int left_max = 0;
        for (int i = center; i >= left; --i) {
            left_sum += vec[i];
            if (left_sum > left_max) {
                left_max = left_sum;
            }
        }
        System.out.println("left_max:"+left_max);
        int right_sum = 0;
        int right_max = 0;
        for (int i = center + 1; i <= right; ++i) {
            right_sum += vec[i];
            if (right_sum > right_max) {
                right_max = right_sum;
            }
        }
        System.out.println("right_max:"+right_max);
        System.out.println("------------------");
        return Math.max(Math.max(left_max_sum, right_max_sum), (right_max + left_max));
    }
    public static  void main(String[] args){
        int a[]={-10, 5, 0, 8, -1, 10 ,-10, 100, -1};
        MaxaSumSubSequence sequence=new MaxaSumSubSequence();
        int res=sequence.MaxSubSum3(a,0,8);
        System.out.println(res);
    }
}
