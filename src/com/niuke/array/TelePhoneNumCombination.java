package com.niuke.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/8
 **/
public class TelePhoneNumCombination {
    static List<String> lists=new ArrayList<>();
    static  List<String> list=new ArrayList<>();
    public static void main(String[] args) {
       String digest="23";
        List<String> result = getResult(digest);
        System.out.println(result);
    }
    public static List<String> getResult(String digest){

        if(digest.length()==0){
            return lists;
        }
        int len=digest.length();
        String[] strs=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<Integer> integers=new ArrayList<>();
        char[] chars = digest.toCharArray();
        for(int i=0;i<len;i++){
            integers.add(Integer.parseInt(chars[i]+""));
        }
        method(strs,0,integers);

        return lists;
    }
    public static void method(String[] strs,int start,List<Integer> integerList){
        if(start>=integerList.size()){
               String s="";
               for(String str:list){
                   s+=str;
               }
              lists.add(s);
              return;
        }
        char[] chars = strs[integerList.get(start)].toCharArray();
        for(int i=0;i<chars.length;i++){
            list.add(chars[i]+"");
            start++;
            method(strs,start,integerList);
            start--;
            list.remove(list.size()-1);
        }
    }
}
