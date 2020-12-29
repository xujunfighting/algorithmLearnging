package com.niuke;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/28
 */
public class GetLowTotalWater {
    public static void main(String[] args) {
       int[] res=new int[]{1000000000,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2};
        int result = getResult(res);
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
}
