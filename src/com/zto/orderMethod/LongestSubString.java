package com.zto.orderMethod;

/**
 * Author xujun
 * Create date 2019-07-31.
 * desc:
 */
public class LongestSubString {
    public static void main(String[] args) {
      String strs="abcdef";
      String subStr="abcd";
      int res=method(strs.toCharArray(),subStr.toCharArray());
      System.out.println(res);
    }
    public static int method(char[] chars,char[] subChars){
        int res[][]=new int[subChars.length][chars.length];
        for(int i=0;i<res[0].length;i++){
           if(subChars[0]==chars[i]){
               res[0][i]=1;
           }
        }
        for(int j=0;j<res.length;j++){
            if(subChars[j]==chars[0]){
                res[j][0]=1;
            }
        }
        for(int i=1;i<res.length;i++){
            for(int j=1;j<res[0].length;j++){
                if(subChars[i]==chars[j]){
                    res[i][j]=res[i-1][j-1]+1;
                }else{
                    res[i][j]=Math.max(res[i-1][j],res[i][j-1]);
                }
            }
        }
        return res[subChars.length-1][chars.length-1];
    }
}
