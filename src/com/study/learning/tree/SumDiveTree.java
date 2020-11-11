package study.learning.tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
public class SumDiveTree {
    private  static int result=0;
    public static void main(String[] args) {
        int[] nums= new int[]{3,6,5};
        int res=method(nums);
        System.out.println(res);
    }
    public static int sumDivTree(int[] nums){
        int sum=0;
        int start=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        Queue<Integer> queen= new LinkedBlockingQueue<Integer>();
        Queue<Integer> cal=new LinkedBlockingQueue<>();
        Queue<Integer> number= new LinkedBlockingQueue<>();
        int count=addQueue(nums,queen);
        while(!queen.isEmpty()){
            int data=queen.poll();
            if((sum-nums[data])%3==0){
               if(result<(sum-nums[data])){
                   result=sum-nums[data];
               }
            }
            number.add(data);
            cal.add(addQueue(nums,queen));
            count--;
            if(count==0){
                count=cal.poll();
                sum-=nums[number.poll()];
            }
        }
        return result;
    }
    public static int addQueue(int[] sums,Queue<Integer> queue){
        if(0>=sums.length) return 0;
        int count=0;
        for(int i=0;i<sums.length;i++){
            queue.offer(i);
            count++;
        }
        return count;
    }
    public static int method(int[] nums){
        int[] dp = new int[3];
        for(int i = 0 ; i < nums.length ; i ++){
            int mod = nums[i] % 3;
            int a = dp[(3 + 0 - mod) % 3];
            int b = dp[(3 + 1 - mod) % 3];
            int c = dp[(3 + 2 - mod) % 3];
            if (a!=0 || mod == 0) dp[0] = Math.max(dp[0], a + nums[i]);
            if (b!=0 || mod == 1) dp[1] = Math.max(dp[1], b + nums[i]);
            if (c!=0 || mod == 2) dp[2] = Math.max(dp[2], c + nums[i]);
    }
        return dp[0];

    }
    public static  void method2(int[] sums){
        Arrays.sort(sums);
        int start=0;
        int end=sums.length;
        while(start<=end){
            int temp=sums[start];
            sums[start]=sums[end];
            sums[end]=temp;
            start++;
            end--;
        }
        int res=0;
        Queue<Integer> q1= new LinkedBlockingQueue<Integer>();
        Queue<Integer> q2= new LinkedBlockingQueue<Integer>();
        for(int i=0;i<sums.length;i++){
            if(sums[i]%3==0){
                res+=sums[i];
            }
            if(sums[i]%3==1){
                q1.offer(sums[i]);
            }
            if(sums[i]%3==2){
                q2.offer(sums[i]);
            }
            if(!q1.isEmpty()&&!q2.isEmpty()){
                res+=q1.poll()+q2.poll();
            }
        }

    }
}
