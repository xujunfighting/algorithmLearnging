package study.learning.array;

public class MaxProfit {
    static int max=0;
    static int cur=0;
    public static int maxProfit(int[] prices) {
        for(int k=prices.length-1;k>=1;k--){
            int i=k;
            while(i>=1){
                for(int j=i-1;j>=0;j--){
                    if(prices[i]>prices[j]){
                        cur+=prices[i]-prices[j];
                        i=j;
                        break;
                    }
                }
                i--;
            }
            if(cur>max){
                max=cur;
            }
            cur=0;
        }
        return max;
    }

    public static int maxDiff(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int min=nums[0];
        int share=0;
        for(int i=1;i<nums.length;i++) {
            if(nums[i]<min)
                min=nums[i];
            int cs=nums[i]-min;
            if(cs>share)
                share=cs;
        }
        return share;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,7,4,5};
        int res = maxDiff(nums);
        System.out.println(res);
    }
}
