package com.niuke;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/29
 */
public class DistributeCandy {
    public static void main(String[] args) {
        int[] res=new int[]{1,1,1,1};
        int result = getResult(res);
        System.out.println(result);
    }
    private static int getResult(int[] args){
        int result=0;
        int max=100000;
        int min=max;
        result+=max;
        for(int i=1;i<args.length;i++){
            if(args[i]>args[i-1]){
                max++;
            }else if(args[i]<args[i-1]){
                max--;
            }
            if(max<min){
                min=max;
            }
            result+=max;
        }
        result-=args.length*(min-1);
        return result;
    }
}
