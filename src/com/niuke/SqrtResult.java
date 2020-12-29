package com.niuke;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/29
 */
public class SqrtResult {
    public static void main(String[] args) {
        int result = getResult(27);
        System.out.println(result);

    }
    public static int getResult(int x){
        if(x==0){
            return 0;
        }
        if(x==1){
            return 1;
        }
        int end=x%2==0?x/2:x/2;
        for(int i=1;i<=end;i++){
            if(i*i<=x&&(i+1)*(i+1)>x){
                return i;
            }
        }
        return 0;
    }
}
