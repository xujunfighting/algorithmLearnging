package study.learning.dynamicProgramming;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;

public class CheckSubArraySum {
    public static void main(String[] args) {
        int[] sums= new int[]{0,1,0};
        boolean res=checkSubarraySum(sums,0);
        System.out.println(res);
    }
    public static boolean checkSubarraySum(int[] sums, int k) {

        if(sums.length==0||sums.length==1) return false;
        for(int i=0;i<sums.length-1;i++){
            int[][] nums=new int[1][sums.length];
            nums[0][i]=sums[i];
            for(int j=i+1;j<sums.length;j++){
                nums[0][j]=nums[0][j-1]+sums[j];
                if(nums[0][j]==0&&k==0){
                    return true;
                }else if(nums[0][j]!=0&&k==0){
                    continue;
                }else if(nums[0][j]%k==0){
                    return true;
                }
            }
        }
        return false;
    }
//    public static boolean  checkSubarraySum1(int[] sums,int k){
//        HashMap<Integer, Integer> maps= new HashMap<>();
//        int sum=0;
//        for(int i=0;i<sums.length;i++){
//            sum+=sums[i];
//            maps.put(sum%k,i);
//
//        }
//    }
}
