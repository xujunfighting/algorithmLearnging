package com.niuke;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/11/3
 */
public class FrogJump {
    public static void main(String[] args) {
        int result = getResult(4);
        System.out.println(result);

    }
    public static int getResult(int floor){
        if(floor==1){
            return 1;
        }
        if(floor==2){
            return 2;
        }
        int[] index=new int[floor+1];
        index[1]=1;
        index[2]=2;
        for(int i=3;i<=floor;i++){
            index[i]=index[i-1]+index[i-2];
        }
        return index[floor];
    }
}
