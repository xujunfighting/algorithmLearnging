package com.baidu;


import org.omg.CORBA.INTERNAL;

import javax.swing.text.SimpleAttributeSet;
import java.util.Stack;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/9/6
 */
public class SubStringMatch {
    public static void main(String[] args) {
       String test1="3[abc]2[de]";
       String test2="3[a2[c]]";
       String test3="2[ac]3[def]mn";
       char[] chars=test2.toCharArray();
        StringBuffer result = getResult(chars, 0, chars.length - 1);
        System.out.println(result.toString());
    }
    public static StringBuffer getResult(char[] chars,int start,int end){
        StringBuffer sb=new StringBuffer();
        Stack<Integer> stacks=new Stack<>();//记录角标
        Stack<Integer> integers=new Stack<>();
        for(int i=start;i<=end;i++){
          if(chars[i]=='['){//匹配到字符串开始
              stacks.add(i);
          }
          if(chars[i]==']'){//匹配到字符串结束
              while(chars[i]==']') {
                  Integer pop = stacks.pop();
                  Integer count = integers.pop();
                  String string = concatString(chars, pop + 1, i - 1);
                  for (int v = 0; v < count; v++) {
                      sb.append(string);
                  }
                  if(chars[i+1]==']'){
                      i++;
                  }else{
                      break;
                  }
              }
          }
          if(chars[i]>='0'&&chars[i]<='9'){
              integers.add(chars[i]-'0');
          }
          if(integers.isEmpty()&&(chars[i]<'0'||chars[i]>'9')&&chars[i]!=']'&&chars[i]!='['){
              sb.append(chars[i]+"");
          }
        }
        return sb;
    }
    public static String concatString(char[] chars,int start,int end){
        StringBuffer sb=new StringBuffer();
        for(int i=start;i<=end;i++){
            sb.append(chars[i]+"");
        }
        return sb.toString();
    }
}
