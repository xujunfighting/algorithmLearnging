package com.zto.newHope;

/**
 * Author xujun
 * Create date 2019-06-21.
 * desc:
 */
public class MaxCommonSequence {
    public static void main(String[] args) {
       String char1=new String("ABC");
       String char2=new String("ABCD");
       char[] chars1=char1.toCharArray();
        char[] chars2=char2.toCharArray();
        int res=getResult(chars1,chars2);
        System.out.println(res);
    }
    public static int getResult(char[] chars1,char[] chars2){
        int[][] chars=new int[chars1.length+1][chars2.length+1];
         for(int i=1;i<=chars1.length;i++){
             for(int j=1;j<=chars2.length;j++){
                 if(chars1[i-1]==chars2[j-1]){
                     chars[i][j]=chars[i-1][j-1]+1;
                 }else{
                     if(chars[i-1][j]>chars[i][j-1]){
                         chars[i][j]=chars[i-1][j];
                     }else{
                         chars[i][j]=chars[i][j-1];
                     }
                 }
             }
         }
        return chars[chars.length-1][chars[0].length-1];
    }
}
