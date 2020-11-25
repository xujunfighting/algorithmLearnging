package com.niuke;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/11/11
 */
public class LongestCommonSubString {
    public static void main(String[] args) {
        String s1="123451234";
        String s2="1";
        String result = getResult(s1, s2);
        System.out.println(result);
    }
    public static String  getResult(String s1,String s2){
         String result="";
         StringBuffer sb=new StringBuffer();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[][] array=new int[chars1.length+1][chars2.length+1];
        for(int i=0;i<chars1.length;i++){
            array[i][0]=0;
        }
        for(int j=0;j<chars2.length;j++){
            array[0][j]=0;
        }
        int max=0;
        int start=0;
        int end=0;
        for(int i=1;i<chars1.length+1;i++){
            for(int j=1;j<chars2.length+1;j++){
                if(chars1[i-1]==chars2[j-1]){
                    array[i][j]=array[i-1][j-1]+1;
                    if(array[i][j]>max){
                        max=array[i][j];
                        start=j-max;
                        end=j-1;
                    }
                }
            }
        }
        if(max==0){
           result="-1";
        }else{
           for(int i=start;i<=end;i++){
               sb.append(chars2[i]);
           }
           return sb.toString();
        }
        return result;
    }
}
