package com.study.learning.dynamicProgramming;

/**
 * Author xujun
 * Create date 2020-01-02.
 * desc:
 */
public class MaxSubSequence {
    public static void main(String[] args) {
        String seq="ABC";
        String subSeq="BC";
        int res = method(seq.toCharArray(),subSeq.toCharArray());
        System.out.println(res);
    }
    public static int  method(char[] seq,char[] subSeq){
        int[][] index =  new int[seq.length+1][subSeq.length+1];
        for(int i=0;i<=seq.length;i++){
         index[i][0]=0;
        }
        for(int j=0;j<=subSeq.length;j++){
            index[0][j]=0;
        }
        for(int i=1;i<=seq.length;i++){
            for(int j=1;j<=subSeq.length;j++){
                if(seq[i-1]==subSeq[j-1]){
                    index[i][j]=index[i-1][j-1]+1;
                }else{
                    index[i][j]=Math.max(index[i-1][j],index[i][j-1]);
                }
            }
        }
        return index[seq.length][subSeq.length];
    }
}
