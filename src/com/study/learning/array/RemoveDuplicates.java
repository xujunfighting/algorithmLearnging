package study.learning.array;

public class RemoveDuplicates {
    private static int count=1;
    private static int max=0;
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(nums);
        System.out.println(count);
    }
    public static int removeDuplicates(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>=nums[j]||nums[j]<=max){
                    continue;
                }else{
                    count++;
                    nums[i+1]=nums[j];
                    max=nums[j];
                    break;
                }
            }
        }
        return count;
    }
}
