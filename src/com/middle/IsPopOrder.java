package com.middle;

import java.util.Stack;

public class IsPopOrder {
    public static void main(String[] args) {
             int[] order=new int[]{1,2,3,4,5};
             int[] pop=new int[]{4,5,3,2,1};
             boolean res=getResult(order,pop);
             System.out.println(res);

    }
    public static boolean getResult(int[] order,int pop[]) {
          boolean result=true;
          int start1=0;
          int index=0;
          boolean isFlag=false;
          Stack<Integer> res= new Stack<>();
          while(start1<=order.length){
              isFlag=false;
              while(start1<order.length&&order[start1]!=pop[index]){
                  res.add(order[start1++]);
              }
              if(start1<order.length&&order[start1]==pop[index]){
                  isFlag=true;
                  start1++;
                  index++;
              }
              while(!res.isEmpty()&&res.peek()==pop[index]){
                  res.pop();
                  index++;
              }
              if(!isFlag) {
                  start1++;
              }
          }
          if(!res.isEmpty()){
              result=false;
          }
          return result;

    }
}
