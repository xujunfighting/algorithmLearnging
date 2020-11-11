package com.zto.orderMethod;

/**
 * Author xujun
 * Create date 2019-07-31.
 * desc:
 */
public class LongestPalindromicString {
    public static void main(String[] args){
        String str="babab";
        String max=method(str.toCharArray());
        System.out.println(max);
    }
    public static String method(char[] chars){
       int[][] bool=new int[chars.length][chars.length];
       int len=bool.length;
       for(int i=0;i<len;i++){
           bool[i][i]=1;
       }
       for(int j=1;j<len;j++){
           for(int i=1;i<len;i++){
               if(j-i>=0&&j+i<len&&chars[j-i]==chars[j+i]){
                   bool[j][j]=bool[j][j]+1;
               }
           }
       }
      int max=0;
      int index=0;
        for(int i=0;i<len;i++){
            if(bool[i][i]>max){
                max=bool[i][i];
                index=i;
            }
        }
        String str=chars[index]+"";
        for(int k=1;k<=(max-1);k++){
           str=chars[index-k]+str+chars[index+k];
        }
       return str;
    }
}
