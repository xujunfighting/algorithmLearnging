package com.niuke.array;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/28
 */
public class GetLowTotalWater {
    public static void main(String[] args) {
        //[1,8,6,2,5,4,8,3,7]
        //1,8,100,2,100,4,8,3,7
        //[6,4,3,1,4,6,99,62,1,2,6]
        //[1,1000,1000,6,2,5,4,8,3,7]
       int[] res=new int[]{6,4,3,1,4,6,99,62,1,2,6};
        int result = getResultEnhance(res);
        System.out.println(result);
    }
    public  static int getResult(int[] res){
      int result=0;
      if(res==null||res.length==1||res.length==2){
          return result;
      }
      int start=res[0];//以最左端为第一个桶的低位
      int end=res.length-1;//最右端最后一个桶的低位
      while(end-1>=0&&res[end-1]>=res[end]){//查找第一个可以使用的末尾节点
          end--;
      }
      if(res==null||res.length==1||res.length==2){
            return result;
      }
      int temp=0;
      int count=0;//数据补偿
      int i=1;
      while(i<=end){
          if(i!=end&&res[i]>start){
              start=res[i];
              result+=temp;
              temp=0;//数据重置
              count=0;//数据重置
          }else if(i!=end&&res[i]<=start){
              temp+=start-res[i];
              count++;
          }else if(i==end&&res[i]<start){//进行补偿
              temp-=(count*(start-res[i]));
              result+=temp;
              return result;
          }
          i++;
      }
      return result;
    }

    /**
     *查找左右两个节点保证形成的矩形盛水最多
     */
    public  static int getResultEnhance(int[] res){
        int result=0;
        if(res==null||res.length==1){
            return result;
        }
        int start=0;
        int end=res.length-1;

        while(start<end){
            result=Math.max(result,Math.min(res[start],res[end])*(end-start));
            /**
             * 将左右指针进行收缩 选择两者之间较小的值进行内缩
             * 向内收缩长度减小的同时 只有竖板的高度变高才能保证盛水的体积变大
             */
            if(res[start]>res[end]){
                end--;
            }else{
                start++;
            }
        }
        return result;
    }
}
