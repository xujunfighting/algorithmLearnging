package com.baidu;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/9/12
 */
public class FindMinNumberNotExists {
    public static void main(String[] args) {
      int[] res=new int[]{1, 1, 4};
        int result = getResult(res);
        System.out.println(result);
    }
    public static int getResult(int[] res){
        int result=1;
        for(int i=0;i<res.length;i++){
            if(res[i]<0){
                continue;
            }
            if(res[i]==result){
                result++;
            }
        }
        return result;
    }
}
