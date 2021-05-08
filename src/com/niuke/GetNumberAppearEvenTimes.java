package com.niuke;

/**
 * @version v1.0.0
 * @Description
 * n表示数组的长度  只能填写1-4这几个数值需要保存偶数出现的次数为偶数次
 * @Author xujun
 * @Since 1.0
 * @Date 2021/5/8
 **/
public class GetNumberAppearEvenTimes {
    private static int[] numbers=new int[]{1,2,3,4};
    /**
     * 用于计数判断偶数的个数
     */
    private static int count=0;
    private static int result=0;
    public static void main(String[] args) {
      int[] arrays=new int[2];
      getResult(arrays,0);
        System.out.println(result);
    }
    public static void getResult(int[] arrays,int index){
        if(index>=arrays.length){
            /**
             * 判断数组中是否包含偶数个偶数
             */

            if(count%2==0){
                print(arrays);
                result++;
            }
            return;
        }
        for(int i=0;i<numbers.length;i++){
            arrays[index]=numbers[i];
            if(numbers[i]%2==0){
                count++;
            }
            index++;
            getResult(arrays,index);
            if(numbers[i]%2==0){
                count--;
            }
            index--;
        }
    }
    private static void print(int[] arrays){
        for(int i=0;i<arrays.length;i++){
            System.out.print(arrays[i]+" ");
        }
        System.out.println();
    }
}
