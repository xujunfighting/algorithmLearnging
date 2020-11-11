package study.learning.array;

public class MaxSequenceValue {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,-3,4,0,-5};
        int res=getResult(nums);
        System.out.println(res);
    }
    public static int getResult(int[] nums){
        int max=0;
        int cur=0;
        for(int i=0;i<nums.length;i++){
            if(cur>=0){
                cur+=nums[i];
                if(cur>max){
                    max=cur;
                }
            }else{
                cur=0;
            }
        }
        return max;
    }
}
