package com.zto.algorithm;

/**
 * Created by xujun on 2018-08-31.
 */
public class String_Comb
{
    /*全组合，abc各个位是否选取，一共有2^n（0~2^3-1）
    * abc 111，用0表示选取，用1表示不选取
    * */
    public static void comb(String str){
        char[] chs = str.toCharArray();
        int combNum = 1 << chs.length;//组合的个数有2^n的长度
        int k;
        for(int i = 0; i<combNum; i++){
            for(int j = 0; j<chs.length; j++){
                k = 1<<j;
                if((k&i)!=0){//按位与运算，如果结果为1就输出当前位，结果为0不输出
                    System.out.print(chs[j]);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        String str = new String("abc");
        comb(str);
    }
}

