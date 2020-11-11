package study.learning.array;

import org.omg.PortableInterceptor.INACTIVE;

import javax.jnlp.ClipboardService;
import java.util.*;

public class ThreeNumberSumZero {
    private static List<List<Integer>> lists = new ArrayList<>();
    private static List<Integer> list= new ArrayList<>();
    private static int[] rest=null;
    private static int cur=0;
    public static void main(String[] args) {
        int[] nums =  new int[]{-5,5,4,-3,0,0,4,-2};
        lists=threeSum(nums);
        System.out.println("end");
    }
    public static void method(int[] nums,int start,int sum,int count){
       if(sum==0&&count==0){
           if(removeSameData(lists,list)) {
               lists.add(new ArrayList<>(list));
           }
       }
       if(count==0||start>nums.length) return;
       for(int i=start;i<nums.length;i++){
           sum-=nums[i];
           count--;
           list.add(nums[i]);
           method(nums,i+1,sum,count);
           count++;
           list.remove(list.size()-1);
           sum+=nums[i];
       }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
      if(nums.length==0) return lists;
      method(nums,0,4,4);
      return lists;
    }
    public static boolean removeSameData(List<List<Integer>> lists,List<Integer> list){
        if(lists.isEmpty()) return true;
        boolean contains=true;
          list.sort(Integer::compareTo);
          for(List<Integer> integerList:lists) {
              int p = 0;
              int q = 0;
              contains=false;
              integerList.sort(Integer::compareTo);
              while (p < integerList.size() && q < list.size()) {
                  if (integerList.get(p) != list.get(q)) {
                      contains=true;
                      break;
                  }
                  p++;
                  q++;
              }
              if(contains==false){
                  return contains;
              }
          }
       return contains;
    }

}
