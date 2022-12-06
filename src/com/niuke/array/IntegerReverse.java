package com.niuke.array;

public class IntegerReverse {
    public static void main(String[] args) {
       //123
        int reverse = reverse(1534236469);
        System.out.println(reverse);

    }

    public static int reverse(int val){
        if(val==0){
            return val;
        }
        Double result=0.0;
        if(val>0){
            while(val>0){
                int cur=val%10;
                val=val/10;
               result=result*10+cur;
            }
        }else{
           val=-val;
            while(val>0){
                int cur=val%10;
                val=val/10;
                result=result*10+cur;
            }
            result=-result;
        }
        if(result>new Double(Integer.MAX_VALUE)||result<new Double(Integer.MIN_VALUE)){
            return 0;
        }
        return result.intValue();
    }
}
