package com.niuke;

import java.util.Arrays;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/1/5
 */
public class MinMoney {
    public static void main(String[] args) {
         int[] res=new int[]{1,2,5,4};
        int result = getResult(res, 10);
        System.out.println(result);
    }
    public static  int getResult(int[] res,int target){
        if(target==0){
            return 0;
        }
        int result=Integer.MAX_VALUE;
        int[][] arrays=new int[res.length+1][target+1];
        for(int i=0;i<arrays.length;i++){
            arrays[i][0]=0;
        }
        for(int j=0;j<arrays[0].length;j++){
            arrays[0][j]=0;
        }
        Arrays.sort(res);
        for(int i=1;i<arrays.length;i++){
            for(int j=1;j<arrays[0].length;j++){
                if(j%res[i-1]==0&&arrays[i-1][j-(j/res[i-1])*res[i-1]]==0) {//元素整除且余数为0
                    if(arrays[i-1][j]!=0){
                        arrays[i][j] = Math.min(arrays[i - 1][j - (j / res[i - 1]) * res[i - 1]] + j / res[i - 1],arrays[i-1][j]);
                    }else {
                        arrays[i][j] = arrays[i - 1][j - (j / res[i - 1]) * res[i - 1]] + j / res[i - 1];
                    }
                }else if(j%res[i-1]!=0&&arrays[i-1][j-(j/res[i-1])*res[i-1]]!=0){//有余数且余数为不为0
                    if(arrays[i-1][j]!=0) {
                        arrays[i][j] = Math.min(arrays[i - 1][j - (j / res[i - 1]) * res[i - 1]] + j / res[i - 1], arrays[i - 1][j]);
                    }else{
                        arrays[i][j] = arrays[i - 1][j - (j / res[i - 1]) * res[i - 1]] + j / res[i - 1];
                    }
                }else {
                    arrays[i][j]= arrays[i-1][j];
                }
            }
            if(arrays[i][arrays[0].length-1]<result){
                result=arrays[i][arrays[0].length-1];
            }
        }
        if(result==0){
            result=-1;
        }
        return result;
    }
}
