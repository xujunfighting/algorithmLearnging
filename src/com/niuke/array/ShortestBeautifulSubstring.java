package com.niuke.array;

/**
 * @Author xujun
 * @Description 2904
 * @Date 2023/10/22 16:21
 */
public class ShortestBeautifulSubstring {
    public static void main(String[] args) {
         String s="00101100110010110";
        String result = getResult(s, 6);
        System.out.println(result);
    }

    /**
     * 计算最短美丽数组 则前后元素都是从1开始和结尾  且子字符串中的1的个数等于k
     * 同时需要满足字典序最小的话 0越靠前越好  在计算字符串是否满足过程中，每次判断等于1同时计算字典序的值
     * 根据数值的二进制可知 011的值3小于100的值4    
     * @param s
     * @param k
     * @return
     */
    public static String getResult(String s,int k){
        char[] chars = s.toCharArray();
        String res="";
        String curRes="";
        int curCount=0;
        double totalIndex=0;
        double curTotalIndex=0;
        for(int i=0;i<chars.length;i++){
             if(chars[i]=='0'){
                 continue;
             }
             curCount=1;
             curRes="";
             curTotalIndex=0;
             curRes+=chars[i]+"";
             if(k==1){
                 return curRes;
             }
            for(int j=i+1;j<chars.length;j++){
                curRes+=chars[j]+"";
                if(chars[j]=='1'){
                    curCount++;
                    curTotalIndex+=1<<(k+i-j);
                }
                if(curCount==k){
                    System.out.print("curStr:"+curRes+"  ");
                    System.out.println("curindex:"+curTotalIndex);
                    if(res==""||res.length()>curRes.length()||(res.length()==curRes.length()&&curTotalIndex<totalIndex)){
                        res=curRes;
                        totalIndex=curTotalIndex;
                    }
                    break;
                }
            }
        }
        return res;
    }

}
