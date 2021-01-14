package com.niuke;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/1/13
 */
public class MoveNLenArray {
    public static void main(String[] args) {
        int[] res=new int[]{1,2,3,4,5,6};
        int[] result = getResult(6, 2, res);
        print(result);
    }
    public static int[] getResult(int len,int index,int[] res){
        if(index>len){
            index=index%len;
        }
        if(index==0){
            return  res;
        }
        int[] result= new int[res.length];
        for(int i=0;i<res.length;i++){
            result[(i+index)%len]=res[i];
        }
        return result;
    }
    public static void print(int[] res){
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
