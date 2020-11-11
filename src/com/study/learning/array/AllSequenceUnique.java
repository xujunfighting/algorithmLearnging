package study.learning.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSequenceUnique {
    private static List<List<Integer>> lists= new ArrayList<>();
    public static void main(String[] args) {
       int[] nums= new int[]{-1,2,-1,2,1,-1,2,1};
        Arrays.sort(nums);
       method(nums,0);
        System.out.println("end");
    }
    public static void method(int[] nums,int start){
      if(start>=nums.length){
          List<Integer> list = new ArrayList<>();
          for(int i=0;i<nums.length;i++){
              list.add(nums[i]);
          }
          lists.add(new ArrayList<>(list));
          return;
      }
      int swap=Integer.MAX_VALUE;
      for(int i=start;i<nums.length;i++){
          if(i!=start&&nums[i]==nums[start]||nums[i]==swap){
              continue;
          }
          swap=nums[i];
          swap(nums,i,start);
          method(nums,start+1);
          swap(nums,i,start);
      }
    }
    public static void swap(int[] nums,int p,int q){
        int temp=nums[p];
        nums[p]=nums[q];
        nums[q]=temp;
    }
}
