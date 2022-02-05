package com.niuke.array;

/**
 * @author xujun
 * @date 2022-01-02
 **/
public class LastRemains {
    public static void main(String[] args) {
        int n=10;
        int result = getResult(n);
        System.out.println(result);
    }

    public static int getResult(int n){
        if(n==1){
            return 1;
        }
        int  sum=(1+n)*n/2;
        int count=n;
        int start=1;
        int end=n;
        int index=1;
        int dif=1;
        while(start<end){
            //判断总数是奇数还是偶数
            int preCount=count;
            count=(count%2)==0?count/2:(count/2)+1;
            if(index%2==1){
                //从左到右
                if(count==1){
                    return end;
                }
                end=(preCount%2==0)?end:end-dif;
            }
            if(index%2==0){
                if(count==1){
                    return start;
                }
                start=(preCount%2==0)?start+dif:start;
            }
            sum-=(start+end)*count/2;
            count=n-count;
            n=count;
            if(index%2==1){
                //从左到右
                if(count==1){
                    return sum;
                }
                end=(preCount%2==0)?end-dif:end;
                start+=dif;
            }
            if(index%2==0){
                if(count==1){
                    return sum;
                }
                start=(preCount%2==0)?start:start+dif;
                end-=dif;
            }
            dif=dif*2;
            index++;
        }
        return sum;
    }
}
