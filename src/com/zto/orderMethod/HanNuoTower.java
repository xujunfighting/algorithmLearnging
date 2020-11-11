package com.zto.orderMethod;

/**
 * Author xujun
 * Create date 2019-07-31.
 * desc:
 */
public class HanNuoTower {
    public static void main(String[] args) {
       String[] str=new String[]{"A","B","C"};
       int index=3;
       hanMethod("A","B","C",3);
    }
    public static void hanMethod(String a,String b,String c,int index){
      if(index==1){
          print(a,c,index);
      }else{
          hanMethod(a,c,b,index-1);
          print(a,c,index);
          hanMethod(b,a,c,index-1);
      }
    }
    public static void print(String from,String to,int index){
        System.out.println(index+" from "+from+" to "+to);
    }

}
