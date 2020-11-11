package study.learning.array;

public class FindDataRange {
    public static void main(String[] args) {
        int[] nums= new int[]{1,3};
        int[] res=findDataRange(nums,1);
        System.out.println("end");
    }
    public static int[] findDataRange(int[] nums,int target){
        int[] results= new int[2];
        int start=0;
        int end=nums.length-1;
        if(nums.length==0) {
            results[0]=-1;
            results[1]=-1;
            return results;
        }else if(nums.length==1){
            if(nums[0]!=target){
               results[0]=-1;
               results[1]=-1;
            }else{
                results[0]=0;
                results[1]=0;
            }
            return results;
        }else if(target<nums[start]||target>nums[end]){
            results[0]=-1;
            results[1]=-1;
            return results;
        }else if(target==nums[start]&&target==nums[end]){
            results[0]=start;
            results[1]=end;
            return results;
        }
        results[0]=-1;
        results[1]=-1;
         while(start<=end){
             int middle=(start+end)/2;
             int p=middle;
             int q=middle;
             if(nums[middle]==target){
                 while (p>=0&&nums[p]==nums[middle]){
                     results[0]=p;
                     p--;
                 }
                 while (q<nums.length&&nums[q]==nums[middle]){
                     results[1]=q;
                     q++;
                 }
                 Integer.valueOf('1'+"");


                 return results;
             }else if(nums[middle]>target){
                 end=middle-1;
             }else if(nums[middle]<target){
                 start=middle+1;
             }
        }
        return results;
    }
}
