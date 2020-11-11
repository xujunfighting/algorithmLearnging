package com.middle;

public class MatchMethod {
    public static void main(String[] args) {
        String s1="aaa";
        String s2="ab*ac*a";
        match(s1.toCharArray(),s2.toCharArray());
    }
    public static boolean match(char[] chars,char[] pattern){
        int n1=0;//用于统计.的个数
        int n2=0;//用于统计*的个数
        int n3=0;//用于统计其他的字符个数
        int len1=chars.length;
        boolean result=true;
        int[] index=new int[pattern.length];
        StringBuffer sb= new StringBuffer();//统计*出现的位置
        int j=0;
        for(int i=0;i<pattern.length;i++){
            if(pattern[i]=='.'){
                n1++;
                sb.append(pattern[i]);
            }else if(pattern[i]=='*'){
                n2++;
                index[j]=i;
                sb=new StringBuffer(sb.substring(0,sb.toString().length()-1));
            }else{
                n3++;
                sb.append(pattern[i]);
            }
        }
        if(n3+n1-n2>len1){
            result=false;
        }else if(n3+n1-n2==len1){
                char[] newChars=sb.toString().toCharArray();
               for(int v=0;v<chars.length;v++){
                  if(chars[v]==newChars[v]||newChars[v]=='.'){
                      continue;
                  }else{
                      result=false;
                      break;
                  }
               }
        }else{
            int num=len1-(n2+n1-n2);

        }
      return result;
    }
}
