package com.niuke.array;

/**
 * @Author xujun
 * @Description
 * @Date 2023/8/13 10:23
 */
public class AccountBalanceAfterPurchase {
    public static void main(String[] args) {
        int result = getResult(11);
        System.out.println(result);
    }

    public static int getResult(int purchaseAmount){
        if(purchaseAmount%10==0){
            return 100-purchaseAmount;
        }else if(purchaseAmount%10>=5){
            return 100-(purchaseAmount/10+1)*10;
        }else{
            return 100-(purchaseAmount/10)*10;
        }
    }
}
