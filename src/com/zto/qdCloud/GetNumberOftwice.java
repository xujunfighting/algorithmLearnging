package com.zto.qdCloud;

/**
 * Author xujun
 * Create date 2019-04-26.
 * desc:
 */
public class GetNumberOftwice {
    public static void main(String[] args) {
        int[] a=new int[]{1,2,2,3,4,5,6,7,8};
        int[] auxiliary=new int[a.length];
        int res=getNumberOftwice(a,auxiliary);
        System.out.println(res);
    }
    public static int getNumberOftwice(int[] a,int[] b){
      for(int i=0;i<a.length;i++){
          if(a[i]!=b[a[i]]){
              b[a[i]]=a[i];
          }else{
              return a[i];
          }
      }
      return 0;
    }
}
