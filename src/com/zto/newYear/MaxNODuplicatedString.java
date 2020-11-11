package com.zto.newYear;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xujun on 2019-02-13.
 */
public class MaxNODuplicatedString {
    public static void main(String[] args) {
        String str="abcaccdefmg";
        Map<String,Integer> hash=new HashMap<String,Integer>();
        int res=getLength(str,hash);
        System.out.println(res);
    }
    public static int getLength(String len,Map<String,Integer> map){
        char[] chars=len.toCharArray();
        int current=0;
        int length=0;
        int result=0;
        for(int i=0;i<chars.length;i++){
          String key=String.valueOf(chars[i]);
          if(map.containsKey(key)) {
              current=map.get(key)+1;
          }else{
             length=i-current+1;
             if(length>result){
                 result=length;
             }
          }
          map.put(key,i);
        }
        return result;
    }
}
