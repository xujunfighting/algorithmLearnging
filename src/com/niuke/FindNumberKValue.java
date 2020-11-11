package com.niuke;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/11/3
 */
public class FindNumberKValue {
    public static void main(String[] args) {
          int[] res=new int[]{4,2,7,6,5,1,3};
          int[] result=handleArray(res);
          getResult(result,2);
    }
    public  static  int getResult(int[] res,int k){
        int result=0;
           for(int i=1;i<=k;i++){
              result = buildDump(res, res.length-i);
              int change=res[1];
              res[1]=res[res.length-i];
              res[res.length-i]=change;
           }
           return result;
    }
    public static int buildDump(int[] res,int len){
        int result=0;
        for(int i=len/2;i>=1;i--){
            if(i*2+1<=len){
                //存在左右子树
                int temp=res[i];
                int min=Math.min(res[i*2],res[i*2+1]);
                if(min<temp){
                    if(res[i*2]<res[i*2+1]){
                        res[i]=res[i*2];
                        res[i*2]=temp;
                    }else{
                        res[i]=res[i*2+1];
                        res[i*2+1]=temp;
                    }
                }
            }else{//只存在左子树
                int temp=res[i];
                if(res[i*2]<temp){
                    res[i]=res[i*2];
                    res[i*2]=temp;
                }
            }
        }
        result=res[1];
        System.out.println(result);
        return result;
    }
    public static int[] handleArray(int[] res){
        int[] result=new int[res.length+1];
        result[0]=0;
        for(int i=0;i<res.length;i++){
            result[i+1]=res[i];
        }
        return result;
    }
}
