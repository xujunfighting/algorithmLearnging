package com.baidu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/20
 */
//3[a]2[bc]
//3[a2[c]]
//2[abc]3[cd]ef
public class StringMatch2 {
    public static void main(String[] args) {
        String test="2[abc]3[cd]ef";
        getResult(test);
    }
    public static String getResult(String test){
       String result="";
        char[] chars = test.toCharArray();
        //level number String
        LinkedList<LevelString> levelStrings=new LinkedList<>();
        int level=0;
        StringBuffer number=new StringBuffer();
        StringBuffer sb=new StringBuffer();
        for(int i=chars.length-1;i>=0;i--){
          if(chars[i]==']'){
              LevelString levelString=new LevelString(level,1,sb.reverse().toString());
              levelStrings.add(levelString);
               sb=new StringBuffer();
               level++;
           }else if(chars[i]=='['){//归零操作
              while(i-1>=0&&chars[i-1]>='0'&&chars[i-1]<='9'){
                  number.append(chars[--i]+"");
              }
              LevelString levelString=new LevelString(level--,Integer.valueOf(number.toString()),sb.reverse().toString());
                   int curLevel=levelString.level+1;
                   for(LevelString levelStr:levelStrings){
                       if(levelStr.level==curLevel){
                           levelString.result.add(levelStr);
                           levelStrings.remove(levelStr);
                       }
                   }
               levelStrings.add(levelString);
               sb=new StringBuffer();
               number=new StringBuffer();
           }else{
               sb.append(chars[i]+"");
           }
        }
        return result;
    }
    private static class LevelString{
        public int level;
        public int number;
        public String sub;
        public List<LevelString> result=new ArrayList<>();
        public LevelString(int level, int number, String sub) {
            this.level = level;
            this.number = number;
            this.sub = sub;
        }
    }
}
