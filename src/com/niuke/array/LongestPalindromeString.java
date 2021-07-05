package com.niuke.array;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/1
 **/
public class LongestPalindromeString {
    public static void main(String[] args) {
         String s="cbbd";
        String result = getResult(s);
        System.out.println(result);

    }
    public static String getResult(String s){
        if(s.length()==1){
            return s;
        }
        char[] chars = s.toCharArray();
        int[][] ints=new int[chars.length][chars.length];
        for(int i=0;i<chars.length;i++){
            ints[i][i]=1;
        }
        int start=0;
        int end=0;
        int j=0;
        for(int i=1;i<chars.length;i++){
            for(j=i-1;j>=0;j--){
                if(chars[i]==chars[j]&&ints[i-1][j+1]>0){
                    ints[i][j]=ints[i-1][j+1]+2;

                }else if(chars[i]==chars[j]&&i-j==1){
                    ints[i][j]=ints[i][i]+1;
                }

            }
            if(ints[i][j+1]>(end-start)){
                start=j+1;
                end=i;
            }
        }
       return s.substring(start,end+1);
    }
}
